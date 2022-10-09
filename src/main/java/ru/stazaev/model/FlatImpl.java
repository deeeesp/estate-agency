package ru.stazaev.model;

public class FlatImpl extends Flat implements FlatIfc{
    private int roomsNumber;
    private int apartmentArea;

    public FlatImpl(int roomsNumber, int apartmentArea) {
        this.roomsNumber = roomsNumber;
        this.apartmentArea = apartmentArea;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public int getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(int apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    @Override
    public String toString() {
        return "Количество комнат в квартире - " + roomsNumber + " количество квадратных метров " + apartmentArea;
    }
}
