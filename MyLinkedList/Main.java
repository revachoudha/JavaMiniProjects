public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list); // [1, 2, 3]

        list.add(4, 1);
        System.out.println(list); // [1, 4, 2, 3]

        System.out.println(list.get(2)); // 2
        System.out.println(list.contains(3)); // true
        System.out.println(list.indexOf(4)); // 1

        list.set(99, 2);
        System.out.println(list); // [1, 4, 99, 3]

        System.out.println(list.remove(1)); // 4
        System.out.println(list); // [1, 99, 3]

        System.out.println("Size: " + list.size()); // 3
        System.out.println("Recursive size: " + list.sizeRecursive()); // 3
    }
}
