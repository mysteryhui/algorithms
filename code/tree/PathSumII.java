package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/26
 * @Description:
 */
public class PathSumII {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node11.left = node7;
        node11.right = node2;

        node44.left = node5;
        node44.right = node1;

        node4.left = node11;

        node8.left = node13;
        node8.right = node44;

        root.left = node4;
        root.right = node8;

        PathSumII pathSumII = new PathSumII();
        List<List<Integer>> lists = pathSumII.pathSum(root, 22);
        System.out.println("lists : " + lists);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        pathSumRec(root, sum, new ArrayList<>(), lists);
        return lists;
    }

    public void pathSumRec(TreeNode node, int sum, List<Integer> list, List<List<Integer>> lists ){

        int nodeVal = node.val;
        if(node.right == null && node.left == null){

            if(sum == nodeVal){
                list.add(nodeVal);
                lists.add(list);
            }else {
                list = null;
            }

            return;
        }

        if(node.left != null){
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(nodeVal);
            pathSumRec(node.left, sum - nodeVal, newList, lists);
        }

        if(node.right != null){
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(nodeVal);
            pathSumRec(node.right, sum - nodeVal, newList, lists);
        }
        list = null;

    }

}
