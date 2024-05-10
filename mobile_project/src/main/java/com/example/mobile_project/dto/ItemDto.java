package com.example.mobile_project.dto;

import com.example.mobile_project.constant.ItemSellStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {
    private Long id;
    private String itemNm; //상품명
    private Integer price; //가격
    private String itemDetail; //상품 상세 설명
    private String sellStatCd;
    private LocalDateTime regTime; //등록시간
    private LocalDateTime updateTime; //수정시간
}
