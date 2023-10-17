package com.example.app.service;

import com.example.app.domain.dao.FileDAO;
import com.example.app.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileDAO fileDAO;

//    파일 추가
    public void register(FileVO fileVO){
        fileDAO.save(fileVO);
    }

//    파일 삭제
    public void remove(Long boardId){
        fileDAO.delete(boardId);
    }

//    파일 개별 삭제
    public void removeFile(Long fileId) {
        fileDAO.deleteById(fileId);
    }

//    파일 목록
    public List<FileVO> getList(Long boardId){
        return fileDAO.findAllByBoardId(boardId);
    }

//    파일 업로드
    public List<FileVO> upload(List<MultipartFile> multipartFiles) throws IOException {
        String rootPath = "C:/upload";
        String todayPath = createDirectoryToday();
        File uploadPath = new File(rootPath, todayPath);
        List<FileVO> files = new ArrayList<>();

        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for (MultipartFile multipartFile : multipartFiles){
            FileVO fileVO = new FileVO();
            String uuid = UUID.randomUUID().toString();
            String fileName = multipartFile.getOriginalFilename();
            String fileSize = String.format("%.2f", multipartFile.getSize() / 1024.0);
            boolean isImage = multipartFile.getContentType().startsWith("image");

            fileVO.setFileUuid(uuid);
            fileVO.setFileName(fileName);
            fileVO.setFileUploadPath(todayPath);
            fileVO.setFileSize(fileSize);
            fileVO.setFileIsImage(isImage);

            File save = new File(uploadPath, uuid + "_" + fileName);
            multipartFile.transferTo(save);

            if(isImage) {
                FileOutputStream out = new FileOutputStream(new File(uploadPath, "t_" + uuid + "_" + fileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 100, 100);
                out.close();
            }

            files.add(fileVO);
        }
        return files;
    }

//    당일 날짜로 경로 제작
    private String createDirectoryToday(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

//    전일 파일 목록
    public List<FileVO> getFilesOfYesterday(){
        return fileDAO.findByYesterday();
    }
}
