package com.example.mobile.repository;

import com.example.mobile.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    @Query(value = "select * from Mobile i where i.email like " + "%:email% order by i.id", nativeQuery = true)
    List<Member> findByNameByEmail(@Param("email") String email);
}
