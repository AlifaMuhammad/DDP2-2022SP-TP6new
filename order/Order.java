import java.time.LocalDate;

public class Order {
    //TODO: Lengkapi kelas berikut
    private Cart cart;
    private double discountRate;
    private LocalDate orderDate;
    private double totalPrice;

    Order(Cart cart, double discountRate, LocalDate orderDate, double totalPrice){
        this.cart = cart;
        this.discountRate = discountRate;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }


    /**
     * method unutk menentukan harga final
     * @return
     */
    public double getFinalPrice(){
        return totalPrice * (100 - discountRate) / 100;
    }

    public void decreaseStockAllItem(){

    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
