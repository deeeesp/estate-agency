package ru.stazaev;

import ru.stazaev.model.Deal;
import ru.stazaev.model.Worker;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {
    private Map<Worker, List<Deal>> cache = new LinkedHashMap<>();

    public Map<Worker, List<Deal>> getCache() {
        return cache;
    }

    public Worker getWorkerById(int ind){
        int counter = 0;
        for (Map.Entry<Worker, List<Deal>> workerListEntry : cache.entrySet()) {
            if (counter==ind){
                return workerListEntry.getKey();
            }
            counter++;
        }
        return null;
    }

    public List<Deal> getDealsById(int ind){
        int counter = 0;
        for (Map.Entry<Worker, List<Deal>> workerListEntry : cache.entrySet()) {
            if (counter==ind){
                return workerListEntry.getValue();
            }
            counter++;
        }
        return null;
    }
}
