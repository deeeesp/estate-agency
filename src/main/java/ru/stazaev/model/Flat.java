package ru.stazaev.model;

public abstract class Flat {
    private int roomsNumber;
    private int apartmentArea;

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

    public Flat(){}
}
