package com.example.Project06.repository;

import com.example.Project06.entity.Board;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardCrudRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT id FROM board WHERE id > 0 order by id desc limit 1")
    Integer getRandomId();

    @Query("SELECT id FROM board ORDER BY id DESC LIMIT 1")//역순으로 정렬
    Integer endId();

    //게시판 마지막 번호 가져오기
    @Query("SELECT boardnum FROM board ORDER BY id DESC LIMIT 1")//역순으로 정렬
    Integer endBn();

    //파라미터로 받아온 아이디 값의 게시판번호 가져오기
    @Query("SELECT boardnum FROM board WHERE id = :id")
    Integer getBoardNumById(@Param("id") Integer id);

    //삭제한 게시물의 뒷번호 게시판번호 모두 1씩 감소시키기
    @Modifying
    @Query("UPDATE Board board SET board.boardnum = board.boardnum-1 WHERE board.boardnum > :num")
    void updateBn(@Param("num") Integer num);


    //void updateMaxBm(@Param("id") Integer endId);


}
