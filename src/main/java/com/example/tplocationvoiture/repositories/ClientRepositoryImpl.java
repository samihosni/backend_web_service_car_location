package com.example.tplocationvoiture.repositories;



import com.example.tplocationvoiture.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClientRepositoryImpl implements ClientRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	//Get client par nom
	
	public Client getClientByNom(String nom) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM Client c " +
	                "WHERE c.name LIKE ?", Client.class);
	        query.setParameter(1, nom + "%");
	      
	        return (Client) query.getSingleResult();
	    }
}
