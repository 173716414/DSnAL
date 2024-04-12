package ds.tree;

import java.util.Deque;
import java.util.LinkedList;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：MaxDepth
 *Date：2024/4/12  11:36
 *Filename：MaxDepth
 */
public class MaxDepth {
    /**
     * 迭代法，使用层序遍历
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }
}
