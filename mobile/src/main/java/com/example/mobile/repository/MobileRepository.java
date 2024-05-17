package com.example.mobile.repository;

import com.example.mobile.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile, Long> {
    Mobile findByEmail(String email);

    @Query(value = "select name from Mobile i where i.email like " + "%:email% order by i.id", nativeQuery = true)
    Mobile findByNameByEmail(@Param("email") String email);
}
