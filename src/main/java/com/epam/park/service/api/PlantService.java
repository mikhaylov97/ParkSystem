package com.epam.park.service.api;


import com.epam.park.model.Plant;

import java.util.List;

public interface PlantService {
    List<Plant> getAllPlants();
    Plant getPlantById(Long id);
}
