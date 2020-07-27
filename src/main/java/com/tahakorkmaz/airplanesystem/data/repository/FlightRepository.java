package com.tahakorkmaz.airplanesystem.data.repository;

import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    Flight getById(Long id);
}
