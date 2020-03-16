package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * https://leetcode-cn.com/problems/basic-calculator/
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

示例 1:

输入: "1 + 1"
输出: 2
示例 2:

输入: " 2-1 + 2 "
输出: 3
示例 3:

输入: "(1+(4+5+2)-3)+(6+8)"
输出: 23
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 基本计算器224 {
	/**
	 * 分为两步，第一步将中缀表达式转化为后缀表达式，第二步将后缀表达式用栈运算得出结果
	 * 其中第一步，可以利用两个栈，一个存放数字，另一个存放操作符号，包括左括号
	 * 由于只有加减，没有乘除，所以优先级只根据括号决定
	 *     操作数可以有多位数，因此字符串中取出每一个数字的操作是：如果某一位是数字，则一直取，到是符号为止。给一个临时变量用来存储拼接的数字
	 * 大致过程如下：
	 *   扫描每个字符，数字则入栈一，符号则入栈二（右括号可以不入，因为右括号可以在入栈条件中体现）。
	 *   其中符号入栈的时候要考虑运算优先级，乘除》加减，同一等级的运算，后入的《前入的。如果当前扫描字符的优先级低于栈顶元素，则栈顶元素先出栈压入栈一，
	 *   直到优先级高于栈顶元素或者遇到一个左括号，此时该符号入栈，
	 *   如果扫描的字符是右括号，则之前一定有一个左括号对应，将栈二的操作符依次出栈添加到栈一中，直到遇到一个左括号停止。
	 *   字符全部扫描完成后，栈二元素依次出栈添加到栈一中，再将栈一元素依次出栈向左拼接即可得到后缀表达式
	 *   
	 *   补：我上面这种思路没错，但是恶心的是他会给1-11这种，转化成中缀111-，鬼知道是什么东西。。所以
	 * @param s
	 * @return
	 */
	 public static int calculate(String s) {
		  int len=s.length();
		  Stack<String> numStack=new Stack<>();
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
					  numStack.push(temp);
					  temp=null;  
				  }
				  if(')'==s.charAt(i)) {
					 while(!"(".equals(opeStack.lastElement())) {
						 numStack.push(opeStack.pop()) ;
					 }
					 opeStack.pop();
				  }else if('('==s.charAt(i)){opeStack.push(String.valueOf(s.charAt(i))); }
				  else {
					  //因为这里后入的操作符优先级肯定比栈顶的要低，左括号除外，所以符号要先出栈压入栈一直到满足条件，当前扫描的符号再进栈
					  while(!opeStack.isEmpty() && !"(".equals(opeStack.lastElement())) {
						  numStack.push(opeStack.pop()) ;
					  }
					  opeStack.push(String.valueOf(s.charAt(i))); 
				  }
			  }
		  }
		  if(temp!=null) {
			  numStack.push(temp);
		  }
		  while(!opeStack.isEmpty()) {
			  numStack.push(opeStack.pop()) ;
		  }
		  
//		  //将栈一字符串依次取出向左拼接得到完整的后缀表达式，并计算
//		  StringBuilder sb=new StringBuilder("");
//		  while(!numStack.isEmpty()) {
//			  sb.append(numStack.pop());
//		  }
//		  String a=sb.reverse().toString();
//		  System.out.println(a);
//		  if(a.contains("+") || a.contains("-"))
//		  return evalRPN(a.split(""));
//		  return Integer.valueOf(a);
		  String[] tokens=new String[numStack.size()];
		  for(int i=tokens.length-1;i>=0;i--) {
			  tokens[i]=numStack.pop();
		  }
		  System.out.println(Arrays.toString(tokens));
		  return evalRPN(tokens);
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
		//System.out.println(Character.isDigit('1'));
//		 System.out.println(calculate("1 + 1"));
//		 System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
//		 System.out.println(calculate("2-1+2"));
//		 System.out.println(calculate("(2-1)+2"));
//		 System.out.println(evalRPN("21-2+".split("")));
		 System.out.println(calculate("2147483647"));
//		 System.out.println(evalRPN("2147483647".split("")));
		 System.out.println(calculate("1-11"));
		
	}
}
