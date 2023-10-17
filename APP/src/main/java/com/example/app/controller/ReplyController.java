package com.example.app.controller;

import com.example.app.domain.dto.ReplyDTO;
import com.example.app.domain.vo.ReplyVO;
import com.example.app.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller // return 값에 ViewResolver 객체가 관여한다.
@RestController // return 값을 JSON혹은 해당 값 그대로 화면에 전달한다.
@RequestMapping("/replies/*")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

//    테스트
//    @GetMapping("test")
//    public String test(){
//        return "한동석";
//    }

//    @GetMapping("test2")
//    public List<String> test2(){
//        return new ArrayList<>(Arrays.asList("ㄱ", "ㄴ", "ㄷ"));
//    }

//    댓글 목록
    @GetMapping("list/{boardId}/{page}/{rowCount}")
    public ReplyDTO getList(@PathVariable Long boardId, @PathVariable int page, @PathVariable int rowCount, String type, String keyword){
        return new ReplyDTO(replyService.getList(page, rowCount, boardId, type, keyword), replyService.getCountOfNextPage(page, rowCount, boardId, type, keyword));
    }

//    댓글 작성
    @PostMapping("write")
    public void write(@RequestBody ReplyVO replyVO){
        replyService.register(replyVO);
    }

//    댓글 수정
    @PostMapping("modify")
    public void modify(@RequestBody ReplyVO replyVO){
        replyService.modify(replyVO);
    }

//    댓글 삭제
    @DeleteMapping("{replyId}")
    public void remove(@PathVariable Long replyId){
        replyService.remove(replyId);
    }

}
