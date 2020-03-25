package 二叉树;

import java.util.Arrays;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。

 pre 和 post 遍历中的值是不同的正整数。

 

示例：

输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]
 

提示：

1 <= pre.length == post.length <= 30
pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
通过次数3,485提交次数5,569

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 根据前序和后序遍历构造二叉树889 {
	/**
	 * 本题的难点在于这颗二叉树的不确定性。当我们只拥有前序和后序遍历时，除非这棵二叉树是真二叉树，否则不能唯一确定。
	 * 因为如果只有左或右子树，我们在得知了根节点后，无法判断剩余部分是左还是右。
	 * 好在题目要求给出满足的一种情况即可，那我们假定这种单边缺失的情况都发生在右半边。
	 * 我们令左分支有 L 个节点。我们知道左分支的头节点为 pre[1]，但它也出现在左分支的后序表示的最后。
	 * 所以 pre[1] = post[L-1]（因为结点的值具有唯一性），因此 L = post.indexOf(pre[1]) + 1。
	 * @param pre
	 * @param post
	 * @return
	 */
	public static TreeNode constructFromPrePost(int[] pre, int[] post) {
		if(pre.length==0 || post.length==0) return null;	
        TreeNode root=new TreeNode(pre[0]);
        if(pre.length==1 || post.length==1) return root;
        //假设左节点长度为leftLength
        int leftLength=0;
        for(int i=0;i<post.length;i++) {
        	if(post[i]==pre[1]) {
        		//计算出此时左节点长度
        		leftLength=i+1;
        	}
        }
        int[] leftPreList=Arrays.copyOfRange(pre, 1, 1+leftLength);
        int[] rightPreList=Arrays.copyOfRange( pre,1+leftLength,pre.length);
        int[] leftPostList=Arrays.copyOfRange(post, 0, leftLength);
        int[] rightPostList=Arrays.copyOfRange(post,leftLength,post.length-1);
        root.left=constructFromPrePost(leftPreList,leftPostList);
        root.right=constructFromPrePost(rightPreList,rightPostList);
        return root;
    }
	
	public static void main(String[] args) {
		int[] a= {1,2,4,5,3,6,7};
		int[] b= {4,5,2,6,7,3,1};
		constructFromPrePost(a,b);
		
	}
}
