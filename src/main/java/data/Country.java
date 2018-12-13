package data;

public enum Country {
    UKRAINE ("Ukraine", "216");

    private String nameEn;
    private String value;

    Country(String en, String value) {
        this.nameEn = en;
        this.value = value;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getValue() {
        return value;
    }
}
