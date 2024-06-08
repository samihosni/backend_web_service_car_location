package com.example.tplocationvoiture.Services.Imp;


import com.example.tplocationvoiture.Services.ClientService;
import com.example.tplocationvoiture.entities.Client;
import com.example.tplocationvoiture.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client getClientByNom(String nom) {

        return clientRepository.getClientByNom(nom);
    }

    @Override
    public List<Client> getAllClient() {

        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {

        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {

        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Long id) {
     clientRepository.deleteById(id);

    }
}
