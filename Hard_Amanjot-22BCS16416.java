import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class HardLevelProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1000),
            new Product("Headphones", "Electronics", 200),
            new Product("T-Shirt", "Clothing", 25),
            new Product("Jeans", "Clothing", 50),
            new Product("Coffee", "Food", 10),
            new Product("Chocolate", "Food", 5),
            new Product("Smartphone", "Electronics", 800)
        );

        // Group by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Grouped by Category:");
        grouped.forEach((cat, list) -> {
            System.out.println(cat + ": " + list);
        });

        // Most expensive product per category
        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        maxByCategory.forEach((cat, prod) -> 
            System.out.println(cat + ": " + prod.get())
        );

        // Average price
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
