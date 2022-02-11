public class Main {

    public static void main(String args[])
    {
        String txt = "ABC@ABABCABCABB";
        String pat = "ABC";
        new KMP().run(pat, txt);
    }
}
