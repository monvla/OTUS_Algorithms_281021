import java.util.ArrayList;

public class Node {

    public static final int UNASSIGNED = 0;

    private int counter = UNASSIGNED;
    private boolean processed = false;
    public int key;

    public ArrayList<Node> inputs = new ArrayList<>();
    public ArrayList<Node> outputs = new ArrayList<>();

    Node(int key) {
        this.key = key;
    }

    public void addInputNode(Node node) {
        inputs.add(node);
    }

    public void addOutputNode(Node node) {
        outputs.add(node);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int value) {
        counter = value;
    }

    public void invert() {
        ArrayList<Node> tempInputs = new ArrayList<>(inputs);
        inputs = outputs;
        outputs = tempInputs;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
