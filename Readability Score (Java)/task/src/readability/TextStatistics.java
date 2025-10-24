package readability;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TextStatistics {
    private static Set<Character> VOWELS = new HashSet<>(Arrays.asList('E', 'I', 'O', 'U', 'A', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'));

    public static int wordCount(String text) {
        return text.split("\\s+").length;
    }

    public static int sentenceCount(String text) {
        return text.split("[.?!]").length;
    }

    public static int charactersCount(String text) {
        return (int) text.chars().filter(it -> !Character.isWhitespace(it)).count();
    }

    public static int syllablesCount(String text) {
        String[] words = text.split("\\s+");
        return Arrays.stream(words).mapToInt(TextStatistics::countSyllablesInWord).sum();
    }

    public static int polysyllablesCount(String text) {
        String[] words = text.split("\\s+");
        return (int) Arrays.stream(words).filter(word -> countSyllablesInWord(word) > 2).count();
    }

    private static int countSyllablesInWord(String word) {
        String filteredWord = word.replaceAll("\\W", "");
        if (filteredWord.isEmpty())
            return 0;
        int count = 0;
        boolean isLastCharacterVowel = false;
        for (char c : filteredWord.toCharArray()) {
            if (VOWELS.contains(c)) {
                if (!isLastCharacterVowel) {
                    count++;
                    isLastCharacterVowel = true;
                }
            } else {
                isLastCharacterVowel = false;
            }
        }
        if (filteredWord.charAt(filteredWord.length() - 1) == 'e')
            count--;
        return Math.max(1, count);
    }
}
