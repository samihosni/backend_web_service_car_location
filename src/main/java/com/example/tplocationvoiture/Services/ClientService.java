package com.example.tplocationvoiture.Services;



import com.example.tplocationvoiture.entities.Client;

import java.util.List;

public interface ClientService {
    Client getClientByNom(String nom);
    List<Client> getAllClient();
    Client createClient(Client client);
    Client getClientById(Long id);
    Client updateClient(Client client);
    void deleteClient(Long id);
}
