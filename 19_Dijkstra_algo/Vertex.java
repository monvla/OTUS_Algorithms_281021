public class Vertex {

    public static final int NONE = 99;

    char letter;
    int cost;
    char intermediateVertice;
    boolean processed = false;

    Vertex(char letter, int cost, char intermediateVertice) {
        this.letter = letter;
        this.cost = cost;
        this.intermediateVertice = intermediateVertice;
    }

    @Override
    public String toString() {
        return letter + " { " + cost + ", " + intermediateVertice + ", " + processed + " }";
    }

    public boolean isProcessed() {
        return processed;
    }
}
