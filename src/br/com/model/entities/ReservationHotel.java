package br.com.model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReservationHotel {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;


    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ReservationHotel(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public ReservationHotel(){

    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    public void updateDates(LocalDate checkin, LocalDate checkout){
        this.checkIn = checkin;
        this.checkOut = checkout;
    }
    public long duration() {
        return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
    }

    @Override
    public String toString() {
        return String.format("Room - " + roomNumber +
                ", check-in: " + checkIn.format(fmt) +
                ", check-out: " + checkOut.format(fmt)) + ", " +
                duration() + " nights.";
    }
}
