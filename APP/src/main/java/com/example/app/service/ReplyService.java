package com.example.app.service;

import com.example.app.domain.vo.ReplyVO;
import com.example.app.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper replyMapper;

    //    댓글 목록
    public List<ReplyVO> getList(int page, int rowCount, Long boardId, String type, String keyword){
        return replyMapper.selectAllByBoardId(page, rowCount, boardId, type.split(""), keyword);
    }

    //    다음 페이지의 게시글 개수
    public int getCountOfNextPage(int page, int rowCount, Long boardId, String type, String keyword){
        return replyMapper.selectCountOfNextPage(page, rowCount, boardId, type.split(""), keyword);
    }

    //    댓글 추가
    public void register(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }

    //    댓글 수정
    public void modify(ReplyVO replyVO){
        replyMapper.update(replyVO);
    }

    //    댓글 삭제
    public void remove(Long replyId){
        replyMapper.delete(replyId);
    }
}
