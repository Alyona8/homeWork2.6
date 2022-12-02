package transport;

public enum TypeOfBody {
    SEDAN("Седан"),
    HATCHBACK("Хетчбек"),
    COUPE("Купе"),
    UNIVERSAL("Универсал"),
    SUV("Внедорожник"),
    CROSSOVER("Кроссовер"),
    PICKUP("Пикап"),
    VAN("Фургон"),
    MINIVAN("Минивэн");

    private final String rus;

    TypeOfBody(String rus) {
        this.rus = rus;
    }

    public String getRus() {
        return rus;
    }
}