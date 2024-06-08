package com.example.tplocationvoiture.Controllers;

import com.example.tplocationvoiture.Services.Imp.ModelesServiceImp;
import com.example.tplocationvoiture.Services.Imp.VoitureServiceImp;
import com.example.tplocationvoiture.entities.Client;
import com.example.tplocationvoiture.entities.Modeles;
import com.example.tplocationvoiture.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class VoitureController {
    @Autowired
    private VoitureServiceImp voitureServiceImp;
    @Autowired
    private ModelesServiceImp modelService;

    @RequestMapping("/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        List<Modeles> listModel = modelService.listModel();

        model.addAttribute("VoitureForm", voiture);
        model.addAttribute("modelList", listModel);
        return "new_voiture";
    }
    @RequestMapping(value="/savevoiture", method= RequestMethod.POST)
    public String saveVoiture(@ModelAttribute("VoitureForm") Voiture voiture) {
        voitureServiceImp.saveVoiture(voiture);
        return "redirect:/";
    }
    @RequestMapping("/allVoiture")
    public String listVoitures(Model model) {
        List<Voiture> listVoitures = voitureServiceImp.getAllVoiture();
        model.addAttribute("listVoitures", listVoitures);

        return "liste_voitures";
    }

    @GetMapping("editVoiture/{id}")
    public String showUpdateFormVoiture(@PathVariable("id") long id, Model model) {
        Voiture voiture = voitureServiceImp.getOne(id);
        model.addAttribute("voiture", voiture);
        return "update_voiture";
    }

    @PostMapping("updateVoiture/{id}")
    public String updateVoiture(@PathVariable("id") long id,  Voiture voiture, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            voiture.setId(id);
            return "update_voiture";
        }

        voitureServiceImp.saveVoiture(voiture);

        return "redirect:/allVoiture";
    }


}
