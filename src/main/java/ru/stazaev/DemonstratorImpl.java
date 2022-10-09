package ru.stazaev;

import ru.stazaev.model.Demonstrator;
import ru.stazaev.model.Flat;

import java.util.List;

public class DemonstratorImpl implements Demonstrator {

    @Override
    public void demonstrate(List<Flat> flats) {
        for (int i = 0; i < flats.size(); i++) {
            System.out.println(i + " Количество комнат в квартире - " + flats.get(i).getRoomsNumber() + " количество квадратных метров " + flats.get(i).getApartmentArea());
        }
    }

    @Override
    public void demonstrateFlat(Flat flat) {
        System.out.println("Количество комнат в квартире - " + flat.getRoomsNumber() + " количество квадратных метров " + flat.getApartmentArea());
    }

}
