package com.example.mobile.repository;

import com.example.mobile.constant.Role;
import com.example.mobile.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class MobileRepositoryTest {
    @Autowired
    MemberRepository mobileRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        Member item = new Member();
        item.setName("홍길동");
        item.setEmail("aa@aa");
        item.setPassword("12341234");
        item.setAddress("12");
        item.setRole(Role.ADMIN);

        Member savedItem = mobileRepository.save(item);
        System.out.println(savedItem.toString());
    }

    public void createItemList(){
        for(int i = 1; i<=10; i++){
            Member item = new Member();
            item.setName("홍길동"+i);
            item.setEmail("aa@aa");
            item.setPassword("12341234a"+i);
            item.setAddress("12a"+i);

            Member savedItem = mobileRepository.save(item);
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailByNative(){
        this.createItemList();
    }
}
