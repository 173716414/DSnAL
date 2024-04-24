package ds.tree;

import javax.management.ObjectName;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：Traversal
 *Date：2024/4/24  9:53
 *Filename：Traversal
 */
public class Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> st = new LinkedList<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null)  st.push(node.left);
                st.push(node);
                st.push(null);
            } else {
                st.pop();
                result.add(st.pop().val);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> st = new LinkedList<>();
        if (root != null)   st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                st.push(node);
                if (node.left != null) st.push(node.left);
            } else {
                st.pop();
                result.add(st.pop().val);
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> st = new LinkedList<>();
        if (root != null)   st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                st.push(node);
                st.push(null);
                if (node.right != null) st.push(node.right);
                if (node.left != null)  st.push(node.left);
            } else {
                st.pop();
                result.add(st.pop().val);
            }
        }
        return result;
    }
}
