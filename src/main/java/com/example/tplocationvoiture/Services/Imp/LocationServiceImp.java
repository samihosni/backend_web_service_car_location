package com.example.tplocationvoiture.Services.Imp;

import com.example.tplocationvoiture.Services.LocationService;
import com.example.tplocationvoiture.entities.Location;
import com.example.tplocationvoiture.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {
   @Autowired
    LocationRepository locationRepository;
    @Override
    public Location getOne(Long id) {

        return locationRepository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocation() {

        return locationRepository.findAll();
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);

    }

    @Override
    public Location saveLocation(Location location) {

        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.saveAndFlush(location);
    }
}
