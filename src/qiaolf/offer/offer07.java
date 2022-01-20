package qiaolf.offer;

/**
 * @Description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Author:qiaolf
 * @Date:2021/8/11 22:27
 **/

import java.util.HashMap;
import java.util.Map;

/**
 *                                  3
 *                            [9]      20
 *                                  [15]  [7]
 *
 *
 */
public class offer07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Map<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length!=inorder.length){
            return null;
        }
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return myProcess(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode myProcess(int[] preorder, int[] inorder, int pre_left, int pre_right,int in_left, int in_Right) {
        if (pre_left>pre_right){
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int root_index=pre_left;
        int in_root_index = indexMap.get(preorder[root_index]);//找出中序遍历的根节点

        TreeNode root = new TreeNode(inorder[in_root_index]);
        int size_left = in_root_index - in_left;
        int size_right = in_Right - in_root_index;
        root.left = myProcess(preorder,inorder,root_index+1,root_index+size_left,in_left,in_root_index-1);
        root.right = myProcess(preorder,inorder,root_index+size_left+1,pre_right,in_root_index+1,in_Right);
        return root;
    }

}




