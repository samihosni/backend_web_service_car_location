package com.example.tplocationvoiture.Services.Imp;

import com.example.tplocationvoiture.Services.VoitureService;
import com.example.tplocationvoiture.entities.Voiture;
import com.example.tplocationvoiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VoitureServiceImp implements VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;



    @Override
    public Voiture getOne(Long id) {
        return voitureRepository.findById(id).get();
    }

    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }

    @Override
    public void deleteVoiture(Long id) {
     voitureRepository.deleteById(id);
    }

    @Override
    public Voiture saveVoiture(Voiture voiture) {

        return voitureRepository.save(voiture);
    }

    /*@Override
    public Voiture updateVoiture(Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }*/
    public Voiture updateVoiture(Long id, Voiture voiture, MultipartFile file) throws IOException {
        if (voitureRepository.existsById(id)) {
            Voiture existingVoiture = voitureRepository.findById(id).get();
            existingVoiture.setSerie(voiture.getSerie());
            existingVoiture.setDateMiseEnMarche(voiture.getDateMiseEnMarche());
            existingVoiture.setMake(voiture.getMake());
            existingVoiture.setModel(voiture.getModel());

            if (file != null && !file.isEmpty()) {
                existingVoiture.setImage(file.getBytes());
            }
            return voitureRepository.save(existingVoiture);
        }
        return null;
    }

    // new add
    @Override
    public Voiture addVoiture(Voiture voiture, MultipartFile file) throws IOException {
        voiture.setImage(file.getBytes());
        return voitureRepository.save(voiture);
    }
}
