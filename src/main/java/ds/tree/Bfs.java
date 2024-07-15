package ds.tree;

import designPattern.statePattern.State;

import java.util.*;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：Bfs
 *Date：2024/7/15  17:07
 *Filename：Bfs
 */
public class Bfs {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode right_right = new TreeNode(4);
        root.left = left;
        root.right = right;
        root.right.right = right_right;
        bfs(root);
        System.out.println();
        preOrderTravseral(root);
        System.out.println();
        preOrderIteration(root);
        System.out.println();
        inOrderTravseral(root);
        System.out.println();
        inOrderIteration(root);
        System.out.println();
        postOrderTravseral(root);
        System.out.println();
        postOrderIteration(root);
        Collections.reverse(list);
        System.out.println(list);
    }
    public static void inOrderIteration(TreeNode root) {
        if (root == null)   return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }
    public static void preOrderIteration(TreeNode root) {
        if (root == null)   return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null)  stack.push(node.left);
        }
    }

    public static void postOrderIteration(TreeNode root) {
        if (root == null)   return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
    public static void preOrderTravseral(TreeNode root) {
        if (root == null)   return;
        System.out.print(root.val + " ");
        preOrderTravseral(root.left);
        preOrderTravseral(root.right);
    }

    public static void inOrderTravseral(TreeNode root) {
        if (root == null)   return;
        inOrderTravseral(root.left);
        System.out.print(root.val + " ");
        inOrderTravseral(root.right);
    }

    public static void postOrderTravseral(TreeNode root) {
        if (root == null)   return;
        postOrderTravseral(root.left);
        postOrderTravseral(root.right);
        System.out.print(root.val + " ");
    }
    public static void bfs(TreeNode root) {
        if (root == null)   return;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

}
