import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import product.Product;

public class OrderItemTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("TestProduct", 100, 10) {
            @Override
            public int checkDiscount(int quantity) {
                return 20;
            }
        };
    }

    @Test
    public void testGetFinalPrice() {
        int quantity = 3;
        OrderItem orderItem = new OrderItem(product, quantity);

        double expectedFinalPrice = product.getPrice() * quantity * (1 - (product.checkDiscount(quantity) / 100.0));
        double actualFinalPrice = orderItem.getFinalPrice();

        assertEquals(expectedFinalPrice, actualFinalPrice);
    }

    @Test
    public void testToString() {
        int quantity = 2;
        OrderItem orderItem = new OrderItem(product, quantity);

        String expectedString = String.format("%s  %d kg  %f", product.getName(), quantity, orderItem.getFinalPrice());
        String actualString = orderItem.toString();

        assertEquals(expectedString, actualString);
    }
}
