package com.koreait.day3.repository;

import com.koreait.day3.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // select * from order_detail where id=?
    Optional<OrderDetail> findById(Long id);

    // select * from order_detail where status=? and id=?
    Optional<OrderDetail> findByStatusAndId(String status, Long id);

}
