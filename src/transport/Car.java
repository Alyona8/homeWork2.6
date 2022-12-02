package transport;

public class Car extends Transport implements Competing {

    private TypeOfBody typeOfBody;

    public Car(String brand, String model, double engineVolume, TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        this.typeOfBody = typeOfBody;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    @Override
    void startMove() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + "  начинает движение");
    }

    @Override
    void finishMove() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + "  заканчивает движение");
    }

    @Override
    public void printType() {
        if (typeOfBody == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            System.out.println("Тип кузова автомобиля " + typeOfBody.getRus());
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.7;
    }

    @Override
    public void pitstop() {
        System.out.println("Проверка технического состояния легкового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void bestTime() {
        System.out.println("Лучшее время круга легкового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void maxSpeed() {
        System.out.println("Достигнута максимальная скорость легкового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public String toString() {
        return "Легковой автомобиль" + super.toString() + ", тип кузова " + typeOfBody.getRus();
    }
}