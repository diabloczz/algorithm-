package 栈;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
通过次数10,998提交次数31,607

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 基本计算器二227 {
	/**
	 * 有了基本计算器224这一题的基础，这道题就非常简单了。
	 * 不需要考虑括号的优先级，只需要对加减乘除做优先级判断
	 * @param s
	 * @return
	 */
	 public static int calculate(String s) {
		  int len=s.length();
		List<String> numList=new LinkedList<>();
		  Stack<String> opeStack=new Stack<>();
		  String temp=null;
		  for(int i=0;i<len;i++) {
			  if(' '==s.charAt(i)) {
				 continue; 
			  }else if(Character.isDigit(s.charAt(i))) {
				  temp=temp==null?"":temp;
				  temp+=String.valueOf(s.charAt(i));
			  }else {
				  if(temp!=null) {
					  numList.add(temp);
					  temp=null;  
				  }
				  while(!compareP(opeStack,String.valueOf(s.charAt(i)))) {
					  numList.add(opeStack.pop());
				  }
				  opeStack.push(String.valueOf(s.charAt(i)));
			  }
		  }
		  if(temp!=null) {
			  numList.add(temp);
		  }
		  while(!opeStack.isEmpty()) {
			  numList.add(opeStack.pop()) ;
		  }
		  String[] tokens=new String[numList.size()];
		  numList.toArray(tokens);
		  System.out.println(Arrays.toString(tokens));
		  return evalRPN(tokens);
	    }
	 
	 
	 /**
	  * 用来判断当前运算符和栈顶运算符的优先级
	  * true表示当前操作符优先级高，可以入栈
	  * @param stack
	  * @param curr
	  * @return
	  */
	 public static boolean compareP(Stack<String> stack,String curr) {
		 if(stack.isEmpty()) {return true;}
//		 else if("+".equals(curr) || "-".equals(curr)) {return false;}
		 else if("*".equals(curr) || "/".equals(curr)) {
			 if("+".equals(stack.peek()) || "-".equals(stack.peek())) {return true;}
			 else {return false;}
		 }else {
			 return false;
		 }
	 }
	 
	 public static int evalRPN(String[] tokens) {
	        Stack<Integer> stack=new Stack<>();
	        int a,b,c=0;
	        for(int i=0;i<tokens.length;i++) {
	        	switch(tokens[i]) {
	        	case "+":
	        		a=stack.pop();
	        	    b=stack.pop();
	        	    c=b+a;
	        	    break;
	        	case "-":
	        		a=stack.pop();
	        	    b=stack.pop();
	        	    c=b-a;
	        	    break;
	        	case "*":
	        		a=stack.pop();
	        	    b=stack.pop();
	        	    c=b*a;
	        	    break;
	        	case "/":
	        		a=stack.pop();
	        	    b=stack.pop();
	        	    c=b/a;
	        	    break;
	        	default:
	        	    c=Integer.valueOf(tokens[i]);
	        	    break;
	        	}
	        	stack.push(c);
	        	
	        }
	        return stack.pop();
	    }
	 
	public static void main(String[] args) {
//		System.out.println(evalRPN(new String[]{"3","2","2","*","+"}));
		System.out.println(calculate(" 3+5 / 2 "));
	}
	 
}
