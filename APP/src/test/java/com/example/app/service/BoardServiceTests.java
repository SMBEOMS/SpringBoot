package com.example.app.service;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.dto.Criteria;
import com.example.app.domain.dto.Search;
import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    BoardService boardService;

    @Test
    public void getBoardTest(){
        assertThat(boardService.getBoard(6L).getBoardContent()).isEqualTo("수정된 내용");
    }

    @Test
    public void getListTest(){
        Search search = new Search();
        Criteria criteria = new Criteria();

        search.setType("tcw");
        search.setKeyword("하하");

        criteria.setPage(1);
        criteria.create(boardService.getTotal(search));
        assertThat(boardService.getList(search, criteria).size()).isEqualTo(1);
    }

    @Test
    public void writeTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardTitle("테스트 제목4");
        boardDTO.setBoardWriter("테스트4");
        boardDTO.setBoardContent("테스트 내용4");

        boardService.write(boardDTO);

        assertThat(boardDTO.getBoardId()).isEqualTo(6L);
    }

    @Test
    public void removeTest() {
        boardService.remove(6L);
    }

    @Test
    public void modifyTest(){
        BoardVO boardVO = boardService.getBoard(6L);
        boardVO.setBoardContent("수정된 내용");
        boardService.modify(boardVO.toDTO());
    }
}
