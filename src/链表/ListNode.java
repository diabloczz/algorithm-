package 链表;
/**
 * Definition for singly-linked list.
 */
 public class ListNode {
	 
	    int val;
		 ListNode next;
		ListNode(int x) { val = x; }
		
		@Override
		public String toString() {
			if(next!=null)
			 return "[ val="+val+",next="+next.val+"]";
			return "[ val="+val+",next=null]";
		}
	 }