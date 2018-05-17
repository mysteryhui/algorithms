package tree;

/**
 * 根据中序和后序构造一个树，
 */

import java.util.Arrays;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/8
 * @Description:
 */
public class BuildTree {

    public static void main(String[] args) {

//        int[] inorder = {9,3,15,20,7};
//        int[] postOrder = {9,15,7,20,3};

        int[] preOrder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

//        int[] subArr = Arrays.copyOfRange(inorder, 0 , 0);
//        System.out.println(JSON.toJSONString(subArr));

//        TreeNode root = buildTreeByInorderAndPostOrder(inorder, postOrder);
        TreeNode root = buildTreeByPreOrderAndInorder(preOrder, inorder);

    }

    /**
     * 中序遍历的性质：左子树 根节点 右子树
     * 后续遍历的性质：左子树 右子树 根节点
     *
     * 找到当前序列的根节点，然后再递归找左子树的根节点，右子树的根节点
     * 后序遍历序列的最后一个值，就是当前子树的根节点，然后在先序遍历中找到当前根节点左边的序列，那就是左子树的先序遍历序列，然后右边就是右子树的先序遍历序列
     * 同时根据上述性质，还有左子树的长度，可以很容易的找到后序遍历中的左子树序列，右子树序列，
     * 那么就可以通过左子树的先序遍历序列，左子树的后序遍历序列来找到左子树的根节点
     * 那么右子树同理
     *
     * @param inorder
     * @param postOrder
     * @return
     */
    public static TreeNode buildTreeByInorderAndPostOrder(int[] inorder, int[] postOrder) {

        if(inorder.length == 0)
            return null;

        if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }

        int rootVal = postOrder[postOrder.length-1];
        TreeNode root = new TreeNode(rootVal);

        int leftChildLength = 0;
        while(true){
            if(rootVal == inorder[leftChildLength])
                break;
            leftChildLength++;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftChildLength);        //左子树的中序遍历序列
        int[] leftPostOrder = Arrays.copyOfRange(postOrder, 0, leftChildLength);    //左子树的后续遍历序列

        int[] rightInorder = Arrays.copyOfRange(inorder, leftChildLength+1, inorder.length);   //右子树的右序遍历序列
        int[] rightPostOrder = Arrays.copyOfRange(postOrder, leftChildLength, postOrder.length -1); //右子树的后序遍历序列

        TreeNode leftRoot = buildTreeByInorderAndPostOrder(leftInorder, leftPostOrder);
        TreeNode rightRoot = buildTreeByInorderAndPostOrder(rightInorder, rightPostOrder);

        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    public static TreeNode buildTreeByPreOrderAndInorder(int[] preOrder, int[] inorder){

        if(preOrder.length == 0)
            return null;

        if(preOrder.length == 1)
            return new TreeNode(preOrder[0]);

        int rootVal = preOrder[0];
        TreeNode root = new TreeNode(rootVal);

        int leftChildLength = 0;
        while(true){

            if(rootVal == inorder[leftChildLength])
                break;
            leftChildLength++;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftChildLength);
        int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, leftChildLength+1);

        int[] rightInorder = Arrays.copyOfRange(inorder, leftChildLength+1, inorder.length);
        int[] rightPreOrder = Arrays.copyOfRange(preOrder, leftChildLength+1, preOrder.length);

        TreeNode leftChild =  buildTreeByPreOrderAndInorder(leftPreOrder, leftInorder);
        TreeNode rightChild = buildTreeByPreOrderAndInorder(rightPreOrder, rightInorder);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

}
