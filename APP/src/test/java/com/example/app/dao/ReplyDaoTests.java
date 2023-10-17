package com.example.app.dao;

import com.example.app.domain.dao.ReplyDAO;
import com.example.app.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyDaoTests {
    @Autowired
    private ReplyDAO replyDAO;

    @Test
    public void findAllByBoardIdTest(){
        replyDAO.findAllByBoardId(1, 10, 5205L, null, null).stream().map(ReplyVO::toString).forEach(log::info);
    }

    @Test
    public void saveTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyContent("테스트 댓글 내용3");
        replyVO.setReplyWriter("테스터3");
        replyVO.setBoardId(5205L);
        replyDAO.save(replyVO);
    }

    @Test
    public void setReplyTest(){
        ReplyVO replyVO = replyDAO.findAllByBoardId(1, 10, 5205L, null, null).get(0);
        replyVO.setReplyContent("수정된 댓글 내용");
        replyDAO.setReply(replyVO);
    }

    @Test
    public void deleteTest(){
        replyDAO.delete(514L);
    }
}
