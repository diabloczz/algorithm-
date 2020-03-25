package 二叉树搜索树;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
通过次数9,676提交次数24,893

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 删除二叉搜索树中的节点450 {
	/**
	 * 迭代法
	 * 第一步找到该节点
	 * 第二步 删除该节点 
	 *    分别讨论该节点度为0，1，2的情况
	 *    如果度为2，则找到该节点的前驱结点，将原节点替换为前驱结点，并且删除前驱结点
	 * @param root
	 * @param key
	 * @return
	 */
	 public  static TreeNode deleteNode(TreeNode root, int key) {
		 if(root==null) return null;
         TreeNode node=root;//node是我们需要替换或删除的节点
         TreeNode parent=null;//parent为node的父节点，如果遍历完parent依旧是null，说明node是root节点
         while(node!=null) {
         	if(node.val<key) {
         		parent=node;
         		node=node.right;
         	}else if(node.val>key) {
         		parent=node;
         		node=node.left;
         	}else {
         		break;
         	}
         }
            if(node==null) return root;//说明整棵树没有该节点
            TreeNode replacement=null;
            if(node.left!=null && node.right!=null) {
            	//如果度为2，找到前驱结点，又因为二叉搜索树，所以前驱结点必在它的右子树中，right.left.left.left........不断往下找
            	TreeNode successor=node.right;
            	TreeNode successorPare=node;//前驱的父节点
        			while (successor.left != null) {
        				successorPare=successor;
        				successor = successor.left;
        			}
        	 node.val=successor.val;//当前节点的值替换为后继节点的值
        	 //删除后继节点
        	 replacement=successor.left!=null?successor.left:successor.right;
        	if(successor==successorPare.left){
        		successorPare.left=replacement;
             }else {
            	successorPare.right=replacement;
             }
        			
            }
            //处理度为0和1的情况
            else {
            	 replacement=node.left!=null?node.left:node.right;
            	 if(parent==null) {
            		 root=replacement;
            	 }
            	 else if(node==parent.left){
            		 parent.left=replacement;
                  }else {
                	  parent.right=replacement;
                  }
            }
        	return root;
	    }
	 /**
	  * 递归法
	  * @param root
	  * @param key
	  * @return
	  */
	 public   TreeNode deleteNode2(TreeNode root, int key) {
		 if(root==null) return null;
		 // delete from the right subtree
		    if (key > root.val) root.right = deleteNode(root.right, key);
		    // delete from the left subtree
		    else if (key < root.val) root.left = deleteNode(root.left, key);
		    // delete the current node
		    else {
		      // the node is a leaf
		      if (root.left == null && root.right == null) root = null;
		      // the node is not a leaf and has a right child
		      else if (root.right != null) {
		        root.val = successor(root);
		        root.right = deleteNode(root.right, root.val);
		      }
		      // the node is not a leaf, has no right child, and has a left child    
		      else {
		        root.val = predecessor(root);
		        root.left = deleteNode(root.left, root.val);
		      }
		    }
		 return root;
	 }
	
	 
	 public static int successor(TreeNode root) {
		    root = root.right;
		    while (root.left != null) root = root.left;
		    return root.val;
		  }

		  /*
		  One step left and then always right
		  */
	 public static int predecessor(TreeNode root) {
		    root = root.left;
		    while (root.right != null) root = root.right;
		    return root.val;
		  }
	 
		public static void main(String[] args) {
			TreeNode root=new TreeNode(5);
			root.left=new TreeNode(3);
			root.right=new TreeNode(6);
			root.left.left=new TreeNode(2);
			root.left.right=new TreeNode(4);
			root.right.right=new TreeNode(7);
			deleteNode(root,3);
			
			TreeNode a=new TreeNode(100);
			TreeNode aa=a;
			System.out.println(a==aa);
			a.left=new TreeNode(99);
			a.right=new TreeNode(101);
//			a.left=null;
//			a.right=null;
		a.left.left=new TreeNode(77);
		a.left.right=new TreeNode(88);
		TreeNode c=a.left.left;
		c=null;
//		c.left=null;c.right=null;
		}
}
