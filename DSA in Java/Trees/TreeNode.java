import java.util.ArrayList;
import java.util.List;

/**
 * The TreeNode class represents a node in a tree data structure.
 * Each node has a key, children nodes, and a reference to its parent node.
 * The class provides various methods for tree operations, such as displaying the tree,
 * getting siblings of a node, listing leaves and internal nodes, listing edges,
 * finding the path for a given node, determining the depth of a node, and calculating
 * the height of the tree.
 *
 */
public class TreeNode {
    /** The key of the node. */
    private int key;

    /** The list of children nodes. */
    private List<TreeNode> children;

    /** The parent node. */
    private TreeNode parent;

    /**
     * Constructs a TreeNode with the specified key.
     *
     * @param key The key of the node.
     */
    public TreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }

    /**
     * Adds a child node to the current node.
     *
     * @param child The child node to add.
     */
    public void addChild(TreeNode child) {
        child.setParent(this);
        children.add(child);
    }

    /**
     * Sets the parent node of the current node.
     *
     * @param parent The parent node to set.
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * Gets the key of the node.
     *
     * @return The key of the node.
     */
    public int getKey() {
        return key;
    }

    /**
     * Displays the tree structure starting from the current node.
     *
     * @param level The level of the current node in the tree.
     */
    public void displayTree(int level) {
        System.out.println("  ".repeat(level) + key);
        for (TreeNode child : children) {
            child.displayTree(level + 1);
        }
    }

    /**
     * Gets the siblings of the current node.
     *
     * @return The list of sibling nodes.
     */
    public List<TreeNode> getSiblings() {
        if (parent == null) {
            return new ArrayList<>();
        }

        List<TreeNode> siblings = new ArrayList<>();
        for (TreeNode sibling : parent.children) {
            if (!sibling.equals(this)) {
                siblings.add(sibling);
            }
        }
        return siblings;
    }

    /**
     * Gets the leaves of the subtree rooted at the current node.
     *
     * @return The list of leaf nodes.
     */
    public List<TreeNode> getLeaves() {
        List<TreeNode> leaves = new ArrayList<>();
        if (children.isEmpty()) {
            leaves.add(this);
        } else {
            for (TreeNode child : children) {
                leaves.addAll(child.getLeaves());
            }
        }
        return leaves;
    }

    /**
     * Gets the internal nodes of the subtree rooted at the current node.
     *
     * @return The list of internal nodes.
     */
    public List<TreeNode> getInternalNodes() {
        List<TreeNode> internalNodes = new ArrayList<>();
        if (!children.isEmpty()) {
            internalNodes.add(this);
            for (TreeNode child : children) {
                internalNodes.addAll(child.getInternalNodes());
            }
        }
        return internalNodes;
    }

    /**
     * Gets the edges of the subtree rooted at the current node.
     *
     * @return The list of edges.
     */
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (TreeNode child : children) {
            edges.add(new Edge(this, child));
            edges.addAll(child.getEdges());
        }
        return edges;
    }

    /**
     * Gets the path from the current node to the target node.
     *
     * @param target The target node.
     * @return The list of nodes in the path.
     */
    public List<TreeNode> getPath(TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        if (this.equals(target)) {
            path.add(this);
        } else {
            for (TreeNode child : children) {
                List<TreeNode> childPath = child.getPath(target);
                if (!childPath.isEmpty()) {
                    path.add(this);
                    path.addAll(childPath);
                    break;
                }
            }
        }
        return path;
    }

    /**
     * Gets the depth of the current node in the tree.
     *
     * @return The depth of the node.
     */
    public int getDepth() {
        if (parent == null) {
            return 0;
        }
        return 1 + parent.getDepth();
    }

    /**
     * Calculates the height of the subtree rooted at the current node.
     *
     * @return The height of the subtree.
     */
    public int getHeight() {
        int height = 0;
        for (TreeNode child : children) {
            height = Math.max(height, 1 + child.getHeight());
        }
        return height;
    }

    /**
     * Returns a string representation of the node (its key).
     *
     * @return The string representation of the node.
     */
    @Override
    public String toString() {
        return String.valueOf(key);
    }

    /**
     * Gets the list of children nodes.
     *
     * @return The list of children nodes.
     */
    public List<TreeNode> getChildren() {
        return children;
    }
}
