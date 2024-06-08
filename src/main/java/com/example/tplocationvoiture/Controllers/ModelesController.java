package com.example.tplocationvoiture.Controllers;

import com.example.tplocationvoiture.Services.Imp.ModelesServiceImp;
import com.example.tplocationvoiture.entities.Modeles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
public class ModelesController {

	@Autowired
	private ModelesServiceImp modelService;
	
	//Ajouter un model 
	
	//1- Retourner un forumlaire d'ajout
	
	@RequestMapping("/addModel")
	public String addModel(Model model) {
		
		Modeles modele = new Modeles();
		model.addAttribute("modele", modele);
		return "new_modele";
	}
	
	//2- Ajout + redirection vers la liste des modeles
	
	@RequestMapping(value="/saveModel", method=RequestMethod.POST)
	public String saveModel(@ModelAttribute("Model") Modeles model) {
		modelService.saveModel(model);
		return "redirect:/listeModel";
	}
	
	//Liste des models
	
	@RequestMapping("/listeModel")
	public String listModel(Model model) {
	    List<Modeles> listModel = modelService.listModel();
	    model.addAttribute("listModeles", listModel);
	     
	    return "liste_modeles";
	}
	
	@GetMapping("editModel/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Modeles modele = modelService.getmodel(id);
        model.addAttribute("model", modele);
        return "update_model";
    }

    @PostMapping("updateModel/{id}")
    public String updateModel(@PathVariable("id") long id,
    		@Valid Modeles modele, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            modele.setId(id);
            return "update_model";
        }

        modelService.saveModel(modele);
        model.addAttribute("listModeles", modelService.listModel());
        return "redirect:/listeModel";
    }

    @GetMapping("deleteModel/{id}")
    public String deleteModel(@PathVariable("id") long id, Model model) {
     
    modelService.deleteModel(id);
        model.addAttribute("listeModel", modelService.listModel());
        return "redirect:/listeModel";
    }
}
