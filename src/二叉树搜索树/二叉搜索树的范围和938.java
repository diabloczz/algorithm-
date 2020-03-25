package 二叉树搜索树;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

二叉搜索树保证具有唯一的值。

 https://leetcode-cn.com/problems/range-sum-of-bst/

示例 1：

输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
输出：32
示例 2：

输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
输出：23
 

提示：

树中的结点数量最多为 10000 个。
最终的答案保证小于 2^31。
 * @author Administrator
 *
 */
public class 二叉搜索树的范围和938 {
	public int range=0;
	public int left=0;
	public int right=0;
	 public int rangeSumBST(TreeNode root, int L, int R) {
            if(root==null) return  range;
            this.left=L;
            this.right=R;
            inorderTraversal(root);
            return range;
	    }
	 
	 
	 public void inorderTraversal(TreeNode root) {
		  if(root!=null) {	
	        	inorderTraversal(root.left);
	        	if(root.val>=left && root.val<=right) {
	        		range+=root.val;
	        	}
	        	inorderTraversal(root.right);
	        }
	    }
	 
	 
}
