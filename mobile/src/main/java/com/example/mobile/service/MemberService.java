package com.example.mobile.service;

import com.example.mobile.entity.Member;
import com.example.mobile.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository mobileRepository;
    public Member saveMobile(Member member){
        validateDuplicateMobile(member);
        return mobileRepository.save(member);
    }
    public void validateDuplicateMobile(Member mobile){
        Member findMobile = mobileRepository.findByEmail(mobile.getEmail());
        if(findMobile != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member mobile = mobileRepository.findByEmail(email);
        if(mobile == null){
            throw new UsernameNotFoundException(email);
        }

        UserDetails build = User.builder()
                .username(mobile.getEmail())
                .password(mobile.getPassword())
                .roles(mobile.getRole().toString())
                .build();
        return build;
    }
    public String getNameByEmail(String email){
        return mobileRepository.findByEmailByNative(email).getName();
    }
}
