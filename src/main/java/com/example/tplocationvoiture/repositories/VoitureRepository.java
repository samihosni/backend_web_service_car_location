package com.example.tplocationvoiture.repositories;




import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long>, VoitureRepositoryCustom {
	//Liste des voitures par mod�le
	
}