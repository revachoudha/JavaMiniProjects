public class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(int val) {
        head = new ListNode(val);
        tail = head;
        size = 1;
    }

    public void add(int newVal) {
        ListNode newNode = new ListNode(newVal);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int newVal, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            ListNode newNode = new ListNode(newVal);
            newNode.next = head;
            head = newNode;
            if (size == 0) tail = head;
        } else if (index == size) {
            add(newVal);
            return;
        } else {
            ListNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ListNode newNode = new ListNode(newVal);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int removedVal;

        if (index == 0) {
            removedVal = head.val;
            head = head.next;
            if (size == 1) tail = null;
        } else {
            ListNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            removedVal = temp.next.val;
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
        }
        size--;
        return removedVal;
    }

    public boolean contains(int target) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == target) return true;
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(int target) {
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.val == target) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void set(int newVal, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.val = newVal;
    }

    public int size() {
        return size;
    }
    
    public int sizeRecursive() {
        return sizeRecursive(head);
    }

    private int sizeRecursive(ListNode node) {
        if (node == null) return 0;
        return 1 + sizeRecursive(node.next);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}