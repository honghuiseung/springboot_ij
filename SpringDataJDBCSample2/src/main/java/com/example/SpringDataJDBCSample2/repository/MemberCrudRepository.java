package com.example.SpringDataJDBCSample2.repository;

import com.example.SpringDataJDBCSample2.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Member, Integer> {
}
