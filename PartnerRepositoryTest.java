package com.koreait.day3.repository;

import com.koreait.day3.Day3ApplicationTests;
import com.koreait.day3.model.entity.Partner;
import com.koreait.day3.model.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class PartnerRepositoryTest extends Day3ApplicationTests {
    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = Partner.builder()
                .name("123")
                .status("사용중")
                .address("서울시 금천구")
                .callCenter("010-4444-4444")
                .businessNumber("444-44-4444")
                .ceoName("오지환")
                .regDate(LocalDateTime.now())
                .categoryId(6L)
                .build();
        Partner newPartner = partnerRepository.save(partner);

    }

    @Test
    public void read() {
        /*Optional<Partner> partner = partnerRepository.findById(2L);
        partner.ifPresent(selectPartner -> {
            System.out.println("partner : " + selectPartner);
            System.out.println("name : " + selectPartner.getName());
            System.out.println("status : " + selectPartner.getStatus());
            System.out.println("address : " + selectPartner.getAddress());
            System.out.println("call_center : " + selectPartner.getCallCenter());
            System.out.println("business_number : " + selectPartner.getBusinessNumber());
            System.out.println("ceo_name : " + selectPartner.getCeoName());
            System.out.println("category_id : " + selectPartner.getCategoryId());

        });*/
        Optional<Partner> partner = partnerRepository.findByIdAndName(2L, "애플 스토어");
        if(partner != null){
            System.out.println("데이터가 존재합니다");
        }else{
            System.out.println("데이터가 존재하지 않습니다!");
        }


    }
    @Test
    public void update() {
        Optional<Partner> partner = partnerRepository.findById(2L);
        partner.ifPresent(selectPartner -> {
            selectPartner.setName("애플 스토어즈");
            selectPartner.setStatus("판매중지");
            selectPartner.setAddress("서울시 양재동");
            selectPartner.setCallCenter("010-2222-2222");
            selectPartner.setBusinessNumber("070-22-2222");
            selectPartner.setCeoName("애플류");
            selectPartner.setUpdateDate(LocalDateTime.now());
            partnerRepository.save(selectPartner);
        });
    }

    @Test
    public void delete(){
        Optional<Partner> partner = partnerRepository.findById(5L);

        partner.ifPresent(selectPartner -> {
            partnerRepository.delete(selectPartner);
        });

        Optional<Partner> deletePartner = partnerRepository.findById(5L);
        if(deletePartner.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }


}
