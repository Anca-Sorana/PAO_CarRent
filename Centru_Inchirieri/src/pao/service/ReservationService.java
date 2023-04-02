package pao.service;


import pao.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationService {
    Optional<Reservation> getById(UUID id);
    void addReservation(Reservation reservation);
    void removeReservation(UUID id);
    void modifyReservation(UUID id, Reservation New);
    List<Reservation> allReservation();
    void printReservation(Reservation reservation);
    void printAllReservations();
}
