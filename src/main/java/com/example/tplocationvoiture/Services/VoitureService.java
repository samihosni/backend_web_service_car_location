package com.example.tplocationvoiture.Services;

import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VoitureService {
    Voiture getOne(Long id);
    List<Voiture> getAllVoiture();
    void deleteVoiture(Long id);
    Voiture saveVoiture(Voiture voiture);
    //Voiture updateVoiture(Voiture voiture);
    Voiture updateVoiture(Long id, Voiture voiture, MultipartFile file) throws IOException;
    Voiture addVoiture(Voiture voiture , MultipartFile file) throws IOException;
}
