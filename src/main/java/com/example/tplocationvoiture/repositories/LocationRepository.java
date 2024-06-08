package com.example.tplocationvoiture.repositories;




import com.example.tplocationvoiture.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	//La liste des location par client 
	
}