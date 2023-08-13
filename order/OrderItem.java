import product.Product;

public class OrderItem {
    private Product product;

    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity  = quantity;

    };

    public double getFinalPrice() {
        double discount = this.product.checkDiscount(this.quantity);
        double price = (double) this.product.getPrice() * this.quantity;

        return (price*(100-discount)/100);
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String toString(){
        return String.format("%s  %d kg  %f", this.product.getName(), this.quantity, this.getFinalPrice());  
    }
}
