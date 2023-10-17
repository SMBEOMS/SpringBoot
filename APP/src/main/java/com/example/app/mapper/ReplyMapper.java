package com.example.app.mapper;

import com.example.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 목록
    public List<ReplyVO> selectAllByBoardId(@Param("page") int page, @Param("rowCount") int rowCount, @Param("boardId") Long boardId, @Param("types") String[] types, @Param("keyword") String keyword);

//    다음 페이지의 게시글 개수
    public int selectCountOfNextPage(@Param("page") int page, @Param("rowCount") int rowCount, @Param("boardId") Long boardId, @Param("types") String[] types, @Param("keyword") String keyword);

//    댓글 추가
    public void insert(ReplyVO replyVO);

//    댓글 수정
    public void update(ReplyVO replyVO);

//    댓글 삭제
    public void delete(Long replyId);
}
