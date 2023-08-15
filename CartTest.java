import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import product.Product;

public class CartTest {

    private Cart cart;
    private Product product;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product = new Product("TestProduct", 100, 10) {
            @Override
            public int checkDiscount(int quantity) {
                return 0;
            }
        };
    }

    @Test
    public void testGetTotalPriceWithItems() {
        int quantity = 3;
        OrderItem orderItem = new OrderItem(product, quantity);
        cart.addOrderItem(orderItem);

        double expectedTotalPrice = product.getPrice() * quantity;

        double actualTotalPrice = cart.getTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void testGetTotalPriceWithEmptyCart() {
        double actualTotalPrice = cart.getTotalPrice();
        assertEquals(0, actualTotalPrice);
    }

    @Test
    public void testAddOrderItem() {
        int initialSize = cart.getOrderList().size();

        OrderItem orderItem = new OrderItem(product, 2);
        cart.addOrderItem(orderItem);

        int newSize = cart.getOrderList().size();
        assertEquals(initialSize + 1, newSize);
    }
}
