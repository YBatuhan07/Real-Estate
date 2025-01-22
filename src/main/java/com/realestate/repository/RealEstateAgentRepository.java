package com.realestate.repository;

import com.realestate.entities.RealEstateAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateAgentRepository extends JpaRepository<RealEstateAgent, Long> {
}
