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

    private final Deque<Character> deque = new ArrayDeque<>();

    public boolean isBalanced(String expression) {

        final char[] chars = expression.trim().toCharArray();
        boolean balanced = true;

        for (char bracket: chars) {
            if (isOpen(bracket)) {
                deque.addFirst(bracket);
            } else {
                if(!remove(bracket)) {
                    balanced = false;
                    break;
                }
            }
        }

        return balanced;
    }

    private boolean isOpen(char character) {
        boolean out = false;
        if (character == '(' ||
                character == '{' ||
                character == '[') {
            out = true;
        }

        return out;
    }

    private boolean remove(char bracket) {
        if (deque.size() > 0) {
            char open = getOpeningBracket(bracket);

            final char first = deque.removeFirst();

            return open == first;
        }

        return false;
    }

    private char getOpeningBracket(Character bracket) {

        char open;
        switch (bracket) {
            case ')': open = '(';
                    break;
            case ']': open = '[';
                    break;
            case '}': open = '{';
                    break;
            default: open = ' ';
        }

        return open;
    }

}
