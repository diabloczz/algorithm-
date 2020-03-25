package 二叉树搜索树;

import java.util.Arrays;

import com.mj.printer.BinaryTreeInfo;
import com.mj.printer.BinaryTrees;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
通过次数55,099提交次数78,953
 * @author Administrator
 *
 */
public class 将有序数组转换为二叉搜索树108 {
	/**
	 * 递归
	 * @param nums
	 * @return
	 */
	 public  static TreeNode sortedArrayToBST(int[] nums) {
		 if(nums.length>2) {
	         	int nodeVal=nums[nums.length>>1];
	       	    TreeNode node=new TreeNode(nodeVal);
	         	node.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length>>1));
	         	node.right=sortedArrayToBST(Arrays.copyOfRange(nums,(nums.length>>1)+1,nums.length));
	         	return node;
	         }else if(nums.length>=1) {
	        	TreeNode node=new TreeNode(nums[nums.length-1]);
	         	node.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length-1));
	         	return node;
	         }else {
	        	 return null;
	         }
	    }
	 
	 
	 int[] nums;

	  public TreeNode helper(int left, int right) {
	    if (left > right) return null;

	    // always choose left middle node as a root
	    int p = (left + right) / 2;

	    // inorder traversal: left -> node -> right
	    TreeNode root = new TreeNode(nums[p]);
	    root.left = helper(left, p - 1);
	    root.right = helper(p + 1, right);
	    return root;
	  }

	  public TreeNode sortedArrayToBST2(int[] nums) {
	    this.nums = nums;
	    return helper(0, nums.length - 1);
	  }
	
}
