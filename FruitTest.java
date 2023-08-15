import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FruitTest {

    @Test
    public void testCheckDiscount_Local_True() {
        Fruit localFruit = new Fruit("LocalFruit", 100, 10, true);
        int quantity = 5;

        int expectedDiscount = 30;
        int actualDiscount = localFruit.checkDiscount(quantity);

        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testCheckDiscount_Local_False() {
        Fruit nonLocalFruit = new Fruit("NonLocalFruit", 100, 10, false);
        int quantity = 4;

        int expectedDiscount = 15;
        int actualDiscount = nonLocalFruit.checkDiscount(quantity);

        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testCheckDiscount_QuantityLessThan3() {
        Fruit fruit = new Fruit("TestFruit", 100, 10, true);
        int quantity = 2;

        int expectedDiscount = 0;
        int actualDiscount = fruit.checkDiscount(quantity);

        assertEquals(expectedDiscount, actualDiscount);
    }
}
