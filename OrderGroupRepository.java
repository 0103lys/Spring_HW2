package com.koreait.day3.repository;

import com.koreait.day3.model.entity.Item;
import com.koreait.day3.model.entity.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {
    // select * from order_group where id=?
    Optional<OrderGroup> findById(Long id);

    // select * from order_group where id=? and rev_name=?
    Optional<OrderGroup> findByIdAndRevName(Long id, String revName);


}
