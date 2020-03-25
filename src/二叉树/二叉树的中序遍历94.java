package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树的中序遍历94 {
	 public List<Integer> inorderTraversal(TreeNode root) {
		  List<Integer> list=new ArrayList<>();
		  inorderTraversal(root,list);
          return list;
	    }
	 
	 
	 public void inorderTraversal(TreeNode root,List<Integer> list) {
		  if(root!=null) {	
	        	inorderTraversal(root.left,list);
	        	list.add(root.val);
	        	inorderTraversal(root.right,list);
	        }
	    }
	
	 /**
	  * 迭代法
	  * @param root
	  * @return
	  */
	 public List<Integer> inorderTraversal2(TreeNode root) {
		 List < Integer > res = new ArrayList < > ();
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
	        }
	        return res;
	    }
	 
	 
	
}
