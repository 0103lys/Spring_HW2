package com.koreait.day3.repository;

import com.koreait.day3.Day3ApplicationTests;
import com.koreait.day3.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends Day3ApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = OrderDetail.builder()
                .status("결제완료")
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(3000000))
                .regDate(LocalDateTime.now())
                .itemId(2L)
                .orderGroupId(1L)
                .build();
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
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

        Optional<OrderDetail> orderDetail = orderDetailRepository.findByStatusAndId("결제완료", 5L);
        if(orderDetail != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다!");
        }
    }
    @Test
    public void update() {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectOrderDetail -> {
            selectOrderDetail.setStatus("결제취소");
            selectOrderDetail.setQuantity(2);
            selectOrderDetail.setTotalPrice(BigDecimal.valueOf(2000000));
            orderDetailRepository.save(selectOrderDetail);
        });
    }

    @Test
    public void delete(){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(5L);

        orderDetail.ifPresent(selectOrderDetail -> {
            orderDetailRepository.save(selectOrderDetail);
        });

        Optional<OrderDetail> DeleteOrderDetail = orderDetailRepository.findById(5L);
        if(DeleteOrderDetail.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }
}
