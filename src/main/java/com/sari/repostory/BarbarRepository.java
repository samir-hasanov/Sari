package com.sari.repostory;

import com.sari.entity.Barbar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbarRepository extends JpaRepository<Barbar,Long> {

    List<Barbar> findByActive(Integer active);
    Barbar findByIdAndActive(Long id,Integer active);
}
