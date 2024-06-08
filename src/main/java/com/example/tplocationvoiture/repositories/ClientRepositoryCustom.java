package com.example.tplocationvoiture.repositories;


import com.example.tplocationvoiture.entities.Client;

public interface ClientRepositoryCustom {

	//Get client par nom
	 Client getClientByNom(String nom);
}
