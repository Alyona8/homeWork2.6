package driver;

import transport.Competing;
import transport.Transport;

abstract class Driver<T extends Transport & Competing> {
    private final String name;
    private final char license;
    private Integer experience;

    protected Driver(String name, Character license, Integer experience) {
        if (name == null || name.isBlank()) {
            this.name = "default";
        } else {
            this.name = name;
        }
        if (license == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав!");
        } else {
            this.license = license;
        }
        setExperience(experience);
    }

    public String getName() {
        return name;
    }

    public Character getLicense() {
        return license;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        if (experience == null || experience < 0) {
            throw new IllegalArgumentException("default");
        } else {
            this.experience = experience;
        }
    }

    public void start(T transport) {
        System.out.println(name + " начинает движение " + transport.getBrand() + " " + transport.getModel());
    }

    public void stop(T transport) {
        System.out.println(name + " останавливает " + transport.getBrand() + " " + transport.getModel());
    }

    public void refillCar(T transport) {
        System.out.println(name + " заправляет " + transport.getBrand() + " " + transport.getModel());
    }

    public void printInfo(T transport) {
        System.out.println("Водитель " + name + " управляет " + transport.getBrand() + " " + transport.getModel() +
                " и будет участвовать в заезде");
    }
}