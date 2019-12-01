package special_format_checker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

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
            if (!isCorrect()) {
                break;
            }
        }
        if (!charList.isEmpty()) {
            correct = false;
        }
    }

    private void push(char c) {
        charList.add(c);
    }

    private char pop() {
        return charList.remove(charList.size() - 1);
    }

    boolean isCorrect() {
        return correct;
    }

}

final class StackWith_LL {

    private LinkedList stack;
    private Boolean correct;

    StackWith_LL(String s) {
        stack = new LinkedList<>();
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
            if (!isCorrect()) {
                break;
            }
        }
        if (!stack.isEmpty()) {
            correct = false;
        }
    }

    private void push(Character c) {
        stack.addLast(c);
    }

    private Character pop() {
        return (Character) stack.removeLast();
    }

    boolean isCorrect() {
        return correct;
    }

}

public class Special_Format_Checker {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String s = in.nextLine();*/
        String s = "{[[((7-9)*(4+5)(4^2)[])]][]}";
        //Stack stack;
        StackWith_LL stack;
        try {
            //stack = new Stack(s);
            stack = new StackWith_LL(s);
            if (stack.isCorrect()) {
                System.out.println("Your entry is a mirror, congratulations!");
            } else {
                System.out.println("Sorry, your entry is not a mirror string.");
            }
        } catch (Exception e) {
            System.out.println("Sorry, your entry is not a mirror string.");
        }

    }

}
