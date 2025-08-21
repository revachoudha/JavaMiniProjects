public class Item {
        
        private String name;
        private double price;
        private int bulkQty;
        private double bulkPrice;
        
        public Item(String name, double price) {
            this(name, price, 0, 0.0);
        }
        
        public Item(String name, double price, int bulkQty, double bulkPrice) {
            this.name = name;
            this.price = price;
            this.bulkQty = bulkQty;
            this.bulkPrice = bulkPrice;
        }
        
        public double priceFor(int quantity) {
            return quantity * price;
        }
        
        @Override
        public boolean equals(Object obj) {
            Item other = (Item) obj;
            return name.equals(other.getName());
        }
        
        public String getName() {
            return name;
        }
        
        
        @Override
        public String toString() {
            String ans =  name + ", $" + price;
            if (bulkPrice > 0) {
                ans += " (" + bulkQty + " for " + bulkPrice + ")";
            }
            return ans;
        }
}