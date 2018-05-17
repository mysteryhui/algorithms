package tree;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/8
 * @Description:
 */
public class MaxDepth {

    public static void main(String[] args) {

        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);

        TreeNode thirdLeftNode = new TreeNode(15);
        TreeNode thirdRightNode = new TreeNode(7);

        rightNode.left = thirdLeftNode;
        rightNode.right = thirdRightNode;

        root.left = leftNode;
        root.right = rightNode;

        maxDepth.maxDepth(root);

    }

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        int depth = depthTravel(root,1);
        System.out.println(depth);

        return depth;

    }

    public int depthTravel(TreeNode node,int depth){

        int leftDepth = 0,rightDepth = 0;

        if(node.left != null)
            leftDepth += depthTravel(node.left,1);

        if(node.right != null)
            rightDepth += depthTravel(node.right,1);

        return leftDepth > rightDepth ? depth + leftDepth : depth + rightDepth;
    }


}
