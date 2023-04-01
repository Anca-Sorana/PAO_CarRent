package pao.service.impl;

import pao.model.Client;
import pao.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
    private static List<Client> clientList = new ArrayList<>();
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
}
