package com.lab6.textprocessinganddatamanagementtoolteamproject.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexModule {

        public static void searchPattern(String patternStr, String text) {
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                if (matcher.groupCount() != 0) {System.out.println("Found match: " + matcher.group() + " at position " + matcher.start());}
                else {System.out.println("No match: " + matcher.group() + " at position " + matcher.start());}
            }
        }

        // Method to replace a pattern in text
        public static String replacePattern(String patternStr, String replacement, String text) {
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(text);
            return matcher.replaceAll(replacement);
        }
}
