package ru.stazaev;

import ru.stazaev.model.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public void start() {
        ApplicationContext applicationContext = new ApplicationContext();
        BadFactory badFactory = new BadFactory();
        badFactory.init(applicationContext);
        Map<Worker, List<Deal>> map = applicationContext.getCache();
        Announcer announcer = new ConsoleAnnouncer();
        Demonstrator demonstrator = new DemonstratorImpl();
        while (true) {
            announcer.announce("""
                    1. Получить список квартир\s

                    2. Получить список квартир определенного работника\s
                                        
                    3. Получить квартиру по id работника и id квартиры\s
                                        
                    4. Получить список всех клиентов\s
                                        
                    5. Получить список клиентов по id работника\s
                                        
                    6. Получить список всех сделок\s
                                        
                    7. Получить список сделок по id работника\s
                                        
                    8. Провести сделку\s
                    
                    99. Закрыть программу\s
                    """);
            /**
             * провести сделку
             * продать/купить квартиру, но это в сделке будет
             */
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    for (int i = 0; i < map.size(); i++) {
                        System.out.println("Квартиры работника под номером " + i + "\n");
                        demonstrator.demonstrate(applicationContext.getWorkerById(i).getFlats());
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    announcer.announce("Введите id работника");
                    demonstrator.demonstrate(applicationContext.getWorkerById(new Scanner(System.in).nextInt()).getFlats());
                    break;
                case 3:
                    announcer.announce("Введите id работника, потом id квартиры");
                    demonstrator.demonstrateFlat(applicationContext.getWorkerById(new Scanner(System.in).nextInt()).getFlats().get(new Scanner(System.in).nextInt()));
                    System.out.println("\n");
                    break;
                case 4:
                    for (int i = 0; i < map.size(); i++) {
                        System.out.println("Клиенты работника под номером " + i + "\n");
                        for (int j = 0; j < applicationContext.getWorkerById(i).getClients().size(); j++) {
                            System.out.println(applicationContext.getWorkerById(i).getClients().get(j).toString());
                        }
                        System.out.println("\n");
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Введите id работника ");
                    int id = new Scanner(System.in).nextInt();
                    for (int i = 0; i < applicationContext.getWorkerById(id).getClients().size(); i++) {
                        System.out.println(applicationContext.getWorkerById(id).getClients().get(i).toString());
                    }
                    System.out.println("\n");
                    break;
                case 6:
                    for (int i = 0; i < map.size(); i++) {
                        System.out.println("Сделки работника под номером " + i + "\n");
                        for (int j = 0; j < applicationContext.getDealsById(i).size(); j++) {
                            System.out.println(applicationContext.getDealsById(i).get(j).toString());
                        }
                        System.out.println("\n");
                    }
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("Введите id работника ");
                    int deal = new Scanner(System.in).nextInt();
                    for (int i = 0; i < applicationContext.getDealsById(deal).size(); i++) {
                        System.out.println(applicationContext.getDealsById(deal).get(i).toString());
                    }
                    System.out.println("\n");
                    break;
                case 8:
                    System.out.println("Введите id работника ");
                    int workerId = new Scanner(System.in).nextInt();
                    System.out.println("Ведите id клиента ");
                    int clientId = new Scanner(System.in).nextInt();
                    //Добавить обработку нового клиента
                    System.out.println("Ведите тип сделки, к - купить квартиру у агенства, п - продать квартиру агенству");
                    if (new Scanner(System.in).next().equals("к")){
                        System.out.println("Введите id квартиры");
                        int flatId =  new Scanner(System.in).nextInt();
                        applicationContext.getDealsById(workerId).add(new DealImpl(applicationContext.getWorkerById(workerId).getFlats().get(flatId),
                                applicationContext.getWorkerById(workerId).getClients().get(clientId)));
                        applicationContext.getWorkerById(workerId).getFlats().remove(flatId);
                        System.out.println("Сделка проведена успешно " + " worker id " + workerId + " client id " + clientId);
                    }else {
                        System.out.println("Введите количество комнат");
                        int rooms = new Scanner(System.in).nextInt();
                        System.out.println("Введите количество квадратных метров");
                        int meters = new Scanner(System.in).nextInt();
                        Flat flat = new FlatImpl(rooms,meters);
                        Deal sold = new DealImpl(flat,applicationContext.getWorkerById(workerId).getClients().get(clientId));
                        applicationContext.getWorkerById(workerId).getFlats().add(flat);
                        applicationContext.getDealsById(workerId).add(sold);
                        System.out.println("Агенство успешно купило квартиру");
                    }
                    System.out.println("\n");
                    break;
                case 99:
                return;
            }
        }
    }
}
