// WordCounter.java
package com.example.myapplication;

public class WordCounter {
    public static int countWords(String text) {
        // Split the text into words using spaces, commas, and periods as separators
        String[] words = text.split("[\\s,\\.]");
        return words.length;
    }

    public static int countCharacters(String text) {
        // Count the total number of characters in the text
        return text.length();
    }
}
