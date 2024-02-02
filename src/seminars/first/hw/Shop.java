package seminars.first.hw;

import java.util.*;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        List<Product> sortProduct = new ArrayList<>(products);
        Collections.sort(sortProduct);
        return sortProduct;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        return getSortedListProducts().get(0);
    }

}
