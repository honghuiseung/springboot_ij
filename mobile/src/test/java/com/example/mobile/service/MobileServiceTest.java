package com.example.mobile.service;

import com.example.mobile.constant.Role;
import com.example.mobile.entity.Member;
import com.example.mobile.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MobileServiceTest {

    @Autowired
    MemberRepository mobileRepository;

    @Autowired
    MobileService memberService;

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
            item.setEmail("aa@aa"+(11-i));
            item.setPassword("12341234a");
            item.setAddress("12a");

            Member savedItem = mobileRepository.save(item);
        }
    }

    @Test
    @DisplayName("@Query를 이용한 멤버 조회 테스트")
    public void findByEmailByNative(){
        this.createItemList();
        String item = memberService.getNameByEmail("aa@aa");
        System.out.println(item);
    }
}
