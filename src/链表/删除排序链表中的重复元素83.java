package 链表;
/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

 * @author czz
 *
 */
public class 删除排序链表中的重复元素83 {
	/**
	 * 因为是排序链表，所以相同元素只会出现在相邻位置
	 * 我们对链表中每个元素进行项去重，每个元素只要与上一个元素相比即可
	 */
  public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null) {
        	if(prev.val==curr.val) {
        		prev.next=curr.next;
        	}else {
        		prev=curr;
        	}
        	curr=curr.next;	
        }
       return head;
    }
  
  public static void main(String[] args) {
	  LinkedList list=new LinkedList();
		 list.add(0);
		 list.add(0);
		 list.add(0);
		 list.add(0);
		 list.add(0);
		 list.add(0);
		 ListNode first=list.first;
//		 while(first!=null) {
//			 System.out.println(first.val);
//			 first=first.next;
//		 }
		 //
		 ListNode deleteDuplicates = deleteDuplicates(first);
		 while(deleteDuplicates!=null) {
		 System.out.println(deleteDuplicates.val);
		 deleteDuplicates=deleteDuplicates.next;
   }
 }
}