public class ItemOrder {
    
    private int qty;
    private Item item;
    
    public ItemOrder(Item item, int qty) {
        this.item = item;
        this.qty = qty;
    }
    
    public double getPrice() {
        return item.priceFor(qty);
    }
    
    public Item getItem() {
        return item;
    }
    
    @Override
    public boolean equals(Object obj) {
        ItemOrder other = (ItemOrder) obj;
        return item.equals(other.getItem());
    }
    
    @Override
    public String toString() {
        return item.toString();
    }
    
}