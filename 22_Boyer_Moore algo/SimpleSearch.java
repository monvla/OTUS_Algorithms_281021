import java.util.Arrays;

public class SimpleSearch {
    public static int getSubstringPos(String substring, String text) {
        int t = 0;
        while (t <= text.length() - substring.length()) {
            int p = 0;
            while (p < substring.length() && text.charAt(t+p) == substring.charAt(p)) {
                p++;
            }
            if (p == substring.length()) {
                return t;
            }
            t++;
        }
        return -1;
    }

    public static int getSubstringPosShifted(String substring, String text) {
        int[] shift = createShift(substring);
        int t = 0;
        while (t <= text.length() - substring.length()) {
            int p = substring.length() - 1;
            while (p >= 0 && text.charAt(t+p) == substring.charAt(p)) {
                p--;
            }
            if (p < 0) {
                return t;
            }
            t += shift[text.charAt(t + substring.length() - 1)];
        }
        return -1;
    }

    private static int[] createShift(String substring) {
        int[] shift = new int[128];
        Arrays.fill(shift, substring.length());
        for (int p = 0; p < substring.length() - 1; p++) {
            shift[substring.charAt(p)] = substring.length() - p - 1;
        }
        return shift;
    }
}
