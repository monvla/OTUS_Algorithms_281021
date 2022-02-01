public class Main {
    public static void main(String[] args) {
        String text = "ABCDA#CDEABCDEFABCDEFG";
        int result = SimpleSearch.getSubstringPos("ABCDEF", text);
        System.out.println(result);

        int result2 = SimpleSearch.getSubstringPosShifted("ABCDEF", text);
        System.out.println(result2);

        int result3 = BoyerMooreAlgo.getSubstringPos("ABCDA#CDEABCDEFABCDEFG", "ABCDEF");
        System.out.println(result3);
    }
}
