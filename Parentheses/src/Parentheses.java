
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class Parentheses {
    public String data;

    public Parentheses(String data) {
        this.data = "";
        for (int i = 0; i < data.length(); i++) 
            if (isParenthese(data.charAt(i))) this.data += data.charAt(i);
    }
    
    private boolean isParenthese(char c) {
        return c=='('||c=='['||c == '{'||c==')'||c==']'||c == '}';
    }
    
    private boolean isOpen(char c) {
        return c=='('||c=='['||c == '{';
    }
    
    private boolean match(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '[' && close == ']') return true;
        if (open == '{' && close == '}') return true;
        return false;
    }
    
    public boolean isCorrect() {
        Stack<Character> s = new Stack<>();
        try {
            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                if (isOpen(c)) s.push(c);
                else if (!match(s.pop(), c)) return false;
            }
        } catch (Exception e) {
            return false;
        }
        return s.isEmpty();
    }
}
