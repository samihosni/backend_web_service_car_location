package com.example.tplocationvoiture.repositories;





import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;

import java.util.List;

public interface VoitureRepositoryCustom {

	public List<Voiture> ListeVoitureByModel(Modeles model);
	// public List<Voiture> ListeVoitureByModel(Long id);
	// public List<Voiture> ListeVoitureByModel(String libelle);
}
