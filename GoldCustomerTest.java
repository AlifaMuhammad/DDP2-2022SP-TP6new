import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import product.Product;

public class GoldCustomerTest {

    private GoldCustomer goldCustomer;
    private Product product;

    @BeforeEach
    public void setUp() {
        goldCustomer = new GoldCustomer("TestGoldCustomer");
        product = new Product("TestProduct", 100, 10) {
            @Override
            public int checkDiscount(int quantity) {
                return 0;
            }
        };
    }

    @Test
    public void testCheckoutWithItems() {
        int quantity = 3;
        goldCustomer.addToCard(product, quantity);

        double expectedTotalPrice = product.getPrice() * quantity * GoldCustomer.DISCOUNT_RATE;

        goldCustomer.checkout();

        assertEquals(1, goldCustomer.getOrderHistory().size());

        Order order = goldCustomer.getOrderHistory().get(0);
        assertEquals(expectedTotalPrice, order.getTotalPrice());
    }

    @Test
    public void testCheckoutWithEmptyCart() {
        goldCustomer.checkout();
        assertEquals(1, goldCustomer.getOrderHistory().size());
    }
}
