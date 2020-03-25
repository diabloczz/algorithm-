package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
	 
	 
	 /**
	  * 首先将根节点入栈，压入顺序先压根节点，再压根节点的right，再压left
	  * 栈顶元素我们先判断是否符合弹出条件，如果符合就弹出，不符合就继续上一步操作
	  * 判断弹出条件条件：当前栈顶节点是叶子节点，那就弹出并访问；或者上一个访问的节点是栈顶节点的子节点（因为已经入栈过的元素不许重复入栈），弹出访问
	  * @param root
	  * @return
	  */
	 public static List<Integer> postorderTraversal2(TreeNode root) {
		     Stack<TreeNode> stack = new Stack<>();
		    LinkedList<Integer> output = new LinkedList<>();
		    if (root == null) {
		      return output;
		    }
		    TreeNode lastNode=root;//记录上一次访问的节点
		    stack.push(root);
		    while (!stack.isEmpty()) {
		      TreeNode node=stack.peek();
		      System.out.println(isChild(lastNode,node));
		      System.out.println(isLeaf(node));
		      if(isChild(lastNode,node) || isLeaf(node)) {
		    	  lastNode=stack.pop();
		    	  output.add(lastNode.val);
		      }else {
		    	  if(node.right!=null)
		    	    stack.push(node.right);
		    	  if(node.left!=null)
		    	  stack.push(node.left);
		      }
		  }
		    return  output;
    }
	 
	 public static boolean isLeaf(TreeNode node) {
			return node.left == null && node.right == null;
		}
	 
	 public static boolean isChild(TreeNode child,TreeNode father) {
			return father.left == child || father.right == child;
		}
	 
	 public static void main(String[] args) {
		TreeNode first=new TreeNode(1);
		first.left=null;
		TreeNode second=new TreeNode(2);
		first.right=second;
		second.left=new TreeNode(3);
		System.out.println(postorderTraversal2(first));
	}
}
