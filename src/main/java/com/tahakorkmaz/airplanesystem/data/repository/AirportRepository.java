package com.tahakorkmaz.airplanesystem.data.repository;

import com.tahakorkmaz.airplanesystem.data.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,String> {

    Airport getById(Long id);
}
