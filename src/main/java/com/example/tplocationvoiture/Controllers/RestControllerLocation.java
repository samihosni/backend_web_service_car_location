package com.example.tplocationvoiture.Controllers;

import com.example.tplocationvoiture.Services.Imp.ClientServiceImp;
import com.example.tplocationvoiture.Services.Imp.VoitureServiceImp;
import com.example.tplocationvoiture.Services.LocationService;
import com.example.tplocationvoiture.entities.Client;
import com.example.tplocationvoiture.entities.Location;
import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/location")
public class RestControllerLocation {
    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientServiceImp clientServiceImp;
    @Autowired
    private VoitureServiceImp voitureServiceImp;
    @PostMapping("/save")
    public Location saveLocation(@RequestBody Location location){
       return locationService.saveLocation(location);
    }

   /* @PostMapping("/save/{idclient}/{idvoiture}")
    public Location saveLocation(@RequestBody Location location, @PathVariable Long idclient, @PathVariable long idvoiture ){
        Client client=clientServiceImp.getClientById(idclient);
        Voiture voiture=voitureServiceImp.getOne(idvoiture);
        location.setClient(client);
        location.setVoiture(voiture);
        return  locationService.saveLocation(location);
    }*/
    @GetMapping("/all")
    public List<Location> getallLocation(){

        return locationService.getAllLocation();
    }
    @GetMapping("/getone/{id}")
    public Location getoneLocation(@PathVariable Long id) {

        return  locationService.getOne(id);
    }
    @PutMapping("/update/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location){
        Location c1=locationService.getOne(id);
        if(c1!=null){
            location.setId(id);
            return locationService.updateLocation(location);
        }
        else {
            throw  new RuntimeException("Failed!!!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteLocation(@PathVariable Long id){
        HashMap<String,String> message=new HashMap<>();
        if (locationService.getOne(id)==null){
            message.put("etat","Location not found");
            return  message;
        }
        try {
            locationService.deleteLocation(id);
            message.put("etat","Location delete");
            return message;
        }catch (Exception e){
            message.put("etat","Location not deleted");
            return message;
        }
    }

}
