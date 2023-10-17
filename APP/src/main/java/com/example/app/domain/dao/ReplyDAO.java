package com.example.app.domain.dao;

import com.example.app.domain.vo.ReplyVO;
import com.example.app.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    //    댓글 목록
    public List<ReplyVO> findAllByBoardId(int page, int rowCount, Long boardId, String[] types, String keyword){
        return replyMapper.selectAllByBoardId(page, rowCount, boardId, types, keyword);
    }

//    다음 페이지의 게시글 개수
    public int findCountOfNextPage(int page, int rowCount, Long boardId, String[] types, String keyword){
        return replyMapper.selectCountOfNextPage(page, rowCount, boardId, types, keyword);
    }

    //    댓글 추가
    public void save(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }

    //    댓글 수정
    public void setReply(ReplyVO replyVO){
        replyMapper.update(replyVO);
    }

    //    댓글 삭제
    public void delete(Long replyId){
        replyMapper.delete(replyId);
    }
}
