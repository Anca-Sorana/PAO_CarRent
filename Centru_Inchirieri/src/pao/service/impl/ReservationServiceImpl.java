package pao.service.impl;

import pao.model.Reservation;
import pao.service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {
    private static List<Reservation> reservationList = new ArrayList<>();
    @Override
    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    @Override
    public void removeReservation(UUID id) {
        reservationList = reservationList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyReservation(UUID id, Reservation New) {
        removeReservation(id);
        addReservation(New);
    }

    @Override
    public List<Reservation> allReservation() {
        return reservationList;
    }

    @Override
    public void printReservation(Reservation reservation) {
        System.out.print("ID: ");
        System.out.println(reservation.getId());

        System.out.print("price: ");
        System.out.println(reservation.getPrice());

        System.out.print("Car:  ");
        System.out.println(reservation.getCar().getId());

        System.out.print("Start Date: ");
        System.out.println(reservation.getStartDate());

        System.out.print("End Date: ");
        System.out.println(reservation.getEndDate());
    }

//    @Override
//    public int compareTo(Reservation reservation) {
//        return reservation1.getPrice().compareTo(reservation2.getPrice());
//    }


}
