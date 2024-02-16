import java.util.List;
import java.util.Scanner;

/**
 * The TreeOperations class provides operations on a tree structure, including displaying the tree,
 * obtaining siblings of a node, listing leaves and internal nodes, listing edges, finding the path
 * for a given node, determining the depth of a node, and calculating the height of the tree.
 * The main method allows users to interactively choose and perform these operations.
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 */
public class TreeOperations {

    /**
     * The main method for interactive tree operations.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Build the tree by taking user input
        TreeNode root = buildTree(scanner, null);
        // Main interactive loop
        while (true) {
            System.out.println("1. Display Tree");
            System.out.println("2. Get Siblings of a Node");
            System.out.println("3. List Leaves of the Tree");
            System.out.println("4. List Internal Nodes of the Tree");
            System.out.println("5. List Edges of the Tree");
            System.out.println("6. Path for a Given Node");
            System.out.println("7. Depth of a Node");
            System.out.println("8. Height of the Tree");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Tree:");
                    root.displayTree(0);
                    break;
                case 2:
                    // Get siblings of a node
                    System.out.print("Enter the key of the node: ");
                    int siblingKey = scanner.nextInt();
                    TreeNode siblingNode = getNode(root, siblingKey);
                    if (siblingNode != null) {
                        List<TreeNode> siblings = siblingNode.getSiblings();
                        System.out.println("Siblings of Node " + siblingKey + ": " + siblings);
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 3:
                    // List leaves of the tree
                    List<TreeNode> leaves = root.getLeaves();
                    System.out.println("Leaves of the Tree: " + leaves);
                    break;
                case 4:
                    // List internal nodes of the tree
                    List<TreeNode> internalNodes = root.getInternalNodes();
                    System.out.println("Internal Nodes of the Tree: " + internalNodes);
                    break;
                case 5:
                    // List edges of the tree
                    List<Edge> edges = root.getEdges();
                    System.out.println("Edges of the Tree: " + edges);
                    break;
                case 6:
                    // Find the path for a given node
                    System.out.print("Enter the key of the node: ");
                    int pathKey = scanner.nextInt();
                    TreeNode pathNode = getNode(root, pathKey);
                    if (pathNode != null) {
                        List<TreeNode> path = root.getPath(pathNode);
                        System.out.println("Path for Node " + pathKey + ": " + path);
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 7:
                    // Determine the depth of a node
                    System.out.print("Enter the key of the node: ");
                    int depthKey = scanner.nextInt();
                    TreeNode depthNode = getNode(root, depthKey);
                    if (depthNode != null) {
                        int depth = depthNode.getDepth();
                        System.out.println("Depth of Node " + depthKey + ": " + depth);
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 8:
                    // Calculate the height of the tree
                    int height = root.getHeight();
                    System.out.println("Height of the Tree: " + height);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Recursively retrieves a node with the specified key from the tree.
     *
     * @param root The root of the tree or subtree to search.
     * @param key  The key of the node to find.
     * @return The node with the specified key, or null if not found.
     */
    private static TreeNode getNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.getKey() == key) {
            return root;
        }

        for (TreeNode child : root.getChildren()) {
            TreeNode foundNode = getNode(child, key);
            if (foundNode != null) {
                return foundNode;
            }
        }

        return null;
    }

    /**
     * Builds a tree by taking user input for node values and their children.
     *
     * @param scanner The Scanner object to take user input.
     * @param parent  The parent node (null if building the root).
     * @return The root node of the constructed tree.
     */
    private static TreeNode buildTree(Scanner scanner, TreeNode parent) {
        try {
            System.out.print("Enter the value for the " + (parent == null ? "root" : "child") + " node: ");
            int nodeValue = scanner.nextInt();
            TreeNode node = new TreeNode(nodeValue);

            if (parent != null) {
                parent.addChild(node);
            }

            System.out.print("Do you want to add children for node " + node.getKey() + "? (yes/no): ");
            String addChildren = scanner.next().toLowerCase();

            if (addChildren.equals("yes")) {
                System.out.print("Enter the number of children for node " + node.getKey() + ": ");
                int numChildren = scanner.nextInt();

                for (int i = 0; i < numChildren; i++) {
                    buildTree(scanner, node);
                }
            }

            return node;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer value.");
            scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            return buildTree(scanner, parent);
        }
    }

}
