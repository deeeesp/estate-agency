package ru.stazaev.model;

import java.util.List;

public abstract class Worker {
    private List<Flat> flats;
    private List<Client> clients;

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
