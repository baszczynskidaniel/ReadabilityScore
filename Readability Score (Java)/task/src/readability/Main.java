package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(args[0])));
            analyzeText(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Missing file path");
        }
    }

    private static void analyzeText(String text) {

        int wordCount = TextStatistics.wordCount(text);
        int sentenceCount = TextStatistics.sentenceCount(text);
        int characterCount = TextStatistics.charactersCount(text);
        int syllableCount = TextStatistics.syllablesCount(text);
        int polysyllableCount = TextStatistics.polysyllablesCount(text);

        double ari = ReadabilityScore.ari(characterCount, wordCount, sentenceCount);
        double fk = ReadabilityScore.fleschKincaid(wordCount, syllableCount);
        double smod = ReadabilityScore.smod(polysyllableCount, sentenceCount);
        double cl = ReadabilityScore.colemanLiau(characterCount, wordCount, sentenceCount);

        System.out.printf("Words: %d\n", wordCount);
        System.out.printf("Sentences: %d\n", sentenceCount);
        System.out.printf("Characters: %d\n", characterCount);
        System.out.printf("Syllables: %d\n", syllableCount);
        System.out.printf("Polysyllables: %d\n", polysyllableCount);

        System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).\n", ari, ReadabilityScore.getAgeLevel(ari));
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", fk, ReadabilityScore.getAgeLevel(fk));
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n", smod, ReadabilityScore.getAgeLevel(smod));
        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).\n", cl, ReadabilityScore.getAgeLevel(cl));

    }
}
