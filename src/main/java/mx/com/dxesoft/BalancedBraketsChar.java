package mx.com.dxesoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem">Stacks: Balanced Brackets</a>
 *
 * a sequence of brackets is considered to be balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 */
public class BalancedBraketsChar {

//    private Deque<Character> deque = new ArrayDeque<>();

    public static boolean isBalanced(String expression) {
        Deque<Character> deque = new ArrayDeque<>();

        final char[] chars = expression.trim().toCharArray();

        boolean balanced = true;
        if (chars.length > 0 ) {

            for (char bracket : chars) {
                if (isOpen(bracket)) {
                    deque.addFirst(bracket);
                } else {
                    if (!remove(bracket, deque)) {
                        balanced = false;
                        break;
                    }
                }
            }
        } else {
            balanced = false;
        }

        //se debe verificar que no fueron solamente brackets que abren.
        return balanced && deque.size() == 0;
    }

    private static boolean isOpen(char character) {
        boolean out = false;
        if (character == '(' ||
                character == '{' ||
                character == '[') {
            out = true;
        }

        return out;
    }

    private static boolean remove(char bracket, Deque<Character> deque) {
        if (deque.size() > 0) {
            char open = getOpeningBracket(bracket);

            if (open != '@') {

                final char first = deque.removeFirst();

                return open == first;
            }

            return true;

        }

        return false;
    }

    private static char getOpeningBracket(Character bracket) {

        char open;
        switch (bracket) {
            case ')': open = '(';
                    break;
            case ']': open = '[';
                    break;
            case '}': open = '{';
                    break;
            default: open = '@';
        }

        return open;
    }

}
