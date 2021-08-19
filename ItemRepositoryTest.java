package com.koreait.day3.repository;

import com.koreait.day3.Day3ApplicationTests;
import com.koreait.day3.model.entity.Category;
import com.koreait.day3.model.entity.Item;
import com.koreait.day3.model.entity.Partner;
import com.koreait.day3.model.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends Day3ApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = Item.builder()
                .name("노트북")
                .status("판매중")
                .title("양문형 냉장고")
                .content("아주 시원해요")
                .price(BigDecimal.valueOf(2000000))
                .regDate(LocalDateTime.now())
                .partnerId(4L)
                .build();
        Item newItem = itemRepository.save(item);
    }

    @Test
    public void read() {
//        Optional<Item> item = itemRepository.findById(1L);
//        item.ifPresent(selectItem -> {
//            System.out.println("item : " + selectItem);
//            System.out.println("name : " + selectItem.getName());
//            System.out.println("status : " + selectItem.getStatus());
//            System.out.println("title : " + selectItem.getTitle());
//            System.out.println("content : " + selectItem.getContent());
//            System.out.println("price : " + selectItem.getPrice());
//            System.out.println("update_date : " + selectItem.getUpdateDate());
//        });

        Optional<Item> item = itemRepository.findByNameAndTitle("맥북프로","맥북 프로 16인치");
        if(item != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다!");
        }
    }
    @Test
    public void update() {
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectItem -> {
            selectItem.setName("데스크탑");
            selectItem.setStatus("판매중지");
            selectItem.setTitle("최신형 데스크탑");
            selectItem.setContent("완전 빨라요");
            selectItem.setPrice(BigDecimal.valueOf(2000000));
            selectItem.setUpdateDate(LocalDateTime.now());
            itemRepository.save(selectItem);
        });
    }

    @Test
    public void delete(){
        Optional<Item> item = itemRepository.findById(5L);

        item.ifPresent(selectItem -> {
            itemRepository.save(selectItem);
        });

        Optional<Item> deleteItem = itemRepository.findById(5L);
        if(deleteItem.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }


}
