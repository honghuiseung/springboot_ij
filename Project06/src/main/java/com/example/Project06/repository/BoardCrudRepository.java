package com.example.Project06.repository;

import com.example.Project06.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardCrudRepository extends CrudRepository<Board, Integer> {
}
