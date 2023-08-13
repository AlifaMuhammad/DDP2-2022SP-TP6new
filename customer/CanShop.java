import product.Product;

public interface CanShop {
    void addToCard(Product product, int quantity);
    void checkout();
}
