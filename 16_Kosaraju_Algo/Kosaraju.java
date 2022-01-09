import java.util.ArrayList;
import java.util.Arrays;

public class Kosaraju {
    ArrayList<Node> nodes;
    int counter = 0;
    int[][] matrix = new int[10][10];
    int currentCol = 0;
    int currentRow = 0;

    Kosaraju(ArrayList<Node> nodes) {
        this.nodes = nodes;
        for (int[] col : matrix) {
            Arrays.fill(col, -1);
        }
    }

    public int[][] getStronglyConnectedNodes() {
        markNodes();
        invertNodes();
        findStronglyConnectedNodes();
        return getCleanArray();
    }

    private boolean dfsIsLastNode(Node node) {
        if (node.getCounter() != Node.UNASSIGNED) {
            return true;
        }
        counter++;
        node.setCounter(counter);
        for (Node nextNode : node.outputs) {
            if (!dfsIsLastNode(nextNode)) {
                counter++;
                node.setCounter(counter);
            }
        }
        return false;
    }

    private void markNodes() {
        dfsIsLastNode(nodes.get(0));
    }

    private void invertNodes() {
        for (Node node: nodes) {
            node.invert();
        }
    }

    private boolean hasUnprocessedNodes() {
        for (Node node: nodes) {
            if (!node.isProcessed()) {
                return true;
            }
        }
        return false;
    }

    private Node getUnprocessedLinkedNode(Node node) {
        for (Node outputNode: node.outputs) {
            if (!outputNode.isProcessed()) {
                return outputNode;
            }
        }
        return null;
    }

    private void process(Node node) {
        if (node.isProcessed()) {
            return;
        }
        node.setProcessed(true);
        matrix[currentCol][currentRow] = node.key;
        currentRow++;
        Node linkedNode = getUnprocessedLinkedNode(node);
        while(linkedNode != null) {

            process(linkedNode);
            linkedNode = getUnprocessedLinkedNode(node);
        }
    }

    private int[][] getCleanArray() {
        // Return clean array without empty elements
        int[][] resultArray = new int[currentCol][];
        for (int i = 0; i < resultArray.length; i++) {
            int colsLength = 0;
            for (int pos = 0; matrix[i][pos] != -1; pos++) {
                colsLength++;
            }
            resultArray[i] = new int[colsLength];
            for (int j = 0; matrix[i][j] != -1; j++) {
                resultArray[i][j] = matrix[i][j];
            }
        }
        return resultArray;
    }

    private void findStronglyConnectedNodes() {
        while (hasUnprocessedNodes()) {
            Node currentNode = null;
            for (Node node : nodes) {
                if (node.getCounter() == counter) {
                    currentNode = node;
                }
            }
            if (currentNode != null) {
                process(currentNode);
                currentRow = 0;
                matrix[currentCol][currentRow] = currentNode.key;
                currentCol++;
            }
            counter--;
        }
    }
}
