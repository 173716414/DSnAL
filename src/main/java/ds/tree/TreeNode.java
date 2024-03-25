package ds.tree;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：TreeNode
 *Date：2024/3/25  11:24
 *Filename：TreeNode
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
