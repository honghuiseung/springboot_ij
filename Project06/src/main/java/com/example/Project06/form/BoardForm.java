package com.example.Project06.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardForm {
    private Integer id;
    @NotBlank
    private String separate;
    @NotBlank
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate regdate;
    @NotBlank
    private String content;
    private Boolean newBoard;

}
