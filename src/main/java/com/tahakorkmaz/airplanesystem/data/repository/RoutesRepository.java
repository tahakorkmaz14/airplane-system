package com.tahakorkmaz.airplanesystem.data.repository;

import com.tahakorkmaz.airplanesystem.data.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Routes,String> {

    Routes getById(Long id);
}
