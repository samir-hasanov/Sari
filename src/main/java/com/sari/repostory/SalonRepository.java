package com.sari.repostory;

import com.sari.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {
    List<Salon> findByActive(Integer active);
    Optional<Salon> findById(Long id);
    Salon findByIdAndActive(Long id,Integer active);
}
