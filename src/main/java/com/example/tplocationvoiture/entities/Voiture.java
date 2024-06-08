package com.example.tplocationvoiture.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     

    private String serie;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateMiseEnMarche;
    private String make;
    private String model;
    @Column(length = 1000000)
    private byte[] image;

   /* @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<Location> locations=  new ArrayList<Location>();
    @JsonBackReference
    @ManyToOne
    private Modeles model;*/
    












    
    
    
	
}