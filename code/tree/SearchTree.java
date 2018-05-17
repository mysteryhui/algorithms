package tree;

/**
 * 二叉搜索树
 */

import java.lang.annotation.Target;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/11
 * @Description:
 */
public class SearchTree {

    TreeNode root;

    public static void main(String[] args) {

        SearchTree tree = new SearchTree();
//        tree.insertIterative(10);
//        tree.insertIterative(11);
//        tree.insertIterative(12);
//        tree.insertIterative(8);
//        tree.insertIterative(7);
//        tree.insertIterative(9);

        tree.insertRecursive(10);
        tree.insertRecursive(11);
        tree.insertRecursive(12);
        tree.insertRecursive(8);
        tree.insertRecursive(7);
        tree.insertRecursive(9);

        TreeNode root = tree.root;
        root.preOrder(root);

        System.out.println(123);
    }

    public TreeNode search(TreeNode node,int target){

        if(node == null)
            return null;

        if(node.val == target)
            return node;
        else if(node.val > target)
            return search(node.left,target);
        else
            return search(node.right,target);

    }

    public void insertRecursive(int target){

        root = insertRecursive(root,target);

    }

    public void insertIterative(int target){
        insertIterative(root,target);
    }


    /**
     * 通过递归的方式插入一个元素
     * @param node
     * @param target
     * @return
     */
    public TreeNode insertRecursive(TreeNode node,int target){

        //如果找到相同元素，就不插入，如果找不到就插入
        if(node == null)
            return new TreeNode(target);

        else if(node.val > target)
            node.left = insertRecursive(node.left,target);
        else if(node.val < target)
            node.right = insertRecursive(node.right,target);

        return node;
    }

    public void insertIterative(TreeNode node,int target){

        TreeNode nodeTmp = node;

        if(node == null){
            root = new TreeNode(target);
            return;
        }


        while(nodeTmp != null){

            if(nodeTmp.val == target)
                return;
            else if(nodeTmp.val < target){

                if(nodeTmp.right == null){
                    nodeTmp.right = new TreeNode(target);
                    return;
                }else
                    nodeTmp = nodeTmp.right;

            } else{

                if(nodeTmp.left == null){
                    nodeTmp.left = new TreeNode(target);
                    return;
                }else
                    nodeTmp = nodeTmp.left;
            }

        }

    }

    public TreeNode findMin(TreeNode node){

        if(node == null)
            return null;
        else if(node.left == null)
            return node;
        else
            return findMin(node.left);
    }

    public TreeNode findMax(TreeNode node){

        if(node == null)
            return null;
        else if(node.right == null)
            return node;
        else
            return findMax(node.right);

    }

    //因为节点中没有存父节点的信息，所以删除的时候通过递归来删除，可以有效的解决这个问题
    //但是下面的递归算法效率不高，因为在左右子树都不为空的时候，需要遍历两遍右子树，一遍查找，一遍删除
    public TreeNode remove(TreeNode node,int target){

        //找到节点，如果需要删除的节点没有子节点，那么就可以直接删除

        //如果只有一个子节点，那么将这个删除的节点和子节点交换，同时删除交换之后的节点

        //如果被删除的节点有两个节点，则取右子树的节点的最小值来代替

        if(node == null)
            return null;

        if(node.val > target)
            //递归删除左子树
            node.left = remove(node.left,target);
        else if(node.val < target)
            //需要删除的值在右边，递归删除右子树
            node.right = remove(node.right,target);
        else if(node.left != null && node.right != null){
            //左右子树都不为空的时候，去右子树中的最小值，然后递归删除右子树中的最小值
            node.val = findMin(node.right).val;
            node.right = remove(node.right,node.val);
        }else
            node = node.right != null ? node.right : node.left;

        return node;

    }


}
