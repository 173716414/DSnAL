package ds.tree;

/*
 *Author：Victor_htq
 *Package：ds.tree
 *Project：DSnAL
 *name：isSameTree
 *Date：2024/4/9  14:45
 *Filename：isSameTree
 */
// Leetcode100，相同的树
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q == null)
            return false;
        if (p == null && q != null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
