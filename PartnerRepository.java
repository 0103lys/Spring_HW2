package com.koreait.day3.repository;

import com.koreait.day3.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    // select * from partner where id=?
    Optional<Partner> findById(Long id);
    // select * from partner where id=? and name=?
    Optional<Partner> findByIdAndName(Long id, String name);
}
