package data;

public enum Country {
    AUSTRIA ("Austria", "2"),
    AZERBAIJAN ("Azerbaijan", "47"),
    BELARUS ("Belarus", "52"),
    BELGIUM ("Belgium", "3"),
    BULGARIA ("Bulgaria", "236"),
    DENMARK ("Denmark", "20"),
    GERMANY ("Germany", "1"),
    ITALY ("Italy", "10"),
    NETHERLANDS ("Netherlands", "13"),
    POLAND ("Poland", "14"),
    UKRAINE ("Ukraine", "216"),
    UNITED_KINGDOM ("United Kingdom", "17");

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
