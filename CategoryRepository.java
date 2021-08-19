package com.koreait.day3.repository;

import com.koreait.day3.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // select * from category where id=?
    Optional<Category> findById(Long id);

    // select * from category where id=? and type=?
    Optional<Category> findByIdAndType(Long id, String type);
}
