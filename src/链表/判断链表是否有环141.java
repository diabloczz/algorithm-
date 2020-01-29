package 链表;
/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

 * @author czz
 *
 */
public class 判断链表是否有环141 {
	/**
	 * 本题解法使用快慢指针，如果有环，两个指针一定会相遇
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
    	if(head==null || head.next==null) return false;
    	/**
    	 * 至于为何一开始快慢指针不在一个起点，如果两者一开始就相等，直接true返回结果了
    	 */
    	ListNode slow=head;
    	ListNode fast=head.next;
       while(fast!=null && fast.next!=null) {
    	   if(slow==fast)
    		   return true;
    	   slow=slow.next;
    	   fast=fast.next.next;
    	
       }
       return false;
    }
}
