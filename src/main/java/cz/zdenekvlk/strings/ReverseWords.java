package cz.zdenekvlk.strings;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseWords {
    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public static void main(String[] args) {
        System.out.println(reverseWords("ahoj jak se máš? Já dobře :)."));
        System.out.println(functionalReverseWords("ahoj jak se máš? Já dobře :)."));
        System.out.println(reverseCharsAndWordsItself("ahoj jak se máš? Já dobře :)."));
    }

    private static String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    private static String functionalReverseWords(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }

    private static String reverseCharsAndWordsItself(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
