package  com.practice.java8_17.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20 {

    public static void main(String[] args) {
        LC20 lc20 = new LC20();
        String str = "(){}";
        System.out.println(lc20.isValid(str));
    }
    public boolean isValid(String s) {
        if(s == null || s.length() <= 1) return false;
        boolean isValid = true;
        Deque<Character> characters = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                characters.push(ch);
            }
            else if(characters.size() > 0 && (ch == ')' || ch == '}' || ch == ']')) {
                char c = characters.pop();
                boolean localValidation = valid(c, ch);
                if(!localValidation) return false;
            } else {
                isValid = false;
            }
        }
        return characters.size() == 0 ? isValid : false;
    }
    public boolean valid(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }
}
