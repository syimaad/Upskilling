package ArrayLists;

import java.util.ArrayList;

public class WebShopApp {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Fidget spinner", 3.99, "It's fun."));
        products.add(new Product("Earbud", 39.99, "Extremely clear sound. Waterproof."));
        products.add(new Product("Earbud", 39.99, "Extremely clear sound. Waterproof."));
        products.add(new Product("Phone", 500.00, "1oox zoom"));
        products.add(1, new Product("36 AAA batteries", 10.99, "High-performance alkaline batteries."));

        products.remove(2);

        products.set(0, new Product("Rubber duck", 5.99, "You can't have bath without this."));

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("The third element in the list:");
        System.out.println(products.get(2));

        System.out.println(products.size() + " products can be found in the list.");

    }
}