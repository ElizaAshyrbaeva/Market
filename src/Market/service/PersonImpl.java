package Market.service;

import Market.calsses.Person;
import Market.calsses.Shop;
import Market.enams.Product;

import java.util.*;

public class PersonImpl implements PersonService {
    List<Person> people = new ArrayList<>();
    List<Shop> shops = new ArrayList<>();

    @Override
    public String createShop() {
        System.out.println("Маркет ID :");
        long id = new Scanner(System.in).nextLong();

        System.out.println("Название shop  :");
        String shopName = new Scanner(System.in).nextLine();

        System.out.println("Введите адрес магазина :");
        String shopAddress = new Scanner(System.in).nextLine();

        System.out.println(" Вы хотите включить продукты (да/нет):");
        String product = new Scanner(System.in).nextLine();

        List<Product> products;
        if (product.equals("Да")) products = new ArrayList<>(List.of(Product.values()));
        else products = new ArrayList<>();

        Shop shop = new Shop(shopName, id, shopAddress, products);
        shops.add(shop);


        return "Shop create successfully ";
    }

    @Override
    public List<Shop> getAllShops() {
        return shops;
    }


    @Override
    public String findByShopAddress() {
        System.out.println("Enter shop name :");
        String shopName = new Scanner(System.in).nextLine();

        for (Shop shop : shops) {
            if (shop.getName().equals(shopName.toUpperCase())) ;
            return shop.getAddress();

        }
        return null;
    }

    @Override
    public List<Product> FoodSearchByName() {
        List<Product> products = new ArrayList<>();
        System.out.println("Write a shop  name :");
        String shopName = new Scanner(System.in).nextLine();
        for (Shop shop : shops) {
            if (shop.getName().equals(shopName)) {
                System.out.println("Write a product name :");
                String productName = new Scanner(System.in).nextLine();

                for (Product product : shop.getProducts()) {
                    if (product.name().contains(productName.toUpperCase())) ;
                    products.add(product);
                }
            }
        }

        return products;
    }

    @Override
    public List<Person> getAllPerson() {
        return people;
    }

    @Override
    public List<Person> findByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                people.add(person);
            }
        }
        return people;
    }

    Comparator<Product> productComparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    };

    @Override
    public void maxProduct(List<Product> products) {
        System.out.println(Collections.max(products, productComparator));
        products.sort(productComparator);

    }

    @Override
    public void minProduct(List<Product> products) {
        System.out.println(Collections.min(products, productComparator));
        products.sort(productComparator);
    }

    @Override
    public List<Product> getAllProduct(List<Product> products) {
        return products;
    }

    @Override
    public String sopping() {
        System.out.print("Write your name :");
        String name = new Scanner(System.in).nextLine();

        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                System.out.println("Write shop name :");
                String shopName = new Scanner(System.in).nextLine().toLowerCase();

                for (Shop shop : shops) {
                    if (shop.getName().equalsIgnoreCase(name.toLowerCase())) {
                        List<String> discountedProducts = new ArrayList<>();
                        double totalDiscountedPrice = 0;
                        while (true) {
                            for (Product product : shop.getProducts()) {
                                System.out.println(product.name() + " " + product.getPrice());
                            }

                            System.out.print("Choose your product : ");
                            String productName = new Scanner(System.in).nextLine().toLowerCase();


                            if (productName.equals("checkout()")) {
                                System.out.print("Are you sure that you want to checkout? (yes/no) : ");
                                String confirmation = new Scanner(System.in).nextLine().toLowerCase();
                                if (confirmation.equals("yes")) {
                                    System.out.println("Your cart : " + shop.getProducts());
                                    double totalPrice = 0;
                                    for (Product product : shop.getProducts()) {
                                        double price = product.getPrice();
                                        totalPrice += price;
                                    }
                                    System.out.println("Total price is : " + totalPrice);
                                    System.out.println("Total price with DISCOUNTS : " + (totalPrice - totalDiscountedPrice));
                                    System.out.print("Confirm your purchase? (yes/no) : ");
                                    String confirmPurchase = new Scanner(System.in).nextLine().toLowerCase();
                                    if (confirmPurchase.equals("yes")) {

                                    }
                                }
                            }

                            for (Product product : shop.getProducts()) {
                                if (product.name().toLowerCase().equals(productName)) {
                                    System.out.print("Confirm your purchase? (yes/no) : ");

                                    if (product.getPrice() < 1) {
                                        discountedProducts.add(product.getName() + " : " + (product.getPrice() * product.getPrice()));
                                        totalDiscountedPrice += product.getPrice() * product.getPrice();
                                    }

                                }

                            }
                        }
                    }
                }
            }
        }
        return null;
    };




    public String createAnInvoice(String name, String shopName, List<Product> products, double totalPrice, List<String> discounts, double generalDiscountedPrice) {
        return ">>>>>>>>>>СЧЕТ <<<<<<<<<< \n" +
                " * Person : " + name + "\n" +
                " * Shop : " + shopName + "\n" +
                " * Список продуктов : " + products + "\n" +
                " * Итоговая цена : " + totalPrice + "\n" +
                " * Скидки : " + discounts + "\n" +
                " * Общая стоимость со скидками : " + generalDiscountedPrice + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "#    СПАСИБО ЗА ПОКУПКУ     #";
    }

    }

