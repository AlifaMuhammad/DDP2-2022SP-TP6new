import java.time.LocalDate;
import java.util.ArrayList;

import product.Product;

public class Customer {
    protected String name;
    protected Cart cart;
    protected ArrayList<Order> orderHistory;
    //TODO: lengkapi kelas berikut
    public Customer(String name){
        this.name = name;
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method unutk menambahkan produk kedalam keranjang
     * @param product
     * @param quantity
     */
    public void addToCard(Product product, int quantity){
        if (product.getStock() >= quantity) {
            OrderItem orderItem = new OrderItem(product, quantity);
            cart.addOrderItem(orderItem);
            System.out.println("Berhasil menambahkan " + product.getName() + " ke keranjang");
        } else {
            System.out.println("Stok produk tidak mencukupi");
        }
    }

    /**
     * method untuk menampilkan data saat checkout
     */
    public void checkout(){
        if (!cart.getOrderList().isEmpty()) {
        double totalPrice = cart.getTotalPrice();
        LocalDate currentDate = LocalDate.now();
        Order order = new Order(cart, 0, currentDate, totalPrice);
        orderHistory.add(order);
        System.out.println("Berhasil Checkout");
    } else {
        System.out.println("Keranjang Anda Kosong");
    }
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
