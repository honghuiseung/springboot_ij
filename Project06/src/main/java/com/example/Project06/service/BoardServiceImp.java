package com.example.Project06.service;

import com.example.Project06.entity.Board;
import com.example.Project06.repository.BoardCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class BoardServiceImp implements BoardService{

    @Autowired
    BoardCrudRepository repository;

    @Override
    public Iterable<Board> selectAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Board> selectReverseAll() {
        ArrayList<Board> reverseBoard = new ArrayList();
        int end = repository.endId();
        for(int i = 0; i<end; i++){
            if(repository.existsById(end-i))
            reverseBoard.add(repository.findById(end-i).get());
        }
        Iterable<Board> iterable = reverseBoard;
        return iterable;
    }

    @Override
    public Optional<Board> selectOneById(Integer id) {
        return repository.findById(id);
    }
    public Integer selectLastBn() {
        return repository.endBn();
    }

    @Override
    public void insertBoard(Board board) {
        repository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        repository.save(board);
    }

    @Override
    public void deleteBoardById(Integer id) {
        Integer bn = repository.getBoardNumById(id);
        repository.updateBn(bn);
        repository.deleteById(id);
    }

    public Integer getSizeOfBoard(){
        long count = repository.count();
        int result = Long.valueOf(count).intValue();
        return result;
    }

}
