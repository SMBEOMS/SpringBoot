package com.example.app.mapper;

import com.example.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
//    파일 추가
    public void insert(FileVO fileVO);

//    파일 삭제
    public void delete(Long boardId);

//    파일 개별 삭제
    public void deleteFile(Long fileId);

//    파일 목록
    public List<FileVO> selectAllByBoardId(Long boardId);

//    전일 파일 목록
    public List<FileVO> selectOldFiles();
}
