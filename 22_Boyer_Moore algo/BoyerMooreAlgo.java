import java.util.HashMap;

public class BoyerMooreAlgo {

    public static int getSubstringPos(String text, String substring) {
        if (substring.length() > text.length()) {
            return -1;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, substring.length());
        }
        for (int i = 0; i < substring.length() - 1; i++) {
            offsetTable.put(substring.charAt(i), substring.length() - i - 1);
        }
        int i = substring.length() - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= text.length() - 1) {
            j = substring.length() - 1;
            k = i;
            while (j >= 0 && text.charAt(k) == substring.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(text.charAt(i));
        }
        if (k >= text.length() - substring.length()) {
            return -1;
        } else {
            return k + 1;
        }
    }
}
