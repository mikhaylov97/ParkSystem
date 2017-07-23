package com.epam.park.repository;

import com.epam.park.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arty on 22.07.2017.
 */
public interface PlantRepository extends JpaRepository<Plant, Long> {
}
