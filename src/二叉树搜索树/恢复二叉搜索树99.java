package 二叉树搜索树;

import java.util.Stack;

/**
 * 二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
进阶:

使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？
通过次数13,065提交次数23,467

https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @author Administrator
 *
 */
public class 恢复二叉搜索树99 {
	
	 public void recoverTree(TreeNode root) {
		 Stack < TreeNode > stack = new Stack < > ();
	        TreeNode curr = root;
	        TreeNode last = null;
	        TreeNode a = null;
	        TreeNode b = null;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            if(last!=null && last.val>curr.val) {
	            	b=curr;
	            	if(a==null) a=last;
	            	else {
	         	        break;
	            	}
	            }
	            last=curr;
	            curr = curr.right;
	        }
	        int temp=a.val;
 	        a.val=b.val;
 	        b.val=temp;
	    }
}
