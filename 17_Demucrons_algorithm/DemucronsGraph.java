import java.util.ArrayList;
import java.util.Arrays;

public class DemucronsGraph {
    ArrayList<Node> nodes;
    int[][] linkMatrix;
    int[][] levels;

    DemucronsGraph(ArrayList<Node> nodes) {
        this.nodes = nodes;
        buildMatrix();
    }

    public void buildMatrix() {
        linkMatrix = new int[nodes.size() + 1][nodes.size() + 1];
        for (Node node : nodes) {
            for (Node outputNode : node.outputs) {
                linkMatrix[node.key][outputNode.key] = 1;
            }
        }
    }

    public int[][] getLevels() {
        int[] vector = getVector();
        levels = new int[vector.length][vector.length];
        int currentLevel = 0;
        while (Arrays.stream(vector).sum() > 0) {
            int nodeIndex = 0;
            for (int i = 1; i < vector.length; i++) {
                if (vector[i] == 0) {
                    if (currentLevel > 0 && Utils.hasValue(levels, currentLevel, i)) {
                        // Skip already added nodes
                        continue;
                    }
                    levels[currentLevel][nodeIndex] = i;
                    nodeIndex++;
                }
            }
            // Subtract nodes row from vector
            for (int j = 0; j < levels[currentLevel].length && levels[currentLevel][0] != 0; j++) {
                int rowNumber = levels[currentLevel][j];
                for (int i = 1; i < vector.length; i++) {
                    vector[i] -= linkMatrix[rowNumber][i];
                }
            }

            currentLevel++;
        }
        // Return clean array without zero elements
        int[][] resultArray = new int[currentLevel][];
        for (int i = 0; i < resultArray.length; i++) {
            int colsLength = 0;
            for (int pos = 0; levels[i][pos] != 0; pos++) {
                colsLength++;
            }
            resultArray[i] = new int[colsLength];
            for (int j = 0; levels[i][j] != 0; j++) {
                resultArray[i][j] = levels[i][j];
            }
        }
        return resultArray;
    }

    private int[] getVector() {
        int[] vector = new int[linkMatrix.length];
        Arrays.fill(vector, 0);

        for (int[] row: linkMatrix) {
            for (int col = 1; col < row.length; col++) {
                int value = row[col];
                if (value > 0) {
                    vector[col] += 1;
                }
            }
        }
        return vector;
    }


}
