package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
通过次数50,199提交次数77,786

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 从前序与中序遍历序列构造二叉树105 {
	/**
	 * 自己第一遍用递归实现的，不断的从给定的preorder，inorder中得到左子树和右子树的前序和中序排列，求得根节点，直到根节点为null(数组为0)，但是用了太多api，效率不高
	 * 	559 ms	289.5 MB 分别打败了5%的人
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		 List<Integer> preList= Arrays.stream( preorder ).boxed().collect(Collectors.toList());
		 List<Integer> inList= Arrays.stream( inorder ).boxed().collect(Collectors.toList());
		 if(preList.size()==0 || inList.size()==0) return null;
               TreeNode root=new TreeNode(preorder[0]);
               int inRootIndex=inList.indexOf(preorder[0]);//中序遍历中根节点的索引
               List<Integer> leftInList=inList.subList(0,inRootIndex );//左子树的中序排列
               List<Integer> rightInList=inList.subList(inRootIndex+1,inList.size() );//右左子树的中序排列
               List<Integer> leftPreList =preList.subList(1, 1+leftInList.size());//左子树的前序排列
               List<Integer> rightPreList =preList.subList(1+leftInList.size(),preList.size() );//右左子树的前序排列
            
               root.left=buildTree(leftPreList.stream()
					   .mapToInt(Integer::intValue)
					   .toArray(),leftInList.stream()
					   .mapToInt(Integer::intValue)
					   .toArray());
               root.right=buildTree(rightPreList.stream()
					   .mapToInt(Integer::intValue)
					   .toArray(),rightInList.stream()
					   .mapToInt(Integer::intValue)
					   .toArray());
               return root;
	    }
	 
	 /**
	  * 思路不变，尝试用更少的api或者更底层的api来实现
	  * 执行用时 :
13 ms
, 在所有 Java 提交中击败了
36.49%
的用户
内存消耗 :
41.7 MB
, 在所有 Java 提交中击败了
42.49%
的用户
	  * @param preorder
	  * @param inorder
	  * @return
	  */
	 public TreeNode buildTree2(int[] preorder, int[] inorder) {
		 if(preorder.length==0 || inorder.length==0) return null;
               TreeNode root=new TreeNode(preorder[0]);
               int inRootIndex=0;
               for(int i=0;i<inorder.length;i++) {
            	   if(inorder[i]==preorder[0]) {
            		   inRootIndex=i;
            		   break;
            	   }
               }
               int[] leftInList=Arrays.copyOfRange(inorder, 0, inRootIndex);
               int[] rightInList=Arrays.copyOfRange(inorder, inRootIndex+1, inorder.length);
               int[] leftPreList=Arrays.copyOfRange(preorder, 1, 1+leftInList.length);
               int[] rightPreList=Arrays.copyOfRange(preorder, 1+leftInList.length, preorder.length);
               root.left=buildTree2(leftPreList,leftInList);
               root.right=buildTree2(rightPreList,rightInList);
               return root;
	    }
	 
	 public static void main(String[] args) {
		int [] a=new int[] {3,9,20,15,7};
		int [] b=new int[] {9,3,15,20,7};
		 List<Integer> preList= Arrays.stream( a ).boxed().collect(Collectors.toList());
		 List<Integer> inList= Arrays.stream( b ).boxed().collect(Collectors.toList());
               int inRootIndex=inList.indexOf(a[0]);//中序遍历中根节点的索引
               List<Integer> leftInList=inList.subList(0,inRootIndex );//左子树的中序排列
               System.out.println(leftInList);
               List<Integer> rightInList=inList.subList(inRootIndex+1,inList.size() );//右左子树的中序排列
               System.out.println(rightInList);
               List<Integer> leftPreList =preList.subList(1, 1+leftInList.size());//左子树的前序排列
               System.out.println(leftPreList);
               List<Integer> rightPreList =preList.subList(1+leftInList.size(),preList.size() );//右左子树的前序排列
               System.out.println(rightPreList);
               Integer[] array = leftPreList.toArray(new Integer[2]);
	}
}
