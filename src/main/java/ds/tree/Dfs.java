package ds.tree;

import java.util.*;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：DfsRecursion
 *Date：2024/3/28  9:45
 *Filename：DfsRecursion
 */
public class Dfs {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode right_right = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.right = right_right;
        dfsRecursion(root);
        System.out.println();
        dfsIteration(root);
        System.out.println();
        dfsMiddleIteration(root);
        System.out.println();
        System.out.println(postorderTraversal(root));
    }
    public static void dfsRecursion(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.val + " ");
        dfsRecursion(root.left);
        dfsRecursion(root.right);
    }

    public static void dfsIteration(TreeNode root) {
        if (root == null)   return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void dfsMiddleIteration(TreeNode root) {
        if (root == null)   return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        // stack.push(cur);
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

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)   return null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
