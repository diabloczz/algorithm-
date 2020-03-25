package 二叉树搜索树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 

提示：

树中至少有 2 个节点。
本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
通过次数10,952提交次数19,611
https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * @author Administrator
 *
 */
public class 二叉搜索树的最小绝对差530 {
	//树至少有两个节点所以有些条件可以不判断
	/**
	 * 迭代法
	 * @param root
	 * @return
	 */
	 public int getMinimumDifference(TreeNode root) {
		 List < Integer > res = new ArrayList < > ();
		 int min=0;
	        Stack < TreeNode > stack = new Stack < > ();
	        TreeNode curr = root;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            res.add(curr.val);
	            curr = curr.right;
	            if(res.size()>1) {
	            	int absolute=Math.abs(res.get(res.size()-1)-res.get(res.size()-2));
	            	min=min==0?absolute:Math.min(min, absolute);
	            }
	        }
	        return min;
	    }
	 
	 /**
	  * 递归法
	  * @param root
	  * @return
	  */
	 
	 TreeNode pre=null;
	 int lastAbs=Integer.MAX_VALUE;
	 public int getMinimumDifference2(TreeNode root) {
		    helper(root);
	        return lastAbs;
	    }
	 
	 public void helper(TreeNode root) {
		 if(root==null) return ;
		 helper(root.left);
		 if(pre!=null) {
			 lastAbs= Math.min(lastAbs, Math.abs(root.val-pre.val));
		 }
		 pre=root;
		 helper(root.right);
	 }
	 
	 
}
