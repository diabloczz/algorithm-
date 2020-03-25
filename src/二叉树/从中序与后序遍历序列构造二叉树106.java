package 二叉树;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
通过次数27,447提交次数40,821

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 从中序与后序遍历序列构造二叉树106 {
	 public static TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(inorder.length==0 || postorder.length==0) return null;
         TreeNode root=new TreeNode(postorder[postorder.length-1]);
         int inRootIndex=0;
         for(int i=0;i<inorder.length;i++) {
      	   if(inorder[i]==postorder[postorder.length-1]) {
      		   inRootIndex=i;
      		   break;
      	   }
         }
         int[] leftInList=Arrays.copyOfRange(inorder, 0, inRootIndex);
         int[] rightInList=Arrays.copyOfRange(inorder, inRootIndex+1, inorder.length);
         int[] leftPostList=Arrays.copyOfRange(postorder, 0, leftInList.length);
         int[] rightPostList=Arrays.copyOfRange(postorder,leftPostList.length, postorder.length-1);
         root.left=buildTree(leftInList,leftPostList);
         root.right=buildTree(rightInList,rightPostList);
         return root;
	    }
	 public static void main(String[] args) {
		
			int [] a=new int[] {9,3,15,20,7};
			 int [] b=new int[] {9,15,7,20,3};
			 buildTree(a,b) ;
	}
}
