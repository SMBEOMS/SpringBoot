package com.example.app.dao;

import com.example.app.domain.dao.FileDAO;
import com.example.app.domain.vo.FileVO;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class FileDaoTests {
    @Autowired
    private FileDAO fileDAO;

    @Test
    public void saveTest(){
        FileVO fileVO = new FileVO();
        fileVO.setBoardId(5193L);
        fileVO.setFileName("테스트 파일.png");
        fileVO.setFileSize("0.05");
        fileVO.setFileUploadPath("2023/04/08");
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFileIsImage(true);
        fileDAO.save(fileVO);
    }

    @Test
    public void deleteTest(){
        fileDAO.delete(5193L);
        assertThat(fileDAO.findAllByBoardId(5193L).size()).isEqualTo(0);
    }

    @Test
    public void findAllByBoardIdTest(){
        assertThat(fileDAO.findAllByBoardId(5193L).size()).isEqualTo(1);
    }
}
















