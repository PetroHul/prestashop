package data;

public enum Currencies {
    EUR("EUR"),
    UAH("UAH"),
    USD("USD");

    private String name;

    private Currencies(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

