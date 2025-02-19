package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("aaaaaaaaaaabaaaccccccccccccccc  - input");
        System.out.println(stringCompression("aaaaaaaaaaabaaaccccccccccccccc"));
        System.out.println(stringDecompression("a11b1a3c15"));
    }

    private static String stringCompression(String stringToCompress) {
//         Also I could use StringBuilder and code would have better readability. But I think this solution works faster.
//         Both ways are Ok I think.
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

    private static String stringDecompression(String stringToDecompress) {
        // If string is empty returning empty string.
        int stringLength = stringToDecompress.length();
        if (stringLength == 0) {
            return "";
        }
        // Using string builder for better readability, making substrings for numbers is bad idea in this case.
        StringBuilder tempNumber = new StringBuilder();
        String tempChar = "";
        String result = "";
        for (int i = 0; i < stringLength - 1; ) {
            tempChar = String.valueOf(stringToDecompress.charAt(i));
            i++;
            // Building new number for current character.
            tempNumber.delete(0, tempNumber.length());
            // Running while cycle until string end or finding next character.
            while (i < stringLength && Character.isDigit(stringToDecompress.charAt(i))) {
                tempNumber.append(stringToDecompress.charAt(i));
                i++;
            }
            // Updating result.
            result = result.concat(tempChar.repeat(Integer.parseInt(tempNumber.toString())));
        }
        return result;
    }
}