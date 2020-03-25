package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

返回其后序遍历: [5,6,3,2,4,1].

 

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class N叉树的后序遍历590 {
	/**
	 * 递归法
	 * @param root
	 * @return
	 */
	 public List<Integer> postorder(Node root) {
		 List<Integer> list=new ArrayList<>();
		 postorder(root,list);
         return list;
	    }
	 
	 
	 public void postorder(Node root,List<Integer> list) {
		 if(root!=null) {
		      
		       for(Node node:root.children) {
		    	   postorder(node,list);
		       }
		    	list.add(root.val);
	    }
}
	 /**
	  * 迭代法
	  * @param root
	  * @return
	  */
	 public List<Integer> postorder2(Node root) {
		 Stack<Node> stack = new Stack<>();
		    LinkedList<Integer> output = new LinkedList<>();
		    if (root == null) {
		      return output;
		    }
		    Node lastNode=root;//记录上一次访问的节点
		    stack.push(root);
		    while (!stack.isEmpty()) {
		    	Node node=stack.peek();
		      if(isChild(lastNode,node) || isLeaf(node)) {
		    	  lastNode=stack.pop();
		    	  output.add(lastNode.val);
		      }else {
		    	 Collections.reverse(node.children);
		    	 for(Node cld:node.children) {
		    		 stack.push(cld);
		    	 }
		      }
		  }
		    return  output;
	    } 
	 
	 public static boolean isLeaf(Node node) {
			return node.children == null ||  node.children.isEmpty();
		}
	 
	 public static boolean isChild(Node child,Node father) {
			return father.children.contains(child);
		}
}