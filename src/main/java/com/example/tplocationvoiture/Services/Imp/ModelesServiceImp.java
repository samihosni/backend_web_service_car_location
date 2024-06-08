package com.example.tplocationvoiture.Services.Imp;


import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import com.example.tplocationvoiture.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelesServiceImp {

	@Autowired
	private ModelRepository modelRepo;
	
	//Liste des mod�les
	public List<Modeles> listModel(){
		
		return modelRepo.findAll();
	}
	
	//Ajouter un model
	public Modeles saveModel(Modeles model) {
		
		return modelRepo.save(model);
	}
	
	//R�cuperer un model par un id
	public Modeles getmodel(long id) {
		return modelRepo.findById(id).get();
	}
	
	//Supprimer un model par un id
	public void deleteModel(long id) {
		modelRepo.deleteById(id);
	}
	public Modeles updateModeles(Modeles modeles){

		return modelRepo.saveAndFlush(modeles);
	}
	/*public Modeles addVoitureToModeles(Long modelesId, Voiture voiture) {
		Modeles modeles = modelRepo.findById(modelesId).orElse(null);
		if (modeles != null) {
			modeles.getVoitures().add(voiture);
			return modelRepo.save(modeles);
		}
		return null;
	}*/
	
}
