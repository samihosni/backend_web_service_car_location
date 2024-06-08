package com.example.tplocationvoiture.Services;

import com.example.tplocationvoiture.entities.Location;
import com.example.tplocationvoiture.entities.Voiture;

import java.util.List;

public interface LocationService {
    Location getOne(Long id);
    List<Location> getAllLocation();
    void deleteLocation(Long id);
    Location saveLocation(Location location);
    Location updateLocation(Location location);
}
