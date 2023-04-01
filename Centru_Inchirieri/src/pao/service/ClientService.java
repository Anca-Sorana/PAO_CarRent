package pao.service;

import pao.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    Optional<Client> getById(UUID id);
    void addClient(Client client);
    void removeClient(UUID id);
    void modifyClient(UUID id, Client New);
    List<Client> allClients();
    void printClient(Client client);
}
