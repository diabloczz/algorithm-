package 链表;

public class LinkedList {
	public ListNode first;
	private int size;
	/**
	 * 这个方法默认在末尾添加一个新节点，新节点的val等于给定的值num
	 * @param val
	 */
	public void add(int num) {
		if(first==null) {
			first=new ListNode(num);
		}else {
			ListNode last=first;
			for(int i=0;i<size-1;i++) {
				last=last.next;
			}
			last.next=new ListNode(num);
		}
		size++;
	}
}
