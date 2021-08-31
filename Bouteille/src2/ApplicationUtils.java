package fr.romain.utils;

public class ApplicationUtils {

    public static String pluralize(int count, String singular, String plural) {
        String correctStringVersion = count < 2 ? singular : plural;
        return String.format("%d %s", count, correctStringVersion);
    }

    public static String pluralize(int count, String singular) {
        String plural = singular + "s";
        switch (count) {
            // Manière d'écrire un éventail de cases
            case 0: case 1:
                return String.format("%d %s", count, singular);
            default:
                return String.format("%d %s", count, plural);
        }
    }
}
