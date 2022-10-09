package ru.stazaev.model;

public class ClientImpl extends Client implements ClientIfc{
    private String name;
    private int balance;

    public ClientImpl(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }


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

    public String toString() {
        return "Имя клиента " + name + " бюджет " + balance;
    }
}
