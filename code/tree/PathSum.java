package tree;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/26
 * @Description:
 */
public class PathSum {

    public static void main(String[] args) {

        System.out.println(false || true);
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;
        else
            return  pathSum(root, sum);

    }

    public boolean pathSum(TreeNode root, int sum){

        int nodeVal = root.val;
        boolean leftBoolean = false;
        boolean rightBoolean = false;
        //如果是根节点
        if(root.left == null && root.right == null){

            if(nodeVal == sum)
                return true;
            else
                return false;
        }

        if(root.left != null){

            leftBoolean = pathSum(root.left, sum - nodeVal);

        }

        if(root.right != null){

            rightBoolean = pathSum(root.right, sum - nodeVal);
        }

        return leftBoolean || rightBoolean;
    }

}
