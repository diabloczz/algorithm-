package 栈;

import java.util.Stack;

/**
 * 
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
示例:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
说明:

你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class 栈实现队列232 {
	
	private Stack<Integer> instack;
	private Stack<Integer> outstack;
	 public 栈实现队列232() {
		 instack=new Stack<>();
		 outstack=new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	    	instack.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
            if(outstack.isEmpty()) {
            	while(!instack.isEmpty()) {
            		outstack.push(instack.pop());
            	}
            }
            return outstack.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	 if(outstack.isEmpty()) {
	            	while(!instack.isEmpty()) {
	            		outstack.push(instack.pop());
	            	}
	            }
	    	 return outstack.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
             return instack.isEmpty()&&outstack.isEmpty();
	    }
	    
	    public static void main(String[] args) {
	    	栈实现队列232 cc=new 栈实现队列232();
	    	cc.push(1);
	    	cc.push(2);
	    	cc.push(3);
	    	System.out.println(cc.peek());
	    	System.out.println(cc.pop());
	    	System.out.println(cc.pop());
	    	System.out.println(cc.empty());
	    	System.out.println(cc.pop());
	    	System.out.println(cc.empty());
		}
}
