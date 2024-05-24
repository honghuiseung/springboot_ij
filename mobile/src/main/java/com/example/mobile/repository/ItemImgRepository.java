package com.example.mobile.repository;

import com.example.mobile.entity.ItemImg;
import com.example.mobile.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemImgRepository extends CrudRepository<ItemImg, Integer> {
    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);
}

