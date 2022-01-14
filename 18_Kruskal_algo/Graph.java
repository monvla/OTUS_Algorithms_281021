public class Graph {


    int verticesNum, edgesNum;
    Edge[] edges;

    Graph(int v, int e)
    {
        verticesNum = v;
        edgesNum = e;
        edges = new Edge[edgesNum];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    public static class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    }

    public Edge[] runKruskal() {
        return Kruskal.run(edges, verticesNum);
    }

}
