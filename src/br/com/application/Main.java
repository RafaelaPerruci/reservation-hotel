package br.com.application;

import br.com.model.entities.ReservationHotel;

import java.time.LocalDate;
import java.util.Scanner;

import static br.com.model.entities.ReservationHotel.fmt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

        ReservationHotel reservation = new ReservationHotel(number, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        System.out.println();
        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = LocalDate.parse(sc.next(), fmt);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = LocalDate.parse(sc.next(), fmt);

        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation: " + reservation);



    }
}