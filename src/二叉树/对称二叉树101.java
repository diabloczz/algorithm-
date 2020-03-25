package 二叉树;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 对称二叉树101 {
	/**
	 * 递归法
	 * @param root
	 * @return
	 */
	 public boolean isSymmetric(TreeNode root) {
		 //空二叉树被认为是对称的
            if(root==null) return true;
            return helper(root.left,root.right);
	    }
	 
	 public boolean helper(TreeNode left,TreeNode right) {
		 //这里明确递归的终止条件：一方为null，即可判断出结果；否则意味着都不为null，如果两者val不相等，不对称，不然需要比较左右节点的左右子节点是否镜像对称，直到树的底部
              if(left==null || right==null) {return left==right;}
              //两个都不为null的情况下，需要对两者本身以及两者的左右子节点进行比较
              if(left.val!=right.val) return false;
              return helper(left.right,right.left) && helper(left.left,right.right);
              
              
	    }
	 
	 /**
	  * 迭代法，用两个栈分别对元素入栈，一一取出做对比
	  * @param root
	  * @return
	  */
	 public boolean isSymmetric2(TreeNode root) {
		 //空二叉树被认为是对称的
            if(root==null) return true;
            if(root.left==null || root.right==null) return root.left== root.right;
           Stack<TreeNode> left=new Stack<>();
           Stack<TreeNode> right=new Stack<>();
           left.push(root.left);
           right.push(root.right);
           while(!left.isEmpty()) {
        	   TreeNode leftpop = left.pop();
        	   TreeNode rightpop = right.pop();
        	   if(leftpop==null || rightpop==null) {
        		   if(leftpop!=rightpop) { return false;}
        		   else {continue;}
        	   };
        	  
        	   if(leftpop.val!=rightpop.val) return false;
        	   //左节点先左后右，右节点先右后左的顺序入栈
        		   left.push(leftpop.left);      	  
        		   left.push(leftpop.right);
        		   right.push(rightpop.right);
        		   right.push(rightpop.left);
           }
           return true;
	    }
	 
	 
	 public static void main(String[] args) {
		 Stack<TreeNode> left=new Stack<>();
		 left.push(null);
		 left.push(null);
		 System.out.println(left);
		 TreeNode pop=left.pop();
		 System.out.println(pop);
		 System.out.println(left.size());
	}
}
