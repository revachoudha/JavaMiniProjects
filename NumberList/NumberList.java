import java.util.ArrayList;//remove this later

public class NumberList {
    private ArrayList<Integer> arr;//remove this later
    private Integer[] list;
    private int size;
    
    public NumberList() {
        this.arr = new ArrayList<>(2);//remove this later
        this.list = new Integer[2];
        this.size = 0;
    }
    
    public int size() {
        return size;
        //return arr.size();
    }
    
    public boolean isEmpty() {
        return (size==0);
        //return arr.isEmpty();
    }
    
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        
        else {
            String statement = "[";
            for (int i = 0; i < size; i++) {
                statement += list[i];
                if (i < size -1) {
                    statement += ", ";
                }
            }
            statement += "]";
            //return arr.toString();
            return statement;
        }
    }
    
    public void add(int index, Integer val) {
        
        if (index < 0 || index>size) {
            throw new IndexOutOfBoundsException();
            
        }
        if (size == list.length) {
            doubleCapacity();
        }
        
        for(int i = size; i > index; i--) {
            list[i] = list[i-1];
        }
        
        list[index] = val;
        size++;
        
        
        //arr.add(index, val);
    }
    
    public boolean add(Integer element) {
        //return arr.add(element);
        add(size, element);
        return true;
    }
    
    public Integer get(int index) {
        //return arr.get(index);
        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }
    
    public Integer set(int index, Integer val) {
        //return arr.set(index, val);
        if (index < 0 || index>size) {
            throw new IndexOutOfBoundsException();
            
        }
        
        Integer s = remove(index);
        add(index, val);
        return s;
    }
    
    public Integer remove(int index) {
        //return arr.remove(index);
        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException();
        }
        
        Integer r = list[index];
        for (int i = index; i < size-1; i++) {
             list[i] = list[i+1];
        }
        
        list[size-1] = null;
        size--;
        return r;
        
    }
    
    private void doubleCapacity() {
        Integer[] newList = new Integer[2*list.length];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
}