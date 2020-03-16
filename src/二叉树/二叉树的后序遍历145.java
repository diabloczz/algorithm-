package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树的后序遍历145 {
	/**
	 * 递归算法
	 * @param root
	 * @return
	 */
	 public List<Integer> postorderTraversal(TreeNode root) {
		 List<Integer> list=new ArrayList<>();
		 postorderTraversal(root,list);
         return list; 
	    }
	 
	 
	 public void postorderTraversal(TreeNode root,List<Integer> list) {
	        if(root!=null) {
	        	postorderTraversal(root.left,list);
	        	postorderTraversal(root.right,list);
	        	list.add(root.val);	
	        }
	    
	}
	 
	 
	 public List<Integer> postorderTraversal2(TreeNode root) {
		    LinkedList<TreeNode> stack = new LinkedList<>();
		    LinkedList<Integer> output = new LinkedList<>();
		    if (root == null) {
		      return output;
		    }

		    stack.add(root);
		    while (!stack.isEmpty()) {
		      TreeNode node = stack.pollLast();
		      output.addFirst(node.val);
		      if (node.left != null) {
		        stack.add(node.left);
		      }
		      if (node.right != null) {
		        stack.add(node.right);
		      }
		    }
		    return output;
		  }

	
}
