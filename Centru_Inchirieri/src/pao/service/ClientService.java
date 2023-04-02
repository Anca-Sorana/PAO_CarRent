package pao.service;

import pao.model.Client;
import pao.model.Reservation;

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
    void addReservation(UUID id, Reservation reservation);
    void printClientById(UUID id);
    void printClientList();
}
