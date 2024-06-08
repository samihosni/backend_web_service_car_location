package com.example.tplocationvoiture.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

 
@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(max = 5)
   private String cin;
    private String nom;
    private String prenom;
    private String adresse;
    @JsonIgnore
    //cascade = CascadeType.REMOVE
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<Location> locations = new ArrayList<Location>();




    
 
}