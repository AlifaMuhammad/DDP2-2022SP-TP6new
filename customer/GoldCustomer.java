import java.time.LocalDate;

import product.Product;

public class GoldCustomer extends Customer{
    private static final double DISCOUNT_RATE = 0.85;

    //TODO: lengkapi kelas berikut
    public GoldCustomer(String name){
        super(name);
    } 
    
    @Override
    public void checkout() {
        double totalDiscountedPrice = cart.getTotalPrice() * DISCOUNT_RATE;
        Order newOrder = new Order(cart, DISCOUNT_RATE, LocalDate.now(), totalDiscountedPrice);
        orderHistory.add(newOrder);
    }
}  
