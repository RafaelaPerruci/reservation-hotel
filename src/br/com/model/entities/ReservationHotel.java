package br.com.model.entities;

import java.time.LocalDate;

public class ReservationHotel {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

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
        
    }

}
