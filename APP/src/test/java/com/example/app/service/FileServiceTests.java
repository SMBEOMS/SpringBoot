package com.example.app.service;

import com.example.app.domain.vo.FileVO;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class FileServiceTests {
    @Autowired
    private FileService fileService;

    @Test
    public void registerTest(){
        FileVO fileVO = new FileVO();
        fileVO.setBoardId(5193L);
        fileVO.setFileName("테스트 파일.png");
        fileVO.setFileSize("0.05");
        fileVO.setFileUploadPath("2023/04/08");
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFileIsImage(true);
        fileService.register(fileVO);
    }

    @Test
    public void removeTest(){
        fileService.remove(5193L);
        assertThat(fileService.getList(5193L).size()).isEqualTo(0);
    }

    @Test
    public void getListTest(){
        assertThat(fileService.getList(5193L).size()).isEqualTo(1);
    }
}
