package com.realestate.repository;

import com.realestate.entities.SoldHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldHouseRepository extends JpaRepository<SoldHouse, Long> {

}
