import data.Data;
import driver.DriverB;
import transport.*;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        boolean success = Data.validate("test", "test", "test");
        if (success) {
            System.out.println("Данные верны");
        } else {
            System.out.println("Неверные данные");
        }
        System.out.println();

        Mechanic<Car> anton = new Mechanic<Car>("Антон", "Звонов", "Avtostok");
        Mechanic<Transport> petr = new Mechanic<Transport>("Петр", "Петров", "Truck");
        Sponsor lukoil = new Sponsor("Лукойл", 2_000_000);
        Sponsor michelin = new Sponsor("Michelin", 3_000_000);

        Car bmw = new Car("BMW", "X-5", 2, TypeOfBody.CROSSOVER);
        bmw.addMechanic (anton);
        bmw.addSponsor(lukoil, michelin);
        System.out.println(bmw);
        System.out.println();
        Truck maz = new Truck("МАЗ", "535", 5.9, Weight.N1);
        maz.addMechanic(petr);
        maz.addSponsor(michelin);
        System.out.println(maz);
        System.out.println();
        Bus daewoo = new Bus("Daewoo", "BC212MA", 2.1, Capacity.SMALL);
        daewoo.addMechanic(petr);
        daewoo.addSponsor(lukoil);
        System.out.println(daewoo);
        daewoo.bestTime();
        System.out.println();
        service(bmw, maz, daewoo);

        List<Transport> transports = List.of(bmw, maz, daewoo);

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(bmw);
        serviceStation.addTruck(maz);
        serviceStation.service();
        serviceStation.service();

        for (Transport transport : transports) {
            printInfo(transport);
        }
        }

    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Спонсоры:");
        for (Sponsor sponsor : transport.getSponsors()) {
            System.out.println(sponsor.getName() + " " + sponsor.getAmount());
        }
        System.out.println("Механики:");
        for (Mechanic<?> mechanic : transport.getMechanics()) {
            System.out.println(mechanic.getName() + " " + mechanic.getSurname() + " " + mechanic.getCompany());
        }
    }

        private static void service (Transport...transports){
            for (Transport transport : transports) {
                if (!transport.service()) {
                    serviceTransport(transport);
                }
            }
        }

        private static void serviceTransport (Transport transport){
            try {
                if (!transport.service()) {
                    throw new RuntimeException("Автомобиль " + transport.getBrand() + " " +
                            transport.getModel() + " не прошёл диагностику");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


