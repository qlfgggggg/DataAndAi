package qiaolf.newCoder;

import java.util.ArrayList;

/**
 * @Description: 二叉树的中序遍历
 * 给定一个二叉树的根节点root，返回它的中序遍历。
 * Author:qiaolf
 * @Date:2021/9/8 23:21
 **/
public class Solution4 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        in(root,list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public void in(TreeNode node,ArrayList<Integer> list){
        if (node==null){
            return;
        }
        if (node.left!=null){
            in(node.left,list);
        }
        list.add(node.val);
        if (node.right!=null){
            in(node.right,list);
        }
    }


}
