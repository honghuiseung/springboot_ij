package com.example.Project06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    private Integer id;
    private Integer boardnum;
    private String separate;
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate regdate;
    private String content;

}
