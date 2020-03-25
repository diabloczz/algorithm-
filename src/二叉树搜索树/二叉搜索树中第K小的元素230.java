package 二叉树搜索树;

import java.util.List;
import java.util.Stack;


/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * @author Administrator
 *
 */
public class 二叉搜索树中第K小的元素230 {
	public int count=0;
	 public int kthSmallest(TreeNode root, int k) {
		 TreeNode curr = root;
		  Stack < TreeNode > stack = new Stack < > ();
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            count++;
	            if(count==k) return curr.val;
	            curr = curr.right;
	        }
	        return curr.val;
	    }
	 
	
}
