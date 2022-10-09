package ru.stazaev.model;

public abstract class Client {
    private String name = "name";
    private int balance;

    public Client(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
