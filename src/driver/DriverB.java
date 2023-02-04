package driver;

import transport.Car;

public class DriverB extends Driver<Car> {
    public DriverB(String name, String experience) {
        super(name, 'B', Integer.valueOf(experience));
    }
}