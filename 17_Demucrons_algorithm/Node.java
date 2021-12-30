import java.util.ArrayList;

public class Node {
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

}
