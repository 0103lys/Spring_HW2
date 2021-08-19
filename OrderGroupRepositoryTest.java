package com.koreait.day3.repository;

import com.koreait.day3.Day3ApplicationTests;
import com.koreait.day3.model.entity.Item;
import com.koreait.day3.model.entity.OrderGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderGroupRepositoryTest extends Day3ApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;


    @Test
    public void create(){
        OrderGroup orderGroup = OrderGroup.builder()
                .orderType("ALL")
                .status("결제완료")
                .revAddress("서울시 서초구 양재동")
                .revName("반하나")
                .paymentType("카드")
                .totalPrice(BigDecimal.valueOf(4500000))
                .totalQuantity(2)
                .regDate(LocalDateTime.now())
                .orderAt(LocalDateTime.now())
                .userid(2L)
                .build();
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
    }

    @Test
    public void read() {
      /*  Optional<OrderGroup> orderGroup = orderGroupRepository.findById(1L);
        orderGroup.ifPresent(selectOrderGroup -> {
            System.out.println("order_group : " + selectOrderGroup);
            System.out.println("order_type : " + selectOrderGroup.getOrderType());
            System.out.println("status : " + selectOrderGroup.getStatus());
            System.out.println("rev_address : " + selectOrderGroup.getRevAddress());
            System.out.println("rev_name : " + selectOrderGroup.getRevName());
            System.out.println("payment_type : " + selectOrderGroup.getPaymentType());
            System.out.println("total_price : " + selectOrderGroup.getTotalPrice());
            System.out.println("total_quantity : " + selectOrderGroup.getTotalQuantity());
            System.out.println("reg_date : " + selectOrderGroup.getRegDate());

        });*/

        Optional<OrderGroup> orderGroup = orderGroupRepository.findByIdAndRevName(1L,"김딸기");
        if(orderGroup != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다!");
        }
    }
    @Test
    public void update() {
        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(1L);
        orderGroup.ifPresent(selectOrderGroup -> {
            selectOrderGroup.setOrderType("ALL");
            selectOrderGroup.setStatus("결제취소");
            selectOrderGroup.setRevAddress("서울시 서초구");
            selectOrderGroup.setRevName("김사과");
            selectOrderGroup.setPaymentType("계좌이체");
            selectOrderGroup.setTotalQuantity(1);
            selectOrderGroup.setTotalPrice(BigDecimal.valueOf(2000000));
            orderGroupRepository.save(selectOrderGroup);
        });
    }

    @Test
    public void delete(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(1L);

        orderGroup.ifPresent(selectOrderGroup -> {
            orderGroupRepository.save(selectOrderGroup);
        });

        Optional<OrderGroup> deleteOrderGroup = orderGroupRepository.findById(5L);
        if(deleteOrderGroup.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }
}
