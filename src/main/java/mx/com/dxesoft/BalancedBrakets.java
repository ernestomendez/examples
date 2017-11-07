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
public class BalancedBrakets {

    private final Deque<String> deque = new ArrayDeque<>();

    public boolean isBalanced(String expression) {

        final String[] brackets = expression.split("");

        boolean balanced = true;

        for (String bracket : brackets) {
            if (isOpen(bracket)) {
                deque.addFirst(bracket);
            } else {
                if(!remove(bracket)) {
                    balanced = false;
                    break;
                }
            }
        }

        return balanced && deque.size() == 0;
    }

    private boolean isOpen(String character) {
        boolean out = false;
        if (character.equals( "(") ||
                character.equals( "{") ||
                character.equals( "[")) {
            out = true;
        }

        return out;
    }

    private boolean remove(String bracket) {
        if (deque.size() > 0) {
            String open = getOpeningBracket(bracket);

            if (!open.equals("@")) {

                final String first = deque.removeFirst();

              return open.equals(first);
            }

            return true;
        }

        return false;
    }

    private String getOpeningBracket(String bracket) {

        String open;
        switch (bracket) {
            case ")": open = "(";
                    break;
            case "]": open = "[";
                    break;
            case "}": open = "{";
                    break;
            default: open = "@";
        }

        return open;
    }

}
