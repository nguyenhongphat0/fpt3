/**
 *
 * @author Phat
 */
public class Node<T extends Comparable> {
    public T info;
    public Node next;

    public Node() {
    }

    public Node(T info) {
        this(info, null);
    }

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }
}
