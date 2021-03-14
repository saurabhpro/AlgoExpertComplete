package interviewq.medium;

import java.util.StringJoiner;

public class Q_StringReverse {

    public static String reverseWordsInString(String string) {
        int idx = 0;
        int nextIdx = 0;
        int wordCount = 0;
        final String[] words = new String[string.length()];
        System.out.println(string);

        while (idx < string.length()) {
            nextIdx = string.indexOf(" ", idx);

            StringBuilder word;
            if (nextIdx != -1) {
                word = new StringBuilder(string.substring(idx, nextIdx));
                while (nextIdx < string.length() && string.charAt(nextIdx) == ' ') {
                    word.insert(0, ' ');
                    nextIdx++;
                }
                idx = nextIdx;
            } else {
                word = new StringBuilder(string.substring(idx));
                idx = string.length();
            }

            words[wordCount++] = word.toString();

        }

        final StringJoiner sb = new StringJoiner("");
        for (int i = wordCount - 1; i >= 0; i--) {
            sb.add(words[i]);
        }

        String.join("", words);


        return sb.toString();
    }
}
