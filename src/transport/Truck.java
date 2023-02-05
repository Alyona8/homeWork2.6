package transport;

public class Truck extends Transport implements Competing {
    private Weight weight;

    public Truck(String brand, String model, double engineVolume, Weight weight) {
        super(brand, model, engineVolume);
        this.weight = weight;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    void startMove() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + "  начинает движение");
    }

    @Override
    void finishMove() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " заканчивает движение");
    }

    @Override
    public void printType() {
        if (weight == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            String from = weight.getFrom() == null ? "" : "от " + weight.getFrom();
            String to = weight.getTo() == null ? "" : " до " + weight.getTo();
            System.out.println("Грузоподъемность автомобиля " + from + to + " тонн");
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.75;
    }

    @Override
    public void pitstop() {
        System.out.println("Проверка технического состояния грузового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void bestTime() {
        System.out.println("Лучшее время круга грузового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void maxSpeed() {
        System.out.println("Достигнута максимальная скорость грузового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль" + super.toString() + ", грузоподъёмность от " + weight.getFrom() +
                " до " + weight.getTo() + " тонн";
    }

    @Override
    public void repair() {
        System.out.println("Грузовая машина " + getBrand() + " " + getModel() + " починена");
    }
}