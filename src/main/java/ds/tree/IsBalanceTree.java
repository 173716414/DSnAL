package ds.tree;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：IsBalanceTree
 *Date：2024/4/12  16:49
 *Filename：IsBalanceTree
 */
public class IsBalanceTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }
    public int getHeight(TreeNode node){
        if (node == null)   return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
}
