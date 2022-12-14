import Market.calsses.Person;
import Market.enams.Product;
import Market.service.PersonImpl;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product>products = new ArrayList<>(List.of(Product.APPLE,Product.MAY,Product.COLA,Product.
                BANANA,Product.TEA,Product.CHOKOLATE,Product.BREAT,Product.MILK,Product.MEAT));



        Person person1 = new Person("Eliza",18,"0225171735",new BigDecimal(10000),products);
        Person person2 = new Person("Nuriza",20,"0999222333",new BigDecimal(15000),products);
        Person person3 = new Person("Alibek",22,"0222333444",new BigDecimal(12000),products);
        Person person4 = new Person("Adil",23,"0777555666",new BigDecimal(5000),products);
        Person person5 = new Person("Begimai",25,"0555444999",new BigDecimal(9000),products);
        ArrayList<Person>people = new ArrayList<>(Arrays.asList(person1,person2,person3,person4,person5));
        PersonImpl person = new PersonImpl();
    while (true){
        System.out.println("""
                1.Create Shop ->
                2.Find By Shop Address->
                3.Get All Shop->
                4.Food Search By Name->
                5.Find By Name Person->
                6.Get All Person->
                7.Max Product->              
                8.Min Product->
                9.Get All Product->
                10.Sopping->
                """);
        int number = new Scanner(System.in).nextInt();
        switch (number){
            case 1-> System.out.println(person.createShop());
            case 2-> System.out.println(person.findByShopAddress());
            case 3-> System.out.println(person.getAllShops());
            case 4-> System.out.println(person.FoodSearchByName());
            case 5-> System.out.println(person.findByName(new Scanner(System.in).nextLine()));
            case 6-> System.out.println(person.getAllPerson());
            case 7-> person.maxProduct(products);
            case 8->person.minProduct(products);
            case 9-> System.out.println(person.getAllProduct(products));
            case 10-> System.out.println(person.sopping());
        }
    }

    }
}