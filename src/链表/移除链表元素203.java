package 链表;
/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 * @author czz
 *
 */
public class 移除链表元素203 {
	 public static ListNode removeElements(ListNode head, int val) {
	        if(head==null) return head;
	         ListNode init=new ListNode(0);
	         ListNode prev=init;
	         ListNode curr=head;
	         prev.next=head;
	         while(curr!=null) {
	        	 if(curr.val==val) {
	        		prev.next=curr.next;
	        		 
	        	 }else {
	        		prev=curr; 
	        	 }
	        	curr=curr.next;
	         }
	        return init.next;
	    }
	 
//	 public static ListNode removeElements2(ListNode head, int val) {
//	        if(head==null) return head;
//	         if(head.val==val)
//	        return head;
//	    }
	 
	 public static void main(String[] args) {
//		 ListNode first=new ListNode(1);
//		 first.next=new ListNode(2);
//		 ListNode second=first.next;
		 LinkedList list=new LinkedList();
		 list.add(1);
		 list.add(2);
		 list.add(6);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 list.add(6);
		 ListNode first=list.first;
//		 while(first!=null) {
//			 System.out.println(first.val);
//			 first=first.next;
//		 }
		 //
		 ListNode removeElements = removeElements(first,6);
		 while(removeElements!=null) {
		 System.out.println(removeElements.val);
		 removeElements=removeElements.next;
	 }
	}
}
