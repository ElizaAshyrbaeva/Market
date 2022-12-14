package Market.enams;

import java.util.Collection;

public enum Product  {
    MILK("Milk",230),
    CHOKOLATE("Chokalat",300),
    TEA("Tea",120),
    COLA("Cola",80),
    MAY("May",700),
    APPLE("Apple",50),
    BANANA("Banana",160),
    BREAT("Breat",35),
    MEAT("Meat",500);

    String name;
    double price;
    Product(String name,double price) {
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
