package com.example.tplocationvoiture.Controllers;

import com.example.tplocationvoiture.Services.Imp.ModelesServiceImp;
import com.example.tplocationvoiture.Services.Imp.VoitureServiceImp;
import com.example.tplocationvoiture.entities.Client;
import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/model")
public class RestControllerModeles {
    @Autowired
    private ModelesServiceImp modelesServiceImp;

    @PostMapping("/save")
    public Modeles saveModeles(@RequestBody Modeles modeles){

        return  modelesServiceImp.saveModel(modeles);
    }

    @GetMapping("/all")
    public List<Modeles> getallModeles(){

        return modelesServiceImp.listModel();
    }
    @GetMapping("/getone/{id}")
    public Modeles getoneModeles(@PathVariable Long id) {

        return  modelesServiceImp.getmodel(id);
    }
    @PutMapping("/update/{id}")
    public Modeles updateModeles(@PathVariable Long id, @RequestBody Modeles modeles){
        Modeles c1=modelesServiceImp.getmodel(id);
        if(c1!=null){
            modeles.setId(id);
            return modelesServiceImp.updateModeles(modeles);
        }
        else {
            throw  new RuntimeException("Failed!!!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteModeles(@PathVariable Long id){
        HashMap<String,String> message=new HashMap<>();
        if (modelesServiceImp.getmodel(id)==null){
            message.put("etat","modele not found");
            return  message;
        }
        try {
            modelesServiceImp.deleteModel(id);
            message.put("etat","modele delete");
            return message;
        }catch (Exception e){
            message.put("etat","modele not deleted");
            return message;
        }
    }



}
