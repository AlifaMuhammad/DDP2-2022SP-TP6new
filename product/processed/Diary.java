package product.processed;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import product.Product;


public class Diary extends Product{
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    public LocalDate expiredDate;

    public Diary(String name, int price, int stock, String date) {
        super(name, price, stock);
        this.expiredDate = LocalDate.parse(date, formatter);
    }

    @Override
    public int checkDiscount(int quantity) {
        long differentDate = ChronoUnit.DAYS.between(LocalDate.now(),this.expiredDate);
        if (differentDate < 30){
            return 20;
        } else{
            return 0;
        }
    }
    
}
