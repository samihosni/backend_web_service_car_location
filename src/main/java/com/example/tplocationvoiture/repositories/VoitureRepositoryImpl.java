package com.example.tplocationvoiture.repositories;


import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class VoitureRepositoryImpl implements VoitureRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;



	@Override
	public List<Voiture> ListeVoitureByModel(Modeles model) {
		Query query=
				entityManager.createNativeQuery("Select v.* from Voiture v where v.model.id = ?", Voiture.class);
		query.setParameter(1, model.getId());

		List<Voiture> listeVoitures = query.getResultList();
		return listeVoitures;

	}
}
