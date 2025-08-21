import java.util.ArrayList;
public class Catalog {
    
    private String name;
    private ArrayList<Item> catalog;
    
    public Catalog(String name) {
        this.name = name;
        this.catalog = new ArrayList<>();
    }
    
    public void add(Item item) {
        catalog.add(item);
    }
    
    public int size() {
        return catalog.size();
    }
    
    public Item get(int index) {
        return catalog.get(index);
    }
    
    public String getName() {
        return name;
    }
}