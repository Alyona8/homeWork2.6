package driver;

import transport.Car;

public class DriverB extends Driver<Car> {
    public DriverB(String name, Integer experience) {
        super(name, 'B', experience);
    }
}