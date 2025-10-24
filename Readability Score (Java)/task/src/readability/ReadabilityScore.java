package readability;

public class ReadabilityScore {
    public static double ari(int characterCount, int wordCount, int sentenceCount) {
        return 4.71 * (characterCount / (double) wordCount) + 0.5 * (wordCount / (double) sentenceCount) - 21.43;
    }

    public static double fleschKincaid(int wordCount, int syllableCount) {
        return 0.39 * (wordCount / (double) syllableCount) + 11.8 * (syllableCount / (double) wordCount) - 15.59;
    }

    public static double smod(int polysyllableCount, int sentenceCount) {
        return 1.043 * Math.sqrt(polysyllableCount * (30.0 / sentenceCount)) + 3.1291;
    }

    public static double colemanLiau(int characterCount, int wordCount, int sentenceCount) {
        return 0.0588 * ((double) characterCount / wordCount) - 0.296 * ((double) sentenceCount / wordCount) - 15.8;
    }

    public static int getAgeLevel(double score) {
        int roundedScore = (int) Math.ceil(score);
        if (roundedScore >= 14)
            return 22;
        return roundedScore + 5;
    }
}
