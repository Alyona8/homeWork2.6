package transport;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineVolume;


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

    abstract void startMove();

    abstract void finishMove();

    public abstract void printType();

    public abstract boolean service();

    @Override
    public String toString() {
        return ", марка: " + brand + ", модель " + model + ", объём двигателя " + engineVolume;
    }
}