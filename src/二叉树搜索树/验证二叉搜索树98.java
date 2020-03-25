package 二叉树搜索树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
     
     https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author Administrator
 *
 */
public class 验证二叉搜索树98 {
	/**
	 * 算法一：利用二叉搜索树的性质，中序遍历为升序
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		List<Integer> list=inOrder(root);
		if(!list.isEmpty()) {
			for(int i=0;i<list.size()-1;i++) {
				if(list.get(i)>=list.get(i+1)) {
					return false;
				}
			}
		}
		return true;
    }
	
	public List<Integer> inOrder(TreeNode root) {
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
	
	/**
	 * 算法二：利用二叉搜索树的性质，中序遍历为升序
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
		List<Integer> list=inOrder(root);
		if(!list.isEmpty()) {
			for(int i=0;i<list.size()-1;i++) {
				if(list.get(i)>=list.get(i+1)) {
					return false;
				}
			}
		}
		return true;
    }
	
	
}
