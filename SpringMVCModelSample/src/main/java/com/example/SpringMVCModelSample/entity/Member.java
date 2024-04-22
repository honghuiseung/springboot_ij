package com.example.SpringMVCModelSample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    //getter/setter
    private Integer id;
    private String name;
}
