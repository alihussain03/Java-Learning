package chapter6_Stack_Queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Six_4_Stack_CheckExpression {

    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')', '(');
        matchingParenMap.put(']', '[');
        matchingParenMap.put('}', '{');
        openingParenSet.addAll(matchingParenMap.values());
    }

    public static void main(String[] args) {
        System.out.println(isDelimiterMatched("a(b[c]d)e"));
        System.out.println(String.format(
                "Has matching parens using first function %s? : %s", "{{{{}}", isDelimiterMatched("{{{{}}")));

        System.out.println(String.format(
                "Has matching parens %s? : %s", "(abcd)", hasMatchingParens("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}", hasMatchingParens("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}})", hasMatchingParens("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}}()", hasMatchingParens("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}]()", hasMatchingParens("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
                hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));
    }

    public static boolean isDelimiterMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        Six_2_Stack_Using_LinkedList<Character> stack = new Six_2_Stack_Using_LinkedList<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1)
                stack.push(c);
            else if (closing.indexOf(c) != -1) {
                if (stack.isEmpty()) // nothing to match with
                    return false;
                if (closing.indexOf(c) != opening.indexOf(stack.pop()))
                    return false; // mismatched delimiter
            }
        }
        return stack.isEmpty(); // were all opening delimiters matched?
    }

    public static boolean isHTMLMatched(String html) {
        Six_2_Stack_Using_LinkedList<String> buffer = new Six_2_Stack_Using_LinkedList<>();
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j != -1) {
            int k = html.indexOf('>', j + 1); // find next ’>’ character
            if (k == -1)
                return false; // invalid tag
            String tag = html.substring(j + 1, k); // strip away < >
            if (!tag.startsWith("/")) // this is an opening tag
                buffer.push(tag);
            else { // this is a closing tag
                if (buffer.isEmpty())
                    return false; // no tag to match
                if (!tag.substring(1).equals(buffer.pop()))
                    return false; // mismatched tag
            }
            j = html.indexOf('<', k + 1); // find next ’<’ character (if any)
        }
        return buffer.isEmpty(); // were all opening tags matched?
    }


    public static boolean hasMatchingParens(String input) {

        Six_2_Stack_Using_LinkedList<Character> parenStack = new Six_2_Stack_Using_LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // Add to the stack for an opening paren.
            if (openingParenSet.contains(ch)) {
                parenStack.push(ch);
            }
            if (matchingParenMap.containsKey(ch)) {
                Character lastParen = parenStack.pop();
                if (lastParen != matchingParenMap.get(ch)) {
                    return false;
                }
            }
        }

        return parenStack.isEmpty();

    }
}
