package test;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {

    private int findLCAAndDistance(TreeNode root, TreeNode a, TreeNode b, int[] distA, int[] distB, int depth) {
        if (root == null) {
            return -1;
        }

        // 如果当前节点是a或b，更新对应的距离
        int leftDistance = findLCAAndDistance(root.left, a, b, distA, distB, depth + 1);
        int rightDistance = findLCAAndDistance(root.right, a, b, distA, distB, depth + 1);

        if (root == a) {
            distA[0] = depth;
            if (root == b) {
                distB[0] = depth;
            }
            return depth;
        }

        if (root == b) {
            distB[0] = depth;
            return depth;
        }

        // 如果a和b分别位于当前节点的左右子树中，当前节点是LCA
        if (leftDistance != -1 && rightDistance != -1) {
            return (leftDistance - depth) + (rightDistance - depth);
        }

        // 如果其中一个子树返回了有效距离，则继续向上传递
        if (leftDistance != -1) {
            return leftDistance;
        }
        if (rightDistance != -1) {
            return rightDistance;
        }

        return -1;
    }

    public int findShortestPath(TreeNode root, TreeNode a, TreeNode b) {
        int[] distA = new int[1]; // 用于保存节点a的深度
        int[] distB = new int[1]; // 用于保存节点b的深度
        int lcaDistance = findLCAAndDistance(root, a, b, distA, distB, 0);

        if (root == a) {
            return distB[0];
        }
        if (root == b) {
            return distA[0];
        }

        return distA[0] + distB[0] - 2 * lcaDistance;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 创建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 查找节点4和节点7之间的最短路径
        TreeNode a = root.left.left; // 节点4
        TreeNode b = root.right;           // 节点1 (根节点)

        int distance = tree.findShortestPath(root, a, b);
        System.out.println("The shortest path between node " + a.val + " and node " + b.val + " is: " + distance);
    }
}
