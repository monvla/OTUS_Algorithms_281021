public class RLE {

        public static void run(String inputString) {
            String outputString = "";

            int count;
            for (int i = 0; i < inputString.length(); i++) {

                count = 1;
                while (i < inputString.length() - 1 && inputString.charAt(i) == inputString.charAt(i + 1)) {
                    count++;
                    i++;
                }
                outputString = outputString + inputString.charAt(i) + count;
            }
            System.out.println("Input data string : " + inputString);
            System.out.println("Output data string after applying data compression technique : " + outputString);
        }

}
