package com.example.mobile.entity;

import com.example.mobile.constant.Role;
import com.example.mobile.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "member")
@Getter @Setter
@ToString
public class Member extends BaseEntity{
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    public static Member createMember(MemberFormDto mobileFormDto, PasswordEncoder passwordEncoder){
        Member mobile = new Member();
        mobile.setName(mobileFormDto.getName());
        mobile.setEmail(mobileFormDto.getEmail());
        mobile.setAddress(mobileFormDto.getAddress());
        String password = passwordEncoder.encode(mobileFormDto.getPassword());
        mobile.setPassword(password);
        //mobile.setRole(Role.ADMIN);
        mobile.setRole(Role.USER);

        return mobile;
    }
}
