package qiaolf.newCoder;

import java.util.HashMap;

/**
 * @Description: 给定某二叉树的前序遍历和中序遍历，请重建出该二叉树并返回它的头结点。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
 *
 *
 * 提示:
 * 1.0 <= pre.length <= 2000
 * 2.vin.length == pre.length
 * 3.-10000 <= pre[i], vin[i] <= 10000
 * 4.pre 和 vin 均无重复元素
 * 5.vin出现的元素均出现在 pre里
 * 6.只需要返回根结点，系统会自动输出整颗树做答案对比
 * Author:qiaolf
 * @Date:2021/9/8 22:52
 **/
public class solution3 {

    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        for (int i = 0; i < vin.length; i++) {
            map.put(vin[i],i);
        }
        return myBuild(pre,vin,0,pre.length-1,0,vin.length-1);
    }

    public TreeNode myBuild(int[] pre,int[] vin,int pre_left,int pre_right,int vin_left,int vin_right){
        if (pre_left>pre_right){
            return null;
        }
        int root_index = pre_left;
        int root_value = pre[root_index];
        int root_index_vin = map.get(root_value);
        TreeNode root = new TreeNode(root_value);
        int size_left = root_index_vin - vin_left;
        root.left=myBuild(pre,vin,root_index+1,root_index+size_left,vin_left,vin_left+size_left-1);
        root.right=myBuild(pre,vin,root_index+size_left+1,pre_right,root_index_vin+1,vin_right);
        return root;
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
