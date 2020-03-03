package cz.zdenekvlk.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacterFunctionalStyle("ahojnask"));
    }

    private static String firstNonRepeatedCharacterFunctionalStyle(String str) {
        Map<Integer, Long> chs = str.codePoints()
                .boxed()
                .collect(
                    Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())
                );

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));
    }
}
