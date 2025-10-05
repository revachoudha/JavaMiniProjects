import java.util.Arrays;

public class MyStack implements StackADT{
    private Square[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 7;
    
    public MyStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public MyStack(int initCap) {
        this.stack = new Square[initCap];
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size ==0;
    }
    
    public Square peek() {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot peek from an empty stack.");
        }
        return stack[size-1];
    }
    
    public Square pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot pop from an empty stack.");
        }
        Square poppedItem = stack[--size];
        stack[size] = null;
        return poppedItem;
    }
    
    public void push(Square item) {
        if (size == stack.length) {
            doubleCapacity();
        }
        stack[size++] = item;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(stack, 0, size, null);
        size = 0;
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