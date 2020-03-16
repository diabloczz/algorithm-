package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉树的最大深度104 {
	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
         if(root==null) return 0;
         return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
	
	public int maxDepth2(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		int height=0;
		int levelSize=1;//当前一层元素数量
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			levelSize--;
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
			//每当这一层元素全出队时，height++
			if(levelSize==0) {
				levelSize=queue.size();
				height++;
			}
		}
		return height;
   }
	
}
