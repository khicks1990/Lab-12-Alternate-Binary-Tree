import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeDisplaySwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                System.exit(1);
            }
        });
    }

    private static void createAndShowGUI() throws Exception {
        JFrame frame = new JFrame("Binary Tree Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        BinaryTree bTree = new BinaryTree();
        bTree.buildTreeFromFile();

        JTree tree = new JTree(bTree.getTreeModel());
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class BinaryTree {
    static class Node {
        private String name;
        private Node left, right;

        private Node(String name) {
            this.name = name;
            left = null;
            right = null;
        }

        private Node(String name, Node left, Node right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }

    private Node root = null;

    javax.swing.tree.TreeModel getTreeModel() {
        if (root == null) {
            return new javax.swing.tree.DefaultTreeModel(new DefaultMutableTreeNode("Empty Tree"));
        }
        return new javax.swing.tree.DefaultTreeModel(buildTreeNode(root));
    }

    private DefaultMutableTreeNode buildTreeNode(Node node) {
        if (node == null) return null;
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(node.name);
        
        if (node.left != null) {
            treeNode.add(buildTreeNode(node.left));
        }
        if (node.right != null) {
            treeNode.add(buildTreeNode(node.right));
        }
        return treeNode;
    }

    void buildTreeFromFile() throws IOException {
        // Create a map to keep track of nodes by their names
        Map<String, Node> nodeMap = new HashMap<>();
    
        // Specify the file name directly
        File file = new File("BinaryTreeInput.txt");
    
        // Check if the file exists; if not, show a message and exit the program
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "File not found: BinaryTreeInput.txt. Program will exit.");
            System.exit(1); // Exit if the file isn't found
        }
    
        // Create a Scanner to read the file
        
        
        // Read the number of vertices (nodes) from the first line of the file
        // Move to the next line after reading the integer
    
        // Loop through the number of vertices to build the tree
            // Read the line corresponding to the current vertex    
            // Split the line into parts (node values)
            
            // Create an array to hold the Node objects for the current line
            
            // Populate the treeNodes array with Node objects for each part

                 // Get or create the Node for the part
            
    
            // Establish left child relationship if applicable
                // Assign the second node as the left child
            
    
            // Establish right child relationship if applicable
                 // Assign the third node as the right child
            
    
            // Set the root of the tree if it's the first vertex
                 // The first node becomes the root
            
        
        // Close the scanner to release resources
    }

    static Node getNode(String name, Map<String, Node> nodeMap) {
        Node aNode = nodeMap.get(name);
        if (aNode == null) {
            aNode = new Node(name);
            nodeMap.put(name, aNode);
        }
        return aNode;
    }
}