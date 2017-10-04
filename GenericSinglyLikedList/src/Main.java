
import java.io.File;

/**
 *
 * @author Phat
 */
public class Main {
    public static void main(String[] args) {
        // test for number
        MySinglyLinkedList<Integer> list1 = new MySinglyLinkedList<>();
        Integer[] a = {2,7,3,-6,120,0,-11};
        list1.addMany(a);
        System.out.println("list1: " + list1.toString());
        list1.sort();
        System.out.print("After sorting: "); list1.printAll();
        System.out.println();
        
        // test for string
        MySinglyLinkedList<String> list2 = new MySinglyLinkedList<>();
        String[] ss = {"Hello", "Hi", "Goodbye", "Yes", "No", "Vietnamese"};
        list2.addMany(ss);
        System.out.println("list2: " + list2.toString());
        list2.sort();
        System.out.print("After sorting: "); list2.printAll();
        System.out.println();
        
        // test for object
        MySinglyLinkedList list3 = new MySinglyLinkedList();
        list3.addFirst(5);
        list3.addLast(4);
        list3.addFirst(new File("file.txt"));
        list3.addFirst("Hello");
        list3.addFirst(7);
        list3.addPos(4, "Hi");
        System.out.println("list3: " + list3.toString());
        System.out.println("Hello is at position " + list3.indexOf("Hello"));
        try {
            list3.sort();
            System.out.print("After sorting: ");
            list3.printAll();
        } catch (Exception e) {
            System.out.println("This list cannot be sorted because its elements cannot be compared to each other");
        }
    }
}
