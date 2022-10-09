package ru.stazaev;

public class ConsoleAnnouncer implements Announcer{
    @Override
    public void announce(String s) {
        System.out.println(s);
    }
}
