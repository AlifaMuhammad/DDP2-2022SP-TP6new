import product.Product;

public class Fruit extends Product{
    private boolean isLocal;

    public Fruit(String name, int price, int stok, boolean isLocal){
        super(name, price, stok);
        this.isLocal = isLocal;
    }
    
    /**
     * method untuk menghitung diskon yang diperoleh
     */
    public int checkDiscount(int quantity){
        if(this.isLocal){
            if(quantity >= 5)
                return 30;
            else if(quantity >=3 )
                return 20;
        }
        else{
             if(quantity >= 5)
                return 20;
            else if(quantity >=3 )
                return 15;
        }
        return 0;
    }
}
