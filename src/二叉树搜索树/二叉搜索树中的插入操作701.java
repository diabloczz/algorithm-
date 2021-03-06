package 二叉树搜索树;
/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

例如, 

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和 插入的值: 5
你可以返回这个二叉搜索树:

         4
       /   \
      2     7
     / \   /
    1   3 5
或者这个树也是有效的:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
通过次数8,729提交次数11,991

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 二叉搜索树中的插入操作701 {
	 public TreeNode insertIntoBST(TreeNode root, int val) {
		 //如果root为null说明二叉树为空，此时新建一个值为val的root节点即可
		  if(root==null) return new TreeNode(val);
		  //比较val与每个元素的大小决定插在哪，即找出所对应的parent节点，如果节点val相同直接覆盖即可
		  TreeNode parent=root;
		  TreeNode node=root;
	
		  while(node!=null ) {
			  parent=node;
			  if(val-parent.val>0) {
				  node=node.right;
			  }else if(val-parent.val<0) {
				  node=node.left;
			  }else {
				  return root;
			  }
		  }
		  if(val-parent.val<0) {
			  parent.left=new  TreeNode(val);
		  }else {
			  parent.right=new  TreeNode(val);
		  }
		  return root;
	    }
}
