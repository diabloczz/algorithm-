package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 有效的括号20 {
	/**
	 * 第一种 用字符串替换的方式，缺点是效率低
	 * @param s
	 * @return
	 */
	 public boolean isValid(String s) {
            while(s.contains("{}")
            		||s.contains("()")
            		||s.contains("[]")) {
            	s=s.replace("{}", "");
            	s=s.replace("[]", "");
            	s=s.replace("()", "");
            }
            return s.isEmpty();
	    }
	 
	 /**
	  *1. 遇见左字符，将左字符入栈
2. 遇见右字符
如果栈是空的，说明括号无效
如果栈不为空，将栈顶字符出栈，与右字符之匹配
✓ 如果左右字符不匹配，说明括号无效
✓ 如果左右字符匹配，继续扫描下一个字符
3. 所有字符扫描完毕后
✓ 栈为空，说明括号有效
✓ 栈不为空，说明括号无效
	  * @param s
	  * @return
	  */
	 public static boolean isValid2(String s) {
         int len=s.length();
         Stack<Character> stack=new Stack<>();
         for(int i=0;i<len;i++) {
        	 char c=s.charAt(i);
        	 if(c=='(' || c=='[' || c=='{') {
        		 stack.push(c);
        	 }else {
        		 //右字符串
        		 if(stack.isEmpty()) return false;
        		 char left=stack.pop();
        		 if(left=='{' && c!='}') return false;
        		 if(left=='[' && c!=']') return false;
        		 if(left=='(' && c!=')') return false;
        	 }
         }
         return stack.isEmpty();
	    }
	 
	 public static void main(String[] args) {
		System.out.println(isValid2("([{}])"));
	}
}
