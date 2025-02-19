package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(stringCompression("aabaaac"));
    }

    public static String stringCompression(String stringToCompress) {
        // If string is empty returning empty string.
        int stringLength = stringToCompress.length();
        if (stringLength == 0) {
            return "";
        }
        // If string contains only one character no need to run cycle or create variables, just returning result.
        if (stringLength == 1) {
            return stringToCompress.concat("1");
        }

        int count = 1;   // Variable for counting repeating characters.
        String result = "";
        for (int i = 0; i < stringLength - 1; i++) {
            if (stringToCompress.charAt(i) == stringToCompress.charAt(i + 1)) {
                // If next character repeats, increasing count.
                count++;
            } else {
                // If next character differ, updating result and counting for next character begins.
                result = result.concat(stringToCompress.charAt(i) + String.valueOf(count));
                count = 1;
            }

            if (stringLength == (i + 2)) {
                // If it's last iteration updating result.
                result = result.concat(stringToCompress.charAt(i + 1) + String.valueOf(count));
            }
        }
        return result;
    }
}