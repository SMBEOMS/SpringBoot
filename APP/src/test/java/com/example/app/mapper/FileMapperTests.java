package com.example.app.mapper;

import com.example.app.domain.vo.FileVO;
import groovy.util.logging.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class FileMapperTests {
    @Autowired
    private FileMapper fileMapper;

    @Test
    public void insertTest(){
        FileVO fileVO = new FileVO();
        fileVO.setBoardId(5193L);
        fileVO.setFileName("테스트 파일2.png");
        fileVO.setFileSize("0.5");
        fileVO.setFileUploadPath("2023/04/07");
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFileIsImage(true);
        fileMapper.insert(fileVO);
    }

    @Test
    public void delete(){
        fileMapper.delete(5193L);
        assertThat(fileMapper.selectAllByBoardId(5193L).size()).isEqualTo(0);
    }

    @Test
    public void selectAllByBoardIdTest(){
        assertThat(fileMapper.selectAllByBoardId(5193L).size()).isEqualTo(2);
    }
}
















