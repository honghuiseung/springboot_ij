package com.example.mobile_project.dto;

import com.example.mobile_project.entity.ItemImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ItemImgDto {

    private Long id;

    private String imgName;

    private String oriName;

    private String imgUrl;

    private String repImgYn;

    //멤버 변수로 ModelMapper객채를 추가
    private static ModelMapper modelMapper = new ModelMapper();

    //ItemImg엔티티 객체를 파라미터로 받아서 ItemImg 객체의 자료형과 멤버변수의 이름이 같을 때
    //ItemImgDto로 값을 복사해서 반환
    public static ItemImgDto of(ItemImg itemImg){
        return modelMapper.map(itemImg,ItemImgDto.class);
    }
}
