package comic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyTree {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 6, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(linkedList);
        System.out.print("前序遍历: ");
        preOrderTraveral(treeNode);
        System.out.println();

        System.out.print("前序遍历 栈: ");
        preOrderTraveralWithStack(treeNode);
        System.out.println();

        System.out.print("中序遍历: ");
        inOrderTraveral(treeNode);
        System.out.println();

        System.out.print("中序遍历 栈: ");
        inOrderTraveralWithStack(treeNode);
        System.out.println();

        System.out.print("后序遍历: ");
        postOrderTraveral(treeNode);
        System.out.println();

        System.out.print("后序遍历 栈: ");
        postOrderTraveralWithStack(treeNode);
        System.out.println();

        System.out.print("宽度遍历: ");
        levelOrderTraversal(treeNode);
        System.out.println();
    }

    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data + "->");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.left);
        System.out.print(node.data);
        inOrderTraveral(node.right);
    }

    public static void inOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.data + "->");
                treeNode = treeNode.right;
            }
        }
    }

    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.print(node.data);
    }

    public static void postOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> reserveStack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            reserveStack.push(pop);

            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        while (!reserveStack.isEmpty()) {
            TreeNode pop = reserveStack.pop();
            System.out.print(pop.data + "->");
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        TreeNode treeNode = root;
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);
        while (!linkedList.isEmpty()) {
            treeNode = linkedList.poll();
            System.out.print(treeNode.data + "->");
            if (treeNode.left != null) {
                linkedList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                linkedList.add(treeNode.right);
            }
        }
    }

    private static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        TreeNode node = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }

        Integer data = linkedList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(linkedList);
            node.right = createBinaryTree(linkedList);
        }

        return node;
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
