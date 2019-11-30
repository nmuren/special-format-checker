package special_format_checker;

import java.util.ArrayList;

final class Stack {

    private ArrayList<Character> charList;
    private boolean correct;

    Stack(String s) {
        charList = new ArrayList<>();
        correct = true;
        Character c, popped;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            switch (c) {
                case '[':
                case '{':
                case '(':
                    push(c);
                    break;

                case ')':
                    popped = pop();
                    if (!popped.equals('(')) {
                        correct = false;
                    }
                    break;
                case '}':
                    popped = pop();
                    if (!popped.equals('{')) {
                        correct = false;
                    }
                    break;
                case ']':
                    popped = pop();
                    if (!popped.equals('[')) {
                        correct = false;
                    }
                    break;
            }
        }
    }

    private void push(char c) {
        charList.add(c);
    }

    private char pop() {
        return charList.remove(0);
    }

    boolean isCorrect() {
        return correct;
    }

}

public class Special_Format_Checker {

    public static void main(String[] args) {
        //String s = "{[[(()()()[])]][]}";
        String s = "{}";
        Stack stack = new Stack(s);
        System.out.println(stack.isCorrect());
    }

}
