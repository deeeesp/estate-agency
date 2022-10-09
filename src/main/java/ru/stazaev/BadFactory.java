package ru.stazaev;

import ru.stazaev.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BadFactory {

    public void init(ApplicationContext applicationContext){
        for (int i = 0; i < 4; i++) {
            List<Flat> flats = new ArrayList<>();
            List<Client> clients = new ArrayList<>();
            List<Deal> deals = new ArrayList<>();
            for (int j = 0; j < (int) (1 + Math.random()*20); j++) {
                flats.add(new FlatImpl((int) (1 + Math.random()*3),(int) (1 + Math.random()*100)));
            }
            for (int j = 0; j < (int) (1 + Math.random()*10); j++) {
                clients.add(new ClientImpl("name", (int) (1 + Math.random()*10000000)));
            }
            deals.add(new DealImpl(flats.get((int) (1+ Math.random()*(flats.size()-2))),clients.get((int) (1+ Math.random()*(clients.size()-2)))));
            Worker worker = new WorkerImpl(flats,clients);
            applicationContext.getCache().put(worker,deals);
        }
    }
}
