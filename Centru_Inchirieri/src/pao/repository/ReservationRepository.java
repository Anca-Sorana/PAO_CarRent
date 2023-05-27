package pao.repository;

import pao.model.Client;
import pao.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    Optional<Reservation> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Reservation newObject);

    void addNewObject(Reservation reservationClass);

    List<Reservation> getAll();

    void addAllFromGivenList(List<Reservation> reservationList);
}
