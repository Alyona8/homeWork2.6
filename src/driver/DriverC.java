package driver;

import transport.Truck;

public class DriverC extends Driver<Truck> {
    public DriverC(String name, Integer experience) {
        super(name, 'C', experience);
    }
}