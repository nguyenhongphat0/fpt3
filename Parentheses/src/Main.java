import java.util.Scanner;

/**
 *
 * @author Phat
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Input: ");
            Parentheses p = new Parentheses(sc.nextLine());
            if (p.isCorrect()) System.out.println("CORRECT!");
            else System.out.println("INCORRECT!");
        } catch (Exception e) {
            System.out.println("NOT VALID");
        }
        System.out.println();
        main(null);
    }
}