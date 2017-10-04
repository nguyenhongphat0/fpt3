/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        System.out.println("AVL TREE");
        System.out.println("========");
        AVLTree<Integer> avl = new AVLTree<>();
        avl.add(2);
        avl.add(8);
        avl.add(new Integer[] {3,4,5,6});
        avl.add(7);
        avl.add(1);
        avl.add(9);
        avl.add(10);
        avl.preorder(avl.root);
        System.out.println("(prefix)");
        avl.inorder(avl.root);
        System.out.println("(infix)");
        avl.postorder(avl.root);
        System.out.println("(postfix)");
        avl.bfs(avl.root);
        System.out.println("(floor by floor)");
        System.out.println("Height of the tree: " + avl.getHeight(avl.root));
        System.out.println();
        
        System.out.println("NORMAL TREE");
        System.out.println("===========");
        MyTree<Integer> t = new MyTree<>();
        t.add(2);
        t.add(8);
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        t.add(7);
        t.add(1);
        t.add(9);
        t.add(10);
        t.preorder(t.root);
        System.out.println("(prefix)");
        t.inorder(t.root);
        System.out.println("(infix)");
        t.postorder(t.root);
        System.out.println("(postfix)");
        t.bfs(t.root);
        System.out.println("(floor by floor)");
        System.out.println("Height of the tree: " + t.getHeight(t.root));
        System.out.println();
        
        System.out.println("After balaced this tree by simple method (get array then sort then add again from middle)");
        t.toBalancedTree(); // (using simple method)
        t.preorder(t.root);
        System.out.println("(prefix)");
        t.inorder(t.root);
        System.out.println("(infix)");
        t.postorder(t.root);
        System.out.println("(postfix)");
        t.bfs(t.root);
        System.out.println("(floor by floor)");
        System.out.println("Height of the tree: " + t.getHeight(t.root));
    
    }
}
