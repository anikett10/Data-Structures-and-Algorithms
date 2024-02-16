/**
 * The Edge class represents a directed edge between two tree nodes.
 * It is used to connect nodes in a tree structure.
 *
 */
public class Edge {

    /** The starting node of the edge. */
    private TreeNode startNode;

    /** The ending node of the edge. */
    private TreeNode endNode;

    /**
     * Constructs an Edge object with the specified start and end nodes.
     *
     * @param startNode The starting node of the edge.
     * @param endNode   The ending node of the edge.
     */
    public Edge(TreeNode startNode, TreeNode endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    /**
     * Returns a string representation of the edge.
     *
     * @return A string in the format "startNode -> endNode".
     */
    @Override
    public String toString() {
        return startNode + " -> " + endNode;
    }
}
