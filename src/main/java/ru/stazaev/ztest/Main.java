package ru.stazaev.ztest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<List<Class>, String> map = new HashMap<>();
        List<Class> list = new ArrayList<>();
        list.add(new Class(1,1));
        list.add(new Class(2,2));
        map.put(list,"1");
        List<Class> l = new ArrayList<>();
        l.add(new Class(1,1));
        l.add(new Class(2,2));
        for (Map.Entry<List<Class>, String> listStringEntry : map.entrySet()) {
            System.out.println(listStringEntry.getValue());
        }
    }
}
