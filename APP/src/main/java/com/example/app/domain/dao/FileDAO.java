package com.example.app.domain.dao;

import com.example.app.domain.vo.FileVO;
import com.example.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

//    파일 추가
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

//    파일 삭제
    public void delete(Long boardId){
        fileMapper.delete(boardId);
    }

//    파일 개별 삭제
    public void deleteById(Long fileId){
        fileMapper.deleteFile(fileId);
    }

//    파일 목록
    public List<FileVO> findAllByBoardId(Long boardId){
        return fileMapper.selectAllByBoardId(boardId);
    }

//    전일 파일 목록
    public List<FileVO> findByYesterday(){
        return fileMapper.selectOldFiles();
    }
}
