package qiaolf.leetcode.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 树的最大深度
 * Author:qiaolf
 * @Date:2021/9/28 23:15
 **/
public class solution104 {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                size--;
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            level++;
        }
        return level;

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
