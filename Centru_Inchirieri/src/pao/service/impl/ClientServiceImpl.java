package pao.service.impl;

import pao.model.Client;
import pao.model.Reservation;
import pao.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
    private static List<Client> clientList = new ArrayList<>();

    @Override
    public Optional<Client> getById(UUID id) {
        return clientList.stream()
                .filter(elem -> elem.getId().equals(id))
                .findAny();
    }

    @Override
    public void addClient(Client client) {
        clientList.add(client);
    }

    @Override
    public void removeClient(UUID id) {
        clientList = clientList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyClient(UUID id, Client New) {
        removeClient(id);
        addClient(New);
    }

    @Override
    public List<Client> allClients() {
        return clientList;
    }

    @Override
    public void printClient(Client client) {
        System.out.print("ID: ");
        System.out.println(client.getId());

        System.out.print("First Name: ");
        System.out.println(client.getFirst_name());

        System.out.print("Last Name: ");
        System.out.println(client.getLast_name());

        System.out.print("Email: ");
        System.out.println(client.getEmail());

        System.out.print("Phone Number: ");
        System.out.println(client.getPhone_number());

        System.out.print("Type: ");
        System.out.println(client.getType());

        System.out.println("Client's old reservations: ");
        if(client.getHistory().isEmpty())
            System.out.println("Null ");
        else {
            client.getHistory()
                    .forEach(element -> System.out.println(element.getId()));
        }
    }

    @Override
    public void addReservation(UUID id, Reservation reservation) {
        Optional<Client> client = getById(id);
        List<Reservation> res = client.get().getHistory();
        res.add(reservation);
        for(var elem : clientList) {
            if(elem.getId() == id) {
                elem.setHistory(res);
            }
        }
    }

    @Override
    public void printClientById(UUID id) {
        Optional<Client> client = getById(id);
        System.out.print("ID: ");
        System.out.println(client.get().getId());

        System.out.print("First Name: ");
        System.out.println(client.get().getFirst_name());

        System.out.print("Last Name: ");
        System.out.println(client.get().getLast_name());

        System.out.print("Email: ");
        System.out.println(client.get().getEmail());

        System.out.print("Phone Number: ");
        System.out.println(client.get().getPhone_number());

        System.out.print("Type: ");
        System.out.println(client.get().getType());

        System.out.println("Client's old reservations: ");
        if(client.get().getHistory().isEmpty())
            System.out.println("Null ");
        else {
            client.get().getHistory()
                    .forEach(element -> System.out.println(element.getId()));
        }
    }

    @Override
    public void printClientList() {
        for(int i = 0; i < clientList.size(); i++) {
            printClient(clientList.get(i));
        }
        if(clientList.size() == 0) {
            System.out.println("No clients left!");
        }
    }

}
