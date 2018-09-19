import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * The characters that are in the alphabet and all numbers
     */
    final static String OK_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabdefghijklmopqrstuvwxyz";

    public static void main(String[] unused) {
        System.out.println(totalWordCount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countForOneWord("http://erdani.com/tdpl/hamlet.txt", "prince"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * This method counts the total amount of words on the website.
     *
     * @param url   the website url that is being used
     * @return      returns the total amount of words
     */
    public static int totalWordCount(final String url) {
        String text = urlToString(url);
        String[] splitText = text.split("\\s+");
        return splitText.length;
    }

    /**
     * This method looks for the total amount of instances of a word
     *
     * @param url   the website url that is being used
     * @param word  the word that is being looked for in the website
     * @return      returns the total amount of instances of a word
     */
    public static int countForOneWord(final String url, final String word) {
        String text = urlToString(url);
        String[] splitText = text.split("\\s+");
        int counter = 0;
        for (String string : splitText) {
            if (string.toLowerCase().equals(word.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }
}
