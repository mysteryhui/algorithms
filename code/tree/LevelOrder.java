package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/8
 * @Description:
 */
public class LevelOrder {


    /**
     * 借助queue来实现广度遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return lists;

        queue.offer(root);

        while(!queue.isEmpty()){

            //表示某层的节点数
            int levelSize = queue.size();

            List<Integer> subList = new LinkedList<>();

            for(int i=0;i < levelSize;i++){

                //把栈顶元素的左右子节点放入队列中
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                subList.add(queue.poll().val);
            }

            lists.add(subList);

        }

        return lists;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return lists;

        queue.offer(root);

        while(!queue.isEmpty()){

            //表示某层的节点数
            int levelSize = queue.size();

            List<Integer> subList = new LinkedList<>();

            for(int i=0;i < levelSize;i++){

                //把栈顶元素的左右子节点放入队列中
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                subList.add(queue.poll().val);
            }

            lists.offerFirst(subList);

        }

        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return lists;

        queue.offer(root);

        for (int i=1;!queue.isEmpty();i++){

            int levelNum = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();

            for(int j=0;j< levelNum;j++){

                if(i%2 == 0){

                    if(queue.peek().left != null)
                        queue.offer(queue.peek().left);

                    if(queue.peek().right != null)
                        queue.offer(queue.peek().right);

                }else{

                    if(queue.peek().right != null)
                        queue.offer(queue.peek().right);

                    if(queue.peek().left != null)
                        queue.offer(queue.peek().left);
                }

                subList.offer(queue.poll().val);

            }

            lists.offer(subList);

        }

        return lists;

    }


}
