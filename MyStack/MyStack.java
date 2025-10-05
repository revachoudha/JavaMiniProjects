import java.util.Arrays;

public class MyStack {
    private Integer[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 7;
    
    public MyStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public MyStack(int initCap) {
        this.stack = new Integer[initCap];
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size ==0;
    }
    
    public Integer peek() {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot peek from an empty stack.");
        }
        return stack[size-1];
    }
    
    public Integer pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot pop from an empty stack.");
        }
        Integer poppedItem = stack[--size];
        stack[size] = null;
        return poppedItem;
    }
    
    public void push(Integer item) {
        if (size == stack.length) {
            doubleCapacity();
        }
        stack[size++] = item;
    }
    
    public void doubleCapacity() {
        stack = Arrays.copyOf(stack, stack.length*2);
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            if (i == size - 1) {
                sb.append(stack[i]).append("\t<----- TOP\n");
            } else {
                sb.append(stack[i]).append("\n");
            }
        }
        sb.append("¯¯¯¯¯¯¯");
        return sb.toString();
    }
}