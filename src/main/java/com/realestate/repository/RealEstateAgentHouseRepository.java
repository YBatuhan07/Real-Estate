package com.realestate.repository;

import com.realestate.entities.RealEstateAgentHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateAgentHouseRepository extends JpaRepository<RealEstateAgentHouse, Long> {
}
