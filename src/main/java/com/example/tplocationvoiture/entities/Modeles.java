package com.example.tplocationvoiture.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Modeles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
     
    @Column(name="libelle")
    private String libelle;
    
    @Column(name="pays")
    private String pays;
 //   @JsonIgnore
   // @OneToMany(mappedBy="model",cascade = CascadeType.REMOVE)
    //private List<Voiture> voitures = new ArrayList<Voiture>();


}
