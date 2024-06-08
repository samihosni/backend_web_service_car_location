package com.example.tplocationvoiture.Controllers;

import com.example.tplocationvoiture.Services.ClientService;
import com.example.tplocationvoiture.Services.LocationService;
import com.example.tplocationvoiture.Services.VoitureService;
import com.example.tplocationvoiture.entities.Client;
import com.example.tplocationvoiture.entities.Location;
import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private VoitureService voitureService;

    @RequestMapping("/addLocation")
    public String addLocation(Model model) {
        Location location = new Location();
        List<Client> listClient = clientService.getAllClient();
        List<Voiture> listVoiture = voitureService.getAllVoiture();

        model.addAttribute("LocationForm", location);
        model.addAttribute("clientList", listClient);
        model.addAttribute("voitureList", listVoiture);
        return "new_location";
    }

    @RequestMapping(value = "/savelocation", method = RequestMethod.POST)
    public String savelocation(@ModelAttribute("LocationForm") Location location) {
        locationService.saveLocation(location);
        return "redirect:/allLocation";
    }

    @RequestMapping("/allLocation")
    public String listLocation(Model model) {
        List<Location> listLocations = locationService.getAllLocation();
        model.addAttribute("listLocation", listLocations);


        return "liste_locations";
    }

    @GetMapping("editLocation/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Location location = locationService.getOne(id);
        List<Client> listClient = clientService.getAllClient();
        List<Voiture> listVoiture = voitureService.getAllVoiture();
        model.addAttribute("location", location);
        model.addAttribute("clientList", listClient);
        model.addAttribute("voitureList", listVoiture);
        return "update_location";
    }

    @PostMapping("updateLocation/{id}")
    public String updateLocation(@PathVariable("id") long id, Location location, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            location.setId(id);
            return "update_location";
        }
        locationService.updateLocation(location);

        return "redirect:/allLocation";

    }
    @GetMapping("deleteLocation/{id}")
    public String deleteLocation(@PathVariable("id") long id) {

        locationService.deleteLocation(id);
        return "redirect:/allLocation";
    }
}