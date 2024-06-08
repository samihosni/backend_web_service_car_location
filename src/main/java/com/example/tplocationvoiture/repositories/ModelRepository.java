package com.example.tplocationvoiture.repositories;




import com.example.tplocationvoiture.entities.Modeles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ModelRepository extends JpaRepository<Modeles, Long> {
	
	
}