import java.util.ArrayList;

public class Cart {
    //TODO: Lengkapi kelas berikut
    private ArrayList<OrderItem> orderList;

    public Cart() {
        this.orderList = new ArrayList<>();
    }

    public double getTotalPrice(){
        int totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getFinalPrice();
        }
        return totalPrice;
    }

    public void addOrderItem(OrderItem orderItem){
        orderList.add(orderItem);
    }

    public ArrayList<OrderItem> getOrderList() {
        return orderList;
    }
}
