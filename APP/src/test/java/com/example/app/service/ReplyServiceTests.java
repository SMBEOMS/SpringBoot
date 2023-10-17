package com.example.app.service;

import com.example.app.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;

    @Test
    public void getListTest(){
        replyService.getList(1, 10, 5205L, null, null).stream().map(ReplyVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyContent("테스트 댓글 내용3");
        replyVO.setReplyWriter("테스터3");
        replyVO.setBoardId(5205L);
        replyService.register(replyVO);
    }

    @Test
    public void modifyTest(){
        ReplyVO replyVO = replyService.getList(1, 10, 5205L, null, null).get(0);
        replyVO.setReplyContent("수정된 댓글 내용");
        replyService.modify(replyVO);
    }

    @Test
    public void removeTest(){
        replyService.remove(514L);
    }
}
