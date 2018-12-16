package data;

public enum Product {
    PRODUCT("name", "article", "count", "price"),

    CUPS1("Cups1", "12", "1", "23"),
    CUPS2("Cups2", "3", "5", "11"),
    CUPS3("Cups3", "52", "8", "43");

    String name;
    String article;
    String count;
    String price;

    Product(String name, String article, String count, String price) {
        this.name = name;
        this.article = article;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getArticle() {
        return article;
    }

    public String getCount() {
        return count;
    }

    public String getPrice() {
        return price;
    }

    public String getProductBodyText() {
        return String.format("%s\n%s %s\n%s",
                name, article, count, price);
    }
}