package com.example.mobile.repository;

import com.example.mobile.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    @Query(value = "select * from Member i where i.email like " + "%:email% order by i.email limit 1", nativeQuery = true)
    Member findByEmailByNative(@Param("email") String email);
}
