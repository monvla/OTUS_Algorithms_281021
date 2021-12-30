public class Utils {

    public static boolean hasValue(int[][] arr, int currentLevel, int value) {
        for (int i = currentLevel; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
