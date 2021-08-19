package com.koreait.day3.repository;

import com.koreait.day3.model.entity.Item;
import com.koreait.day3.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // select * from item where id=?
    Optional<Item> findById(Long id);

    // select * from item where name=? and title=?
    Optional<Item> findByNameAndTitle(String name, String title);
}
