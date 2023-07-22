package com.hr.pinmapbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.pinmapbackend.Entity.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long>{
    
}
