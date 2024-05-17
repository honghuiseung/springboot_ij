package com.mobile.mobile_project_v2.repository;

import com.mobile.mobile_project_v2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}

