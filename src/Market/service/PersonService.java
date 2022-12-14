package Market.service;

import Market.calsses.Person;
import Market.calsses.Shop;
import Market.enams.Product;

import java.util.List;

public interface PersonService {
    String createShop();
    List<Shop>getAllShops();
    String findByShopAddress();
    List<Product>FoodSearchByName();
    List<Person>getAllPerson();
    List<Person>findByName(String name);
    void maxProduct(List<Product>products);
    void minProduct(List<Product>products);
    List<Product>getAllProduct(List<Product>products);
    String sopping();


}
