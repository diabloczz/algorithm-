package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树的层次遍历II107 {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 List<List<Integer>> all=new LinkedList<>();
         List<Integer> rowList=new LinkedList<>();
     	if (root == null) return all;
 		
 		Queue<TreeNode> lastLevel = new LinkedList<>();
 		Queue<TreeNode> curr = new LinkedList<>();
 		lastLevel.offer(root);
 		while(!lastLevel.isEmpty()|| !curr.isEmpty()) {
 			while (!lastLevel.isEmpty()) {
     			TreeNode node = lastLevel.poll();
     			rowList.add(node.val);
     			
     			if (node.left != null) {
     				curr.offer(node.left);
     			}
     			
     			if (node.right != null) {
     				curr.offer(node.right);
     			}
     		}
     		all.add(0, rowList);
     		lastLevel=curr;
     		curr=new LinkedList<>();
     		rowList=new LinkedList<>();
 		}
 		
         return all;
	    }
}
