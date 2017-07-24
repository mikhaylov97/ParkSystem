package com.epam.park.service.impl;

import com.epam.park.model.Plant;
import com.epam.park.repository.PlantRepository;
import com.epam.park.service.api.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService{

    @Autowired
    PlantRepository plantRepository;

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public Plant getPlantById(Long id) {
        for (Plant plant : plantRepository.findAll()) {
            if (plant.getId() == id) return plant;
        }
        return null;
    }
}
