package com.tahakorkmaz.airplanesystem.data.repository;

import com.tahakorkmaz.airplanesystem.data.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,String> {

    Airline getById(Long id);
}
