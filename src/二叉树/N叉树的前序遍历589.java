package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :


返回其前序遍历: [1,3,5,6,2,4]。

 

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class N叉树的前序遍历589 {
	/**
	 * 递归法
	 * @param root
	 * @return
	 */
   public List<Integer> preorder(Node root) {
	   List<Integer> list=new ArrayList<>();
	   preorder(root,list);
       return list;
    }
   
   
   public void preorder(Node root,List<Integer> list) {
       if(root!=null) {
       	list.add(root.val);
       for(Node node:root.children) {
    	   preorder(node,list);
       }
       }
 }
   
   /**
    * 迭代法
    * @param root
    * @param list
    */
   public List<Integer> preorder2(Node root) {
	   List<Integer> list=new ArrayList<>();
	   if(root==null) return list;
	   //n叉树，前序遍历节点是先根节点，子节点从左往右，所以入栈的时候从右往左入
	   Stack<Node> stack=new Stack<>();
	   stack.push(root);
	   while(!stack.isEmpty()) {
		  Node node=stack.pop();
		  list.add(node.val);
		  Collections.reverse(node.children);
		  for(Node cld:node.children) {
			  stack.push(cld);
		  }
		  
	   }
       return list;
    }
}