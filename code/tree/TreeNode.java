package tree;

import java.util.Stack;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/8
 * @Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    //先序遍历
    //先输出父节点，然后再输出左子节点，最后输出右子节点
    void preOrder(TreeNode treeNode){

        if(treeNode != null)
            System.out.println(treeNode.val);
        if(treeNode.left !=null)
            preOrder(treeNode.left);

        if(treeNode.right != null)
            preOrder(treeNode.right);

    }

    //使用循环来先序遍历
    void preOrderIteratively(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();

//        TreeNode node = root;
//        //遍历节点以及其左子树
//        while(node != null){
//
//            System.out.println(node.val + " ");
//            if(node.right != null)
//                stack.push(node.right);
//
//            if(node.left != null)
//                node = node.left;
//            else if(!stack.isEmpty())
//                node = stack.pop();
//            else
//                node = null;
//
//        }

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode node1 = stack.pop();
            System.out.println(node1.val + " ");

            if(node1.right != null)
                stack.push(node1.right);

            if(node1.left != null)
                stack.push(node1.left);

        }

    }

    //中序遍历
    String inorder(TreeNode treeNode){

        String inorderStr = "";

        //先遍历左子节点，然后遍历中间节点，最后遍历右子节点
        if(treeNode.left !=null)
            inorderStr = inorder(treeNode.left) + " " + inorderStr;

        if(treeNode != null)
            inorderStr = inorderStr + " " + treeNode.val ;

        if(treeNode.right != null)
            inorderStr = inorderStr + " " + inorder(treeNode.right);

        return inorderStr;
    }

    //后序遍历
    String postOrder(TreeNode treeNode){

        String postOrderStr = "";

        //先遍历左子节点，然后遍历中间节点，最后遍历右子节点
        if(treeNode.left !=null)
            postOrderStr = postOrder(treeNode.left) +" " + postOrderStr;

        if(treeNode.right != null)
            postOrderStr = postOrderStr + "" + postOrder(treeNode.right);

        if(treeNode != null)
            postOrderStr = postOrderStr + " " + treeNode.val;


        return postOrderStr;

    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5);

        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);

        TreeNode thirdLeftNode = new TreeNode(15);
        TreeNode thirdRightNode = new TreeNode(7);

        rightNode.left = thirdLeftNode;
        rightNode.right = thirdRightNode;

        root.left = leftNode;
        root.right = rightNode;

        root1.left = root;
        root1.right = new TreeNode(6);

        String inorderStr = new TreeNode(0).inorder(root1);
//        System.out.println(inorderStr);

        String postOrderStr = new TreeNode(0).postOrder(root1);
//        System.out.println(postOrderStr);

        new TreeNode(0).preOrderIteratively(root1);
        new TreeNode(0).preOrderIteratively(root1);

    }

}
