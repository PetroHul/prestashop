package data;

public enum Search {
    SEARCH("name"),
    MUG("mug"),
    SFDD("sfdd"),
    CUP1("Cups1");

    String name;

    Search(String name){
    this.name=name;
    }

    public String getName() {
        return name;
    }
    public String getSearchBodyText() {
        return String.format("%s",
                name);
    }
}

