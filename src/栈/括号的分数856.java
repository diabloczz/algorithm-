package 栈;

import java.util.Stack;

/**
 * 
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

() 得 1 分。
AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
(A) 得 2 * A 分，其中 A 是平衡括号字符串。
 

示例 1：

输入： "()"
输出： 1
示例 2：

输入： "(())"
输出： 2
示例 3：

输入： "()()"
输出： 2
示例 4：

输入： "(()(()))"
输出： 6
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/score-of-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 括号的分数856 {
	/**
	 * 
	 * @param S
	 * @return
	 */
	 public static int scoreOfParentheses(String S) {
          Stack<Integer> stack=new Stack<>();
          int len=S.length();
          stack.push(0);
          for(int i=0;i<len;i++) {
        	  char c=S.charAt(i);
        	  if(c=='(') {
        		  stack.push(0);
        	  }else {
        		  if(S.charAt(i-1)=='(') {
        			  stack.pop();
        			  int b=stack.pop();
        			  stack.push(b+1);
        		  }else {
        			  int a=stack.pop();
        			  int b=stack.pop();
        			  stack.push(b+2*a);
        		  }
        	  }
          }
          return stack.pop();
	    }
	 public static void main(String[] args) {
		
		 System.out.println(scoreOfParentheses("(()(()))"));
		 System.out.println(scoreOfParentheses("()()"));
	}
}
