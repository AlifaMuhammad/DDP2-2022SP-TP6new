import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import product.Product;

public class CustomerTest {

    private Customer customer;
    private Product product;

    @BeforeEach
    public void setUp() {
        customer = new Customer("TestCustomer");
        product = new Product("TestProduct", 100, 10) {
            @Override
            public int checkDiscount(int quantity) {
                return 0;
            }
        };
    }

    @Test
    public void testAddToCartWithSufficientStock() {
        int quantity = 1;
        customer.addToCard(product, quantity);
        assertEquals(quantity, customer.getCart().getOrderList().size());
    }

    @Test
    public void testAddToCartWithInsufficientStock() {
        int quantity = 15;
        customer.addToCard(product, quantity);
        assertTrue(customer.getCart().getOrderList().isEmpty());
    }

    @Test
    public void testCheckoutWithItems() {
        int quantity = 3;
        customer.addToCard(product, quantity);

        double expectedTotalPrice = product.getPrice() * quantity;
        LocalDate currentDate = LocalDate.now();

        customer.checkout();
        assertEquals(1, customer.getOrderHistory().size());

        Order order = customer.getOrderHistory().get(0);
        assertEquals(expectedTotalPrice, order.getTotalPrice());
        assertEquals(currentDate, order.getOrderDate());

        assertEquals(0, customer.getCart().getOrderList().size());
    }

    @Test
    public void testCheckoutWithEmptyCart() {
        customer.checkout();
        assertTrue(customer.getOrderHistory().isEmpty());
    }

    @Test
    public void testCheckoutWithItemsAndCartNotEmpty() {
        int quantity = 3;
        customer.addToCard(product, quantity);

        assertFalse(customer.getCart().getOrderList().isEmpty());

        customer.checkout();
        assertEquals(1, customer.getOrderHistory().size());

        Order order = customer.getOrderHistory().get(0);
        assertEquals(0, customer.getCart().getOrderList().size());
    }
}
