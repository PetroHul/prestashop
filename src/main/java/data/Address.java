package data;

public enum Address {
    USER ("alias", "firstName", "lastName", "company",
            "vatNumber", "address1", "address2", "00000",
            "city", Country.UKRAINE, "000000000"),
    EVA_PUPKINA ("Work", "Eva", "Pupkina", "Perspective",
            "12354678", "First street 1", "First street 2",
            "11111", "Pretty city", Country.UKRAINE,"+380998887766"),
    VASIA_PUPKIN ("Office", "Vasia", "Pupkin", "Perspective",
            "12354678", "Long street 1", "Long street 2",
            "22222", "Pretty city", Country.ITALY,"+380998887766");

    String alias;
    String firstName;
    String lastName;
    String company;
    String vatNumber;
    String address1;
    String address2;
    String postCode;
    String city;
    Country country;
    String phone;

    Address(String alias, String firstName, String lastName, String company,
            String vatNumber, String address1, String address2, String postCode,
            String city, Country country, String phone) {
        this.alias = alias;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.vatNumber = vatNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    public String getAlias() {
        return alias;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddressBodyText() {
        return String.format("%s\n%s %s\n%s\n%s\n%s\n%s\n%s %s\n%s\n%s",
                alias, firstName, lastName, company, vatNumber, address1, address2, postCode, city, country.getNameEn(), phone);
    }
}
