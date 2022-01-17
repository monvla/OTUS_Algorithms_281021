import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge('A', 'B', 2));
        edges.add(new Edge('A', 'C', 3));
        edges.add(new Edge('A', 'D', 6));
        edges.add(new Edge('B', 'C', 4));
        edges.add(new Edge('B', 'E', 9));
        edges.add(new Edge('C', 'D', 1));
        edges.add(new Edge('C', 'F', 6));
        edges.add(new Edge('C', 'E', 7));
        edges.add(new Edge('E', 'F', 1));
        edges.add(new Edge('D', 'F', 4));
        edges.add(new Edge('E', 'G', 5));
        edges.add(new Edge('F', 'E', 1));
        System.out.print(new Dijkstra(edges).getCheapestPath());
    }
}
