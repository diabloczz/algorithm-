package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author Administrator
 *
 */
public class 二叉树的层次遍历102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
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
        		all.add(rowList);
        		lastLevel=curr;
        		curr=new LinkedList<>();
        		rowList=new LinkedList<>();
    		}
    		
            return all;
    }
}
