package pao.repository.impl;

import pao.config.DatabaseConfiguration;
import pao.mapper.ReservationMapper;
import pao.model.Reservation;
import pao.repository.ReservationRepository;
import pao.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public class ReservationRepositoryImpl implements ReservationRepository {
    private static final ReservationMapper reservationMapper = ReservationMapper.getInstance();

    @Override
    public Optional<Reservation> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM reservation WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return reservationMapper.mapToReservation(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM reservation WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Reservation newObject) {
        String updateNameSql = "UPDATE reservation SET price=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, String.valueOf(newObject.getPrice()));
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Reservation reservationClass) {
        String insertSql = "INSERT INTO reservation (id, price, id_car, startdate, enddate, id_client) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, reservationClass.getId().toString());
            preparedStatement.setString(2, String.valueOf(reservationClass.getPrice()));
            preparedStatement.setString(3, String.valueOf(reservationClass.getCar().getId()));
            preparedStatement.setString(4, String.valueOf(reservationClass.getStartDate()));
            preparedStatement.setString(5, String.valueOf(reservationClass.getEndDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> getAll() {
        String selectSql = "SELECT * FROM reservation";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return reservationMapper.mapToReservationList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Reservation> exampleClassList) {
        exampleClassList.forEach(this::addNewObject);
    }
}
