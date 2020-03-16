package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree

 * @author Administrator
 *
 */
public class 翻转二叉树226 {

	/**
	 * 且不考虑递归，将每个节点遍历到，然后互换这个节点的左右子节点，这里采用的是层序遍历
	 * @param root
	 * @return
	 */
	 public TreeNode invertTree(TreeNode root) {
		 Queue<TreeNode> queue=new LinkedList<>();
		 if(root!=null)
		  queue.offer(root);
		 while(!queue.isEmpty()) {
			 TreeNode head = queue.poll();
			 TreeNode temp=head.left;
			 head.left=head.right;
			 head.right=temp;
			 if(head.left!=null) {
				 queue.offer(head.left);
			 }
			 if(head.right!=null) {
				 queue.offer(head.right);
			 }
		 }
		 return root;
	    }
}
