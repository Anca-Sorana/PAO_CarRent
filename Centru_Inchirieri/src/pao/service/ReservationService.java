package pao.service;


import pao.model.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationService {
    void addReservation(Reservation reservation);
    void removeReservation(UUID id);
    void modifyReservation(UUID id, Reservation New);
    List<Reservation> allReservation();
    void printReservation(Reservation reservation);
//    int compareTo(Reservation reservation1, Reservation reservation2);
}
