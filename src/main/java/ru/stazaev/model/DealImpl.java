package ru.stazaev.model;

public class DealImpl extends Deal implements DealIfc{

    private Flat flat;
    private Client client;

    public DealImpl(Flat flat, Client client) {
        this.flat = flat;
        this.client = client;
    }

    public DealImpl(){}

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Квартира " + flat + " клиент "+ client;
    }
}
