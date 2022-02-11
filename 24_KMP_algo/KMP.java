class KMP {
    void run(String pattern, String text)
    {
        int patternLength = pattern.length();
        int textLength = text.length();

        int longestPrefixSuffix[] = new int[patternLength];
        int patternIndex = 0;

        computeLPSArray(pattern, patternLength, longestPrefixSuffix);

        int textIndex = 0;
        while (textIndex < textLength) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == patternLength) {
                System.out.println("Found pattern "
                        + "at index " + (textIndex - patternIndex));
                patternIndex = longestPrefixSuffix[patternIndex - 1];
            } else if (textIndex < textLength && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0) {
                    patternIndex = longestPrefixSuffix[patternIndex - 1];
                } else {
                    textIndex = textIndex + 1;
                }
            }
        }
    }

    void computeLPSArray(String pattern, int patternLength, int longestPrefixSuffix[])
    {
        int previousLPSLen = 0;
        longestPrefixSuffix[0] = 0;

        int i = 1;
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(previousLPSLen)) {
                previousLPSLen++;
                longestPrefixSuffix[i] = previousLPSLen;
                i++;
            } else {
                if (previousLPSLen != 0) {
                    previousLPSLen = longestPrefixSuffix[previousLPSLen - 1];
                } else {
                    longestPrefixSuffix[i] = previousLPSLen;
                    i++;
                }
            }
        }
    }
}
