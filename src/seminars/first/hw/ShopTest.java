package seminars.first.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.setProducts(Arrays.asList(
                new Product("Сахар", 80),
                new Product("Греча", 20),
                new Product("Ролтон", 20),
                new Product("Стиральный порошок", 220),
                new Product("Автомобиль", 1244420),
                new Product("Вертолет", 386),
                new Product("Булка с маком", 550)
        ));
        List<String> products = new ArrayList<>();
        for (var product : shop.getProducts()) {
            products.add(product.getTitle());
        }
        tes1_CountAndTitles(products);

        test2_getMostExpensiveProduct(shop);

        List<Integer> costs = new ArrayList<>();
        for (var product : shop.getSortedListProducts()) {
            costs.add(product.getCost());
        }
        test3_sortTest(costs);

        System.out.println("Все тесты пройдены!");
    }
    public static void tes1_CountAndTitles(List<String > products) {

        assertThat(products).isNotEmpty()
                    .hasSize(7)
                    .doesNotHaveDuplicates()
                    .contains("Ролтон", "Греча", "Стиральный порошок")
                    .endsWith("Булка с маком")
                    .startsWith("Сахар")
                    .containsSequence("Автомобиль", "Вертолет")
                    .doesNotContain("Соль", "Батарейки");
    }

    public static void test2_getMostExpensiveProduct(Shop shop) {
        assertThat(shop.getMostExpensiveProduct().getTitle()).isEqualTo("Автомобиль");
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(1244420);
    }

    public static void test3_sortTest(List<Integer> costs) {
        assertThat(costs).containsSequence(1244420, 550, 386, 220, 80, 20, 20);
    }
}




