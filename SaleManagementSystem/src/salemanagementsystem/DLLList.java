/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

/**
 *
 * @author DuongPTH
 * @param <E>
 */
public class DLLList<E extends Comparable> {

    protected DLLNode<E> head, tail;

    public DLLList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean addFirst(E val) {
        DLLNode node = new DLLNode(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return true;
    }

    public void addLast(E val) {
        DLLNode node = new DLLNode(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void traveseToLast() {
        for (DLLNode i = head; i != null; i = i.next) {
            System.out.print(i.info);
        }
    }

    public void traveseToFirst() {
        for (DLLNode i = tail; i != null; i = i.prev) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    public boolean addAfterPos(E val, int pos) {
        if (isEmpty() && pos != 0) {
            return false;
        } else {
            try {
                int num = 0;
                for (DLLNode runNode = head; runNode != null; runNode = runNode.next) {
                    if (num == pos) {
                        if (runNode.next == null) {
                            addLast(val);
                        } else {
                            DLLNode addNode = new DLLNode(val);

                            addNode.next = runNode.next;
                            addNode.prev = runNode;
                            runNode.next = addNode;
                            addNode.next.prev = addNode;
                        }
                        return true;
                    }
                    num++;
                }
            } catch (Exception e) {
                System.out.println("Adding failed");
            }
            return false;
        }
    }

    public boolean addMany(E[] a) {
        for (int i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
        return true;
    }

    public int size() {
        int count = 0;
        for (DLLNode node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    public E valueAt(int pos) throws Exception {
        int num = 0;
        if (isEmpty()) {
            throw new Exception("Empty list");
        } else {
            for (DLLNode node = head; node.next != null; node = node.next) {
                if (num++ == pos) {
                    return (E) node.info;
                }
            }
            throw new Exception("Pos invalid");
        }
    }

    public int indexOf(E val) throws Exception {
        int num = 0;
        if (isEmpty()) {
            throw new Exception("Empty list");
        } else {
            for (DLLNode node = head; node.next != null; node = node.next) {
                if (node.info == val) {
                    return num;
                }
                num++;
            }
            throw new Exception("Value invalid");
        }
    }

    public void ascSort() {
        for (DLLNode iNode = head; iNode.next != null; iNode = iNode.next) {
            for (DLLNode jNode = iNode.next; jNode != null; jNode = jNode.next) {
                if (iNode.info.compareTo(jNode.info) > 0) {
                    Product tmp = (Product) iNode.info;
                    iNode.info = jNode.info;
                    jNode.info = tmp;
                }
            }
        }
    }

    public DLLNode delete(E info) throws Exception {
        int num = 0;
        if (isEmpty()) {
            throw new Exception("Empty list");
        } else {
            for (DLLNode node = head; node.next != null; node = node.next) {
                if (node.info.compareTo(info) == 0) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node.prev = null;
                    node.next = null;
                    return node;
                }
                num++;
            }
            throw new Exception("Info invalid");
        }
    }
}
