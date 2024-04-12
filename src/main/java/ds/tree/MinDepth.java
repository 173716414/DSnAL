package ds.tree;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：MinDepth
 *Date：2024/4/12  14:57
 *Filename：MinDepth
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        return minHeight(root);
    }
    //求根节点最小高度
    public int minHeight(TreeNode node){
        if (node == null)   return 0;
        int left = minHeight(node.left);
        int right = minHeight(node.right);
        if (node.left == null && node.right == null)  return 1;
        if (node.left != null && node.right == null)  return 1 + left;
        if (node.left == null) return 1 + right;
        return 1 + Math.min(left, right);
    }
}
