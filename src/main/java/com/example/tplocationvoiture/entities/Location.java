package com.example.tplocationvoiture.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String dateDebut;


	private String dateRetour;


	private float prixJour;


	private float prix;

	@ManyToOne

	private Client client;

	//@ManyToOne

	//private Voiture voiture;

}