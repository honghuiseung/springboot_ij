package com.example.Project06.service;

import com.example.Project06.entity.Board;

import java.util.Optional;

public interface BoardService {
    /*등록된 모든 게시판 정보를 가져옵니다.*/
    Iterable<Board> selectAll();
    /*등록된 모든 게시판 정보를 역순으로 가져옵니다.*/
    Iterable<Board> selectReverseAll();
    /*id를 키로 사용해 게시판 정보를 한 건 가져옵니다.*/
    Optional<Board> selectOneById(Integer id);
    /*게시판에 글을 등록합니다.*/
    void insertBoard(Board board);
    /*게시판 내용을 변경합니다.*/
    void updateBoard(Board board);
    /*게시판에 글을 삭제합니다.*/
    void deleteBoardById(Integer id);
}
