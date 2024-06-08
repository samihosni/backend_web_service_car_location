package com.example.tplocationvoiture.Controllers;

import com.example.tplocationvoiture.Services.Imp.ModelesServiceImp;
import com.example.tplocationvoiture.Services.Imp.VoitureServiceImp;
import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/voiture")
public class RestControllerVoiture {
    @Autowired
    private VoitureServiceImp voitureServiceImp;
    //@Autowired
    // private ModelesServiceImp modelesServiceImp;


    /*@PostMapping("/save1")
    public Voiture saveVoiture(@RequestBody Voiture voiture){

        return  voitureServiceImp.saveVoiture(voiture);
    }



    @PostMapping("/save/{idmodel}")
    public Voiture saveVoiture(@RequestBody Voiture voiture,@PathVariable Long idmodel){
        Modeles m1=modelesServiceImp.getmodel(idmodel);
        voiture.setModel(m1);
        return  voitureServiceImp.saveVoiture(voiture);
    }
    @GetMapping("/all")
    public List<Voiture> getallVoiture(){
        return voitureServiceImp.getAllVoiture();
    }
    @GetMapping("/getone/{id}")
    public Voiture getoneVoiture(@PathVariable Long id) {

        return  voitureServiceImp.getOne(id);
    }
    @PutMapping("/update/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture voiture){
        Voiture c1=voitureServiceImp.getOne(id);
        if(c1!=null){
            voiture.setId(id);
            return voitureServiceImp.updateVoiture(voiture);
        }
        else {
            throw  new RuntimeException("Failed!!!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteVoitures(@PathVariable Long id){
        HashMap<String,String> message=new HashMap<>();
        if (voitureServiceImp.getOne(id)==null){
            message.put("etat","Voiture not found");
            return  message;
        }
        try {
            voitureServiceImp.deleteVoiture(id);
            message.put("etat","Voiture delete");
            return message;
        }catch (Exception e){
            message.put("etat","Voiture not deleted");
            return message;
        }
    }*/
    /*@PostMapping
    void addVoiture(@RequestBody Voiture voiture) {

        voitureServiceImp.saveVoiture(voiture);
    }*/
    @PostMapping
    public ResponseEntity<Voiture> addVoiture(@ModelAttribute Voiture voiture,
                                                    @RequestParam("file") MultipartFile file) throws IOException {
        Voiture newVoiture = voitureServiceImp.addVoiture(voiture, file);
        return new ResponseEntity<>(newVoiture, HttpStatus.CREATED);
    }
    @GetMapping
    List<Voiture> getAllVoiture(){
        return voitureServiceImp.getAllVoiture();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        voitureServiceImp.deleteVoiture(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long id, @ModelAttribute Voiture voiture,
                                                       @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Voiture updatedVoiture = voitureServiceImp.updateVoiture(id,voiture , file);
        if (updatedVoiture != null) {
            return new ResponseEntity<>(updatedVoiture, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
