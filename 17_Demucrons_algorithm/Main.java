import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DemucronsGraph demucronGraph = new DemucronsGraph(createConnectedGraphNodes());
        int[][] levels = demucronGraph.getLevels();
        System.out.println(Arrays.deepToString(levels));
    }

    public static ArrayList<Node> createConnectedGraphNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);

        node1.addInputNode(node10);
        node1.addInputNode(node9);
        node1.addOutputNode(node13);
        node1.addOutputNode(node3);

        node2.addInputNode(node8);
        node2.addOutputNode(node13);

        node3.addInputNode(node4);
        node3.addInputNode(node1);
        node3.addInputNode(node5);
        node3.addInputNode(node11);
        node3.addInputNode(node13);

        node4.addInputNode(node8);
        node4.addInputNode(node6);
        node4.addOutputNode(node3);

        node5.addOutputNode(node9);
        node5.addOutputNode(node3);
        node5.addOutputNode(node10);

        node6.addInputNode(node7);
        node6.addInputNode(node8);
        node6.addOutputNode(node4);
        node6.addOutputNode(node11);
        node6.addOutputNode(node13);
        node6.addOutputNode(node12);

        node7.addInputNode(node9);
        node7.addOutputNode(node6);

        node8.addOutputNode(node4);
        node8.addOutputNode(node6);
        node8.addOutputNode(node14);
        node8.addOutputNode(node2);

        node9.addInputNode(node5);
        node9.addOutputNode(node1);
        node9.addOutputNode(node7);

        node10.addInputNode(node5);
        node10.addOutputNode(node1);
        node10.addOutputNode(node14);
        node10.addOutputNode(node12);

        node11.addInputNode(node6);
        node11.addInputNode(node14);
        node11.addOutputNode(node3);

        node12.addInputNode(node10);
        node12.addInputNode(node6);

        node13.addInputNode(node1);
        node13.addInputNode(node6);
        node13.addInputNode(node2);
        node13.addOutputNode(node3);

        node14.addInputNode(node8);
        node14.addInputNode(node10);
        node14.addOutputNode(node11);

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        nodes.add(node8);
        nodes.add(node9);
        nodes.add(node10);
        nodes.add(node11);
        nodes.add(node12);
        nodes.add(node13);
        nodes.add(node14);
        return nodes;
    }
}
