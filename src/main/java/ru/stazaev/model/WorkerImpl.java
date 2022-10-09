package ru.stazaev.model;

import java.util.List;

public class WorkerImpl extends Worker implements WorkerIfc{
    private List<Flat> flats;
    private List<Client> clients;

    public WorkerImpl(List<Flat> flats, List<Client> clients) {
        this.flats = flats;
        this.clients = clients;
    }

    public WorkerImpl() {}

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
