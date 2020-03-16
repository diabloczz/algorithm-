package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:

输入: 

          1
         /  
        3    
       / \       
      5   3     

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
示例 3:

输入: 

          1
         / \
        3   2 
       /        
      5      

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
示例 4:

输入: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
注意: 答案在32位有符号整数的表示范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树最大宽度662 {
	
	/**
	 * 我们使每一个非空节点都有下标，左子树下标为2i，右节点下标为2i+1，其中i为上一层根节点的下标。
	 * 层次遍历每一层，用一个list不断从左往右添加元素的下标，等到该一层遍历结束时，该一层的宽度即为list首尾相减加一。
	 * 同时用一个局部变量保存当前最大宽度，每次遍历结束将该变量与当前层宽度比较取最大值。
	 * 
	 * @param root
	 * @return
	 */
	public int widthOfBinaryTree(TreeNode root) {
         List<Integer> rowList=new LinkedList<>();
     	if (root == null) return 0;		
 		Queue<TreeNode> queue = new LinkedList<>();
 		queue.offer(root);
 		rowList.add(1);//root的下标
 		int maxWidth=1;
 		while(!queue.isEmpty()) {
 			int levelSize=queue.size();
 			for(int i=0;i<levelSize;i++) {
 				int curr=rowList.get(0);
 				TreeNode node = queue.poll();
 				if(node.left!=null) {
 					queue.offer(node.left);
 					rowList.add(curr<<1);
 				}
 				if(node.right!=null) {
 					queue.offer(node.right);
 					rowList.add((curr<<1)+1);
 				}
 				rowList.remove(0);
 			}
 			//for循环结束也就代表一层遍历完，此时rowlist中的元素下标为该层下标从左到右，此时计算该层的宽度并与最大宽度作比较
 			if(rowList.size()>1) {
 				int currWidth=rowList.get(rowList.size()-1)-rowList.get(0)+1;
 	 			maxWidth=Math.max(maxWidth, currWidth);
 			}
 			
 		}
 		return maxWidth;
    }
}
