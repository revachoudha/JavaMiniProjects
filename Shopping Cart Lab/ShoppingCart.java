import java.util.ArrayList;
public class ShoppingCart {
    
    private ArrayList<ItemOrder> orders = new ArrayList<>();
    
    public ShoppingCart() {
        orders = new ArrayList<>();
    }
    
    public void add(ItemOrder newOrder) {
        orders.remove(newOrder);
        orders.add(newOrder);
    }
    
    public double getTotal() {
        double sum = 0;
        for (ItemOrder order : orders) {
            sum += order.getPrice();
        }
        return sum;
    }
}