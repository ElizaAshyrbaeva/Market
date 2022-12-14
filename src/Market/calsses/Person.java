package Market.calsses;

import Market.enams.Product;


import java.math.BigDecimal;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private BigDecimal money;
    private List<Product> products;


    public Person(String name, int age, String phoneNumber, BigDecimal money, List<Product> products) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.products = products;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    @Override
    public String toString() {
        return "Person " +
                "name :" + name  +
                " age :" + age +
                " phoneNumber :" + phoneNumber  +
                " money :" + money +
                " products :" + products ;
    }
}
