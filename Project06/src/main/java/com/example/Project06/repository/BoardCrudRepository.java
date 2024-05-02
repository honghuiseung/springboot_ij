package com.example.Project06.repository;

import com.example.Project06.entity.Board;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardCrudRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT id FROM board WHERE id > 0 order by id desc limit 1")//순서대로 정렬
    Integer getRandomId();

    @Query("SELECT id FROM board ORDER BY id DESC LIMIT 1")//역순으로 정렬
    Integer endId();

    //@Query("ALTER TABLE board AUTO_INCREMENT=1"+"SET @COUNT = 0"+"UPDATE board SET id = @COUNT:=@COUNT+1")

}
