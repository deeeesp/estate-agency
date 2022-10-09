package ru.stazaev;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("ru.stazaev");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    public <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }

        try {
            T  t = implClass.getDeclaredConstructor().newInstance();
            System.out.println(type.getCanonicalName());
            switch (type.getCanonicalName()){
                case "ru.stazaev.model.FlatIfc" -> System.out.println("flat");
                case "ru.stazaev.model.ClientIfc" -> System.out.println("client");
                case "ru.stazaev.model.WorkerIfc" -> System.out.println("worker");
                case "ru.stazaev.model.DealIfc" -> System.out.println("deal");
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e + implClass.toString() + " не имеет конструктора");
        }



    }
}
