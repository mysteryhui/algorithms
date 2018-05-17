package tree;

/**
 * @Author : wanghui
 * @Date : create on 2018/5/9
 * @Description: 将一颗二叉树根据先序遍历转换成一个链表
 */
public class FlattenTreeToLinkedList {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        flatten(root);

        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }


    public static void flatten(TreeNode root){
        root = flattenByPreOrder(root);
    }

    /**
     * 根据先序遍历结果将树转换成一个链表
     * @param node
     */
    public static TreeNode flattenByPreOrder(TreeNode node){
        if(node == null)
            return node;

        TreeNode leftChildList = null, rightChildList = null;
        if(node.left != null){
            leftChildList = flattenByPreOrder(node.left);
        }

        if(node.right != null){
            rightChildList = flattenByPreOrder(node.right);
        }

        node.right = leftChildList;
        node.left = null;
        TreeNode leftListLastNode = node;
        while(leftListLastNode.right != null){
            leftListLastNode = leftListLastNode.right;
        }

        leftListLastNode.right = rightChildList;
        return node;
    }

}
