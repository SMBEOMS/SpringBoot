package com.example.app.mapper;

import com.example.app.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void selectAllByBoardIdTest(){
//        assertThat(replyMapper.selectAllByBoardId(2, 10, 5205L)).hasSize(2);
        replyMapper.selectAllByBoardId(1, 10, 5202L, "c".split(""), "11").stream().map(ReplyVO::toString).forEach(log::info);
    }

    @Test
    public void selectCountOfNextPageTest(){
        log.info(replyMapper.selectCountOfNextPage(1, 10, 5202L, null, null) + "건");
    }

    @Test
    public void insertTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyContent("테스트 댓글 내용3");
        replyVO.setReplyWriter("테스터3");
        replyVO.setBoardId(5205L);
        replyMapper.insert(replyVO);
    }

    @Test
    public void updateTest(){
        ReplyVO replyVO = replyMapper.selectAllByBoardId(1, 10, 5205L, null, null).get(0);
        replyVO.setReplyContent("수정된 댓글 내용");
        replyMapper.update(replyVO);
    }

    @Test
    public void deleteTest(){
        replyMapper.delete(3L);
    }
}
