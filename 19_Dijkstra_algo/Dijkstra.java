import java.util.ArrayList;

public class Dijkstra {

    ArrayList<Edge> edges;
    ArrayList<Vertex> vertices;

    Dijkstra(ArrayList<Edge> edges) {
        this.edges = edges;
        vertices = createVertices();
    }

    public void run() {
        processVertices();
        int i = 0;
    }

    private ArrayList<Vertex> createVertices() {
        ArrayList<Vertex> vertices = new ArrayList<>();
        for (Edge edge : edges) {
            if (!hasVertex(vertices, edge.v1)) {
                vertices.add(new Vertex(edge.v1, Vertex.NONE, '-'));
            }
            if (!hasVertex(vertices, edge.v2)) {
                vertices.add(new Vertex(edge.v2, Vertex.NONE, '-'));
            }
        }
        vertices.get(0).cost = 0;
        return vertices;
    }

    private void processVertices() {
        while (hasUnprocessedVertices()) {
            Vertex processingVertex = getCheapestVertex();
            for (Edge edge : edges) {
                if (edge.v1 == processingVertex.letter) {
                    Vertex destinationVertex = getVertexByLetter(edge.v2);
                    if (destinationVertex.cost > edge.weight) {
                        destinationVertex.cost = processingVertex.cost + edge.weight;
                        destinationVertex.intermediateVertice = processingVertex.letter;
                    }
                }
            }
            processingVertex.processed = true;
        }
    }

    private boolean hasVertex(ArrayList<Vertex> vertices, char letter) {
        for (Vertex vertex : vertices) {
            if (vertex.letter == letter) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUnprocessedVertices() {
        for (Vertex vertex : vertices) {
            if (!vertex.isProcessed()) {
                return true;
            }
        }
        return false;
    }

    private Vertex getCheapestVertex() {
        Vertex cheapestVertex = vertices.get(vertices.size()-1);
        for (Vertex vertex : vertices) {
            if (cheapestVertex.cost > vertex.cost && !vertex.isProcessed()) {
                cheapestVertex = vertex;
            }
        }
        return cheapestVertex;
    }

    private Vertex getVertexByLetter(char letter) {
        for (Vertex vertex : vertices) {
            if (vertex.letter == letter) {
                return vertex;
            }
        }
        return null;
    }
}
