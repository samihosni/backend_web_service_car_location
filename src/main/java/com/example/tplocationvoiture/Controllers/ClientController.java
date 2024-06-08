package com.example.tplocationvoiture.Controllers;
import com.example.tplocationvoiture.Services.Imp.ClientServiceImp;
import com.example.tplocationvoiture.entities.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientServiceImp clientServiceImp;

    @RequestMapping("/addClient")
    public String addClient(Model model) {
        Client client = new Client();
        model.addAttribute("ClientForm", client);
        return "new_client";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String saveClient(@ModelAttribute("ClientForm") Client client) {
        clientServiceImp.createClient(client);
        return "redirect:/all";
    }


    @RequestMapping("/all")
    public String listClients(Model model) {
        List<Client> listClients = clientServiceImp.getAllClient();
        model.addAttribute("listClients", listClients);

        return "liste_clients";
    }





    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientServiceImp.getClientById(id);
        model.addAttribute("client", client);
        return "update_client";
    }

    @PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "update_client";
        }

        clientServiceImp.updateClient(client);
        return "redirect:/all";
    }




    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable("id") long id) {

        clientServiceImp.deleteClient(id);
        return "redirect:/all";
    }
}
