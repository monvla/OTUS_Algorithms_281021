import java.util.Arrays;

public class Kruskal {

    static class Subset
    {
        int parent, rank;
    }

    static int find(Subset[] subsets, int i)
    {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    static void Union(Subset[] subsets, int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    static Graph.Edge[] run(Graph.Edge[] edges, int numVertices)
    {
        Graph.Edge[] result = new Graph.Edge[numVertices];

        int e = 0;

        for (int i = 0; i < numVertices; ++i) {
            result[i] = new Graph.Edge();
        }

        Arrays.sort(edges);

        Subset[] subsets = new Subset[numVertices];
        for (int v = 0; v < numVertices; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int nextEdgeIndex = 0;

        while (e < numVertices - 1)
        {
            Graph.Edge next_edge = edges[nextEdgeIndex++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        return result;
    }
}
