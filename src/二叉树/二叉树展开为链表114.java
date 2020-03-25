package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树展开为链表114 {
	/**
	 * 前序遍历，对每一个节点，把左子树变成null，右子树变成栈中下一个节点，循环到栈空为止
	 * @param root
	 */
	 public static void flatten(TreeNode root) {
	        Stack<TreeNode> stack=new Stack<>();
	        if(root==null) return ;
	        stack.push(root);
	        while(!stack.isEmpty()) {
	        	TreeNode node=stack.pop();
	        	  if(node.right!=null) {
	        		  stack.push(node.right);  
	        	  } 
	        	  if(node.left!=null) {
	        		  stack.push(node.left);  
	        	  }      
	        	  node.left=null;
	        	  if(!stack.isEmpty()) { node.right=stack.peek();}
	        	  else {node.right=null;}
	        }
	    }
	 
	 
	 public static  void flattenVisit(TreeNode root) {
		 if(root==null) return;
		 while(root.right!=null) {
			 if(root.left!=null) System.out.println("左边不为null："+root.left);
			 System.out.println(root.right);
			 root=root.right;
		 }
	 }
	 
	 public static void main(String[] args) {
		
	}
}
