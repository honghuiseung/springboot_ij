package com.example.mobile.service;

import com.example.mobile.dto.ItemFormDto;
import com.example.mobile.entity.Item;
import com.example.mobile.entity.ItemImg;
import com.example.mobile.repository.ItemImgRepository;
import com.example.mobile.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    private final ItemImgRepository itemImgRepository;

    private final ItemImgService itemImgService;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception{
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        for(int i=0; i<itemImgFileList.size();i++){
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);

            if(i == 0) //첫 번째 이미지일 경우 대표 상품 이미지 여부 값을 "Y"로 세팅
                itemImg.setRepimgYn("Y");
            else
                itemImg.setRepimgYn("N");

            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i)); //상품 이미지 정보를 저장
        }

        return item.getId();
    }
}