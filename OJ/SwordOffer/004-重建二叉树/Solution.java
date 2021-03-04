
/*
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class Solution {

    public void preTraveBiTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preTraveBiTree(root.left);
            preTraveBiTree(root.right);
        }
        return;
    }

    public TreeNode conSturctCore(int[] pre, int preLeftIndex, int preRightIndex, int[] in, int inLeftIndex,
            int inRightIndex) {
        int rootValue = pre[preLeftIndex];
        TreeNode rootNode = new TreeNode(rootValue);

        if (preLeftIndex == preRightIndex && inLeftIndex == inRightIndex && pre[preLeftIndex] == in[inLeftIndex]) {
            return rootNode;
        }

        int inFindIndex = inLeftIndex;
        while (inFindIndex <= inRightIndex && in[inFindIndex] != rootValue) {
            inFindIndex++;
        }

        int leftTreeLen = inFindIndex - inLeftIndex;
        if (leftTreeLen > 0) {
            rootNode.left = conSturctCore(pre, preLeftIndex+1, preLeftIndex + leftTreeLen, in, inLeftIndex,
                    inFindIndex - 1);
        } else if (leftTreeLen < preRightIndex - preLeftIndex) {
            rootNode.right = conSturctCore(pre, preLeftIndex, preRightIndex, in, inLeftIndex, inRightIndex)
        }

        return rootNode;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

    }

    public static void main(String[] args) {

    }
}
