import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> graph = createGraph();
        Kosaraju kosaraju = new Kosaraju(graph);
        int[][] result = kosaraju.getStronglyConnectedNodes();
        System.out.println(Arrays.deepToString(result));
    }

    private static ArrayList<Node> createGraph() {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node0.addOutputNode(node1);
        node0.addOutputNode(node4);

        node1.addOutputNode(node2);
        node1.addInputNode(node3);
        node1.addInputNode(node0);

        node2.addOutputNode(node3);
        node2.addInputNode(node1);

        node3.addOutputNode(node1);
        node3.addInputNode(node2);
        node3.addInputNode(node4);

        node4.addOutputNode(node3);
        node4.addInputNode(node0);

        ArrayList<Node> graph = new ArrayList<>();
        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        return graph;
    }
}
