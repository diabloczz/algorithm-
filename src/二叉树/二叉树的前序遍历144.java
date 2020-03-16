package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.mj.printer.BinaryTrees;

/**
 * 给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树的前序遍历144 {
	
	/**
	 * 递归法
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list=new ArrayList<>();
            preorderTraversal(root,list);
            return list;
    }
	
	public void preorderTraversal(TreeNode root,List<Integer> list) {
        if(root!=null) {
        	list.add(root.val);
        	preorderTraversal(root.left,list);
        	preorderTraversal(root.right,list);
        }
    
}
	  /**
	   * 迭代法
	   * @param root
	   * @return
	   */
	public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return list;
        while(root!=null) {
        	  list.add(root.val);
        	  if(root.right!=null) {
        		  stack.push(root.right);  
        	  }        
        	  root=root.left;
        	  if(root==null && !stack.isEmpty()) root=stack.pop();
        }
        return list;
}
	
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst=new BinarySearchTree<>();
		bst.add(3);
		bst.add(1);
		bst.add(2);
		BinaryTrees.println(bst);
	}
}
