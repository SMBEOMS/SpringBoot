package com.example.app.task;

import com.example.app.domain.vo.FileVO;
import com.example.app.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileTask {

    private final FileService fileService;

    /*
    *   0 * * * * * : 매 분 0초마다
    *   0/1 * * * * : 매 1초 간격
    *   0 0/1 * * * : 매 1분 간격
    *   0 0 0/1 * * : 매 1시간 간격
    *   0 0 0 * * * : 매일 0시 마다
    *   0 0 0 1 * * : 매월 1일 마다
    *   * 10-13 * * * * : 매 10, 11, 12, 13분에 동작
    *
    * */
    
    @Scheduled(cron = "0/10 * * * * *")
    public void checkFiles() throws IOException {
        log.warn("File Checking Task Run................");
        log.warn("======================================");

//        DB에서 어제 날짜에 등록된 파일들 조회
        List<FileVO> filesOfYesterdayInDB = fileService.getFilesOfYesterday();
//        파일 객체를 Path객체로 변경
        List<Path> pathsOfYesterdayInDB = filesOfYesterdayInDB.stream()
                .map(file -> Paths.get("C:/upload", file.getFileUploadPath(), file.getFileUuid() + "_" + file.getFileName()))
                .collect(Collectors.toList());


//        이미지 파일을 추가로 담아주기
        filesOfYesterdayInDB.stream()
//                이미지 파일이라면
                .filter(FileVO::isFileIsImage)
//                기존 경로 앞에 t_를 붙여 썸네일 경로까지
                .map(file -> Paths.get("C:/upload", file.getFileUploadPath(), "t_" + file.getFileUuid() + "_" + file.getFileName()))
//                Path List에 추가해준다.
                .forEach(pathsOfYesterdayInDB::add);

        log.info("===============DB경로==========");
        pathsOfYesterdayInDB.stream().map(Path::toAbsolutePath).map(Path::toString).forEach(log::info);

//        실제 서버 경로를 File 객체에 담아준다.
        log.info("===============서버경로==========");
        log.info(getUploadPathOfYesterday());
        File filesInDirectory = Paths.get("C:/upload", getUploadPathOfYesterday()).toFile();
//        File객체는 해당 경로의 파일들을 List로 가져올 수 있으며, 조건식이 true일 경우만 가져온다.
//        DB에 없는 파일은 삭제한다.
        if(filesInDirectory.listFiles() != null){
            log.info("===============삭제경로==========");
            Arrays.asList(filesInDirectory.listFiles(file -> !pathsOfYesterdayInDB.contains(file.toPath()))).forEach(File::delete);
        }
    }

    private String getUploadPathOfYesterday(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        return simpleDateFormat.format(yesterday.getTime());
    }

}



















