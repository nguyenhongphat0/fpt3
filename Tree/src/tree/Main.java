/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Phat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyTree<Integer> t = new MyTree<>();
        t.add(4);
        t.add(6);
        t.add(2);
        t.add(1);
        t.add(3);
        t.add(5);
        t.add(0);
        t.add(7);
        t.preorder(t.root);
        System.out.println("(prefix)");
        t.inorder(t.root);
        System.out.println("(infix)");
        t.postorder(t.root);
        System.out.println("(postfix)");
        t.bfs(t.root);
        System.out.println("(floor by floor)");
        System.out.println("Height of the tree: " + t.height());
        System.out.println("Number of leaves: " + t.countLeaf());
        System.out.println("Number of nodes: " + t.countNode());
        System.out.println("Nodes with 1 child: " + t.count1Node());
        System.out.println("Nodes with 2 childs: " + t.count2Node());
        
        System.out.println("Deleted 3 by copy method and 4 by merge method: ");
        t.deleteByCopy(3);
        t.deleteByMerge(4);
        t.bfs(t.root);
        System.out.println("(floor by floor)");
    }
}
