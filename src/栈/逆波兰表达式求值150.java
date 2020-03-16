package 栈;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
示例 2：

输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: (4 + (13 / 5)) = 6
示例 3：

输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
输出: 22
解释: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 逆波兰表达式求值150 {
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
	    Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
		Matcher isNum = pattern.matcher("99");
		Matcher isNum2 = pattern.matcher("-11");
		System.out.println(isNum.matches()+", "+isNum2.matches());
		System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
		System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
}
