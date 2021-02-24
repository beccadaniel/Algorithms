package datastructures;

import java.util.*;

public class BST {

    Node root;
    BST(int data) {
        root = new Node(data);
    }

    BST() {
        root = null;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println();
    }

    // post order method of traversing a tree (Left, Right, Root)
    public static void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        // recursion on left subtree
        printPostOrder(node.left);
        // recursion on right subtree
        printPostOrder(node.right);
        System.out.print(node.data + " -> ");
    }

    // preorder traversal using a stack
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node tempNode;
        while (!stack.isEmpty()) {
            tempNode = stack.pop();
            result.add(tempNode.data);
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
        }
        return result;
    }

    // pre order method of traversing a tree (Root, Left, Right)
    public static void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " -> ");

        // recursion on left subtree
        printPreOrder(node.left);
        // recursion on right subtree
        printPreOrder(node.right);
    }

    // inorder traversal using a stack
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node tempNode = root.left;
        while(tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            result.add(tempNode.data);
            tempNode = tempNode.right;
        }
        return result;
    }

    // in order method of traversing a tree (Left, Root, Right)
    public static void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        // recursion on left subtree
        printInOrder(node.left);
        System.out.print(node.data + " -> ");
        // recursion on right subtree
        printInOrder(node.right);
    }

    // level order (breadth first) method of traversing a tree
    public static void printLevelOrder(Node node, int height) {
        int level = 1;
        while (level <= height) {
            printNodeOnLevel(node, level);
            level++;
        }
    }

    public static void printNodeOnLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.println(node.data);
            return;
        }
        printNodeOnLevel(node.left, level-1);
        printNodeOnLevel(node.right, level-1);
    }

    // level order (using a Queue)
    public static void printLevelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // BFS returns list of list (a list per level)
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> level = new ArrayList<>();
        if (root == null) {
            return level;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subLevel = new ArrayList<>();
            for (Node node: queue) {
                subLevel.add(node.data);
            }
            level.add(subLevel);
            int count = queue.size();
            while (count > 0) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                count--;
            }
        }
        return level;
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        boolean zigCheck = true;
        List<List<Integer>> level = new ArrayList<>();
        if (root == null) {
            return level;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subLevel = new ArrayList<>();
            if (zigCheck) {
                for (Node node: queue) {
                    subLevel.add(node.data);
                }
                zigCheck = false;
            } else {
                for (Node node: queue) {
                    subLevel.add(0, node.data);
                }
                zigCheck = true;
            }
            level.add(subLevel);
            int count = queue.size();
            while (count > 0) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                count--;
            }
        }
        return level;
    }

    public static int getTreeHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftNodeHeight = getTreeHeight(node.left);
            int rightNodeHeight = getTreeHeight(node.right);

            if (leftNodeHeight > rightNodeHeight) {
                return leftNodeHeight + 1;
            }
            return rightNodeHeight + 1;
        }
    }

    // same function as getTreeHeight
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int ans = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        return ans;
    }

    /**
     * check if a BST is balanced
     * A BST is balanced if the height of the two subtree of any node never differ by 1
     */
    public boolean isBalancedTree(Node node) {
        if (node == null) {
            return true;
        }

        int heightDiff = getTreeHeight(node.left) - getTreeHeight(node.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalancedTree(node.left) && isBalancedTree(node.right);
        }
    }

    /**
     *  checks if a tree is a valid BST
     * @return
     */
    Integer previouslyChecked = null;
    public boolean isValidBST(Node node) {
        if (node == null) {
            return true;
        }

        // check and recurse left
        if (!isValidBST(node.left)) {
            return false;
        }
        // check current
        if (previouslyChecked != null && node.data <= previouslyChecked) {
            return false;
        }
        // check and recurse right
        if (!isValidBST(node.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSymmetricTree(Node left, Node right) {
        boolean newLeft;
        boolean newRight;
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left != null && right != null && (left.data == right.data)) {
            newLeft = isSymmetricTree(left.left, right.right);
            newRight = isSymmetricTree(left.right, right.left);
        } else {
            return false;
        }
        return newLeft && newRight;
    }

    // Create a minimal BST given a sorted array
    public Node createMinimalTree(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;
        Node root = new Node(array[mid]);
        root.left = createMinimalTree(array, start, mid-1);
        root.right = createMinimalTree(array, mid+1, end);
        return root;
    }


    public static Node buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 1) {
            return new Node(preorder[0]);
        }
        preIndex = 0;
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    // Build tree from inorder and preorder tree traversal
    static int preIndex = 0;
    public static Node buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // pick the first element from preorder, that is the root element

        Node tree = new Node(preorder[preIndex++]);

        if (start == end) {
            return tree;
        }

        // find the index of the current node in inorder traversal
        int inorderIndex = search(inorder, tree.data, start, end);

        tree.left = buildTree(preorder, inorder, start, inorderIndex - 1);
        tree.right = buildTree(preorder, inorder, inorderIndex + 1, end);
        return tree;
    }

    static int search(int[] list, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return end;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            this.data = x;
            left = right = null;
        }
    }
}
