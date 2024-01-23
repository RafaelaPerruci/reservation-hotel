package br.com.application;

import br.com.model.entities.ReservationHotel;
import br.com.model.exception.DomainException;
import java.time.LocalDate;
import java.util.Scanner;

import static br.com.model.entities.ReservationHotel.fmt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationHotel reservation = new ReservationHotel();

        boolean continua = true;

            while (continua) {

            try {
                System.out.print("Room number: ");
                int number = sc.nextInt();
                reservation.setRoomNumber(number);
                System.out.print("Check-in date (dd/MM/yyyy): ");
                LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
                System.out.print("Check-out date (dd/MM/yyyy): ");
                LocalDate checkOut = LocalDate.parse(sc.next(), fmt);
                /*
                 * Ou posso apagar a instanciação do construtor padrão e instanciar um construtor com argumentos:
                 * ReservationHotel reservation = new ReservationHotel(number, checkIn, checkOut);
                 * pois a lógica de validação da data também está no construtor
                 * */
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
                System.out.println();

                System.out.println("Do you want to update your reservation?(y/n)");
                char ch = sc.next().toLowerCase().charAt(0);

                if (ch == 'n') {
                    continua = false;
                } else if (ch == 'y') {
                    System.out.println("Enter data to update the reservation:");
                    System.out.print("Check-in date (dd/MM/yyyy): ");
                    checkIn = LocalDate.parse(sc.next(), fmt);
                    System.out.print("Check-out date (dd/MM/yyyy): ");
                    checkOut = LocalDate.parse(sc.next(), fmt);

                    reservation.updateDates(checkIn, checkOut);
                    System.out.println("Reservation: " + reservation);
                }
            }
            catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println("Unexpected error");
            }
            /*
            * Já existe uma exceção pronta no java para esta validação, que é a IllegalArgumentException e,
            * porém a intenção deste cósigo é aprender a personalizar uma exceção própria
            * */
        }
    }
}