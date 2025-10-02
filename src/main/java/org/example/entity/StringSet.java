package org.example.entity;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class StringSet {

    public static Set<String> findUniqueWords(String text) {
        // Noktalama işaretlerini temizle
        String cleanedText = text.replaceAll("[.,!?\"]", "").toLowerCase();

        // Kelimeleri ayır
        String[] words = cleanedText.split("\\s+");

        // TreeSet ile alfabetik ve eşsiz
        Set<String> uniqueWords = new TreeSet<>(Arrays.asList(words));
        return uniqueWords;
    }
}
