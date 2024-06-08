package com.example.tplocationvoiture.repositories;



import com.example.tplocationvoiture.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> ,ClientRepositoryCustom{
   //@Query("SELECT c FROM Client c WHERE c.nom = :nom")
  // Client getClientByNom(@Param("nom") String nom);

}