package pao.service;

import pao.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    void addClient(Client client);
    void removeClient(UUID id);
    void modifyClient(UUID id, Client New);
    List<Client> allClients();
}
