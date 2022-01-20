package qiaolf.newCoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 题目：把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 例如：
 * 给定的二叉树是{1,2,3,#,#,4,5}
 *
 * 该二叉树多行打印层序遍历的结果是
 * [
 * [1],
 * [2,3],
 * [4,5]
 * ]
 * Author:qiaolf
 * @Date:2021/9/8 22:38
 **/
public class solution2 {


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size>0){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
            arrayLists.add(list);
        }
        return arrayLists;

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
