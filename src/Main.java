import data.Data;
import transport.*;

public class Main {
    public static void main(String[] args) {
        boolean success = Data.validate("test", "test", "test");
        if (success) {
            System.out.println("Данные верны");
        } else {
            System.out.println("Неверные данные");
        }
        System.out.println();

        Car bmw = new Car("BMW", "X-5", 2, TypeOfBody.CROSSOVER);
        Car audi = new Car("Audi", "A-8", 1.7, TypeOfBody.SEDAN);
        Car vesta = new Car("Lada", "Vesta", 1.6, TypeOfBody.SEDAN);
        Car megane = new Car("Renault", "Megane", 1.8, TypeOfBody.SEDAN);
        System.out.println(bmw);
        System.out.println(audi);
        System.out.println(vesta);
        System.out.println(megane);
        audi.pitstop();
        System.out.println();
        Truck maz = new Truck("МАЗ", "535", 5.9, Weight.N1);
        Truck hyundai = new Truck("Hyundai", "Mighty", 7, Weight.N2);
        Truck kamaz = new Truck("КамАЗ", "65207", 8.2, Weight.N3);
        Truck isuzu = new Truck("ISUZU", "ELF", 8.5, Weight.N1);
        System.out.println(maz);
        System.out.println(hyundai);
        System.out.println(kamaz);
        System.out.println(isuzu);
        kamaz.maxSpeed();
        System.out.println();
        Bus daewoo = new Bus("Daewoo", "BC212MA", 2.1, Capacity.SMALL);
        Bus nefaz = new Bus("НЕФАЗ", "5299-32", 3.4, Capacity.AVERAGE);
        Bus mercedes = new Bus("Mercedes", "Benz Conecto", 5, Capacity.EXTRA_LARGE);
        Bus volvo = new Bus("Volvo", "9900", 4.7, Capacity.LARGE);
        System.out.println(daewoo);
        System.out.println(nefaz);
        System.out.println(mercedes);
        System.out.println(volvo);
        daewoo.bestTime();
        System.out.println();
        service(bmw, audi, vesta, megane,
                maz, hyundai, kamaz, isuzu,
                daewoo, nefaz, mercedes, volvo);
    }

    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            if (!transport.service()) {
                serviceTransport(transport);
            }
        }
    }

    private static void serviceTransport(Transport transport) {
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