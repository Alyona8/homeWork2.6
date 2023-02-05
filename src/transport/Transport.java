package transport;

import driver.DriverB;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private final List<Driver> drivers = new ArrayList<>();
    private final List<Mechanic<?>> mechanics = new ArrayList<>();
    private final List<Sponsor> sponsors = new ArrayList<>();


    public Transport(String brand, String model, double engineVolume) {
        if (brand == null) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (Double.compare(engineVolume, 0) == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }
    public void addDriver (Driver... drivers) {
        this.drivers.addAll(Arrays.asList(drivers));
    }
    public void addMechanic (Mechanic<?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }
    public void addSponsor (Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    abstract void startMove();

    abstract void finishMove();

    public abstract void printType();

    public abstract boolean service();

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    @Override
    public String toString() {
        return ", марка: " + brand + ", модель " + model + ", объём двигателя " + engineVolume;
    }

    public abstract void repair();

}