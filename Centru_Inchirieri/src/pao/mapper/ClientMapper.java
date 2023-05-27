package pao.mapper;

import pao.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientMapper {

    private static final ClientMapper INSTANCE = new ClientMapper();

    private ClientMapper() {
    }

    public static ClientMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Client> mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .type(resultSet.getString(2))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Client> mapToClientList(ResultSet resultSet) throws SQLException {
        List<Client> ClientList = new ArrayList<>();
        while (resultSet.next()) {
            ClientList.add(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .type(resultSet.getString(2))
                            .build()
            );
        }

        return ClientList;
    }
}