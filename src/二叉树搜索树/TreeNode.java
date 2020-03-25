package 二叉树搜索树;

import com.mj.printer.BinaryTreeInfo;

public class TreeNode implements BinaryTreeInfo{
	int val;
	    TreeNode left;
	    TreeNode right;
    TreeNode(int x) { val = x; }
    
	@Override
	public String toString() {
		return val+"";
	}

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object left(Object node) {
		return left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		return val+"";
	}
    
}
