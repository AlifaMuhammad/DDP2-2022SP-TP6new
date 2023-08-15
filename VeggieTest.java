import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VeggieTest {

    @Test
    public void testCheckDiscount_Organic_Quantity5() {
        Veggie organicVeggie = new Veggie("OrganicVeggie", 150, 20, true);
        int quantity = 5;

        int expectedDiscount = 30;
        int actualDiscount = organicVeggie.checkDiscount(quantity);

        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testCheckDiscount_NonOrganic_Quantity4() {
        Veggie nonOrganicVeggie = new Veggie("NonOrganicVeggie", 100, 15, false);
        int quantity = 4;

        int expectedDiscount = 15;
        int actualDiscount = nonOrganicVeggie.checkDiscount(quantity);

        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testCheckDiscount_Organic_Quantity2() {
        Veggie organicVeggie = new Veggie("OrganicVeggie", 150, 20, true);
        int quantity = 2;

        int expectedDiscount = 0;
        int actualDiscount = organicVeggie.checkDiscount(quantity);

        assertEquals(expectedDiscount, actualDiscount);
    }
}
