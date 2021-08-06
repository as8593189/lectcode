package com.ListNode;

public class ListTable {

	/**
	 * ����һ��ͷ���Ϊ head �ķǿյ���������������м��㡣
	 * 
	 * ����������м��㣬�򷵻صڶ����м��㡣
	 * https://leetcode-cn.com/problems/middle-of-the-linked-list
	 */
	
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		//�õ�����
		int length = 0;
		ListNode p = head;
		while(p!=null) {
			length++;
			p=p.next;
		}
		int step = length /2;
		for (int i = 0; i < step; i++) {
			head = head.next;
		}
		return head;
    }
	
	
	/**
	 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
	 * 
	 * ���ף����ܳ���ʹ��һ��ɨ��ʵ����
	 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		while(head ==null) {
			return null;
		}
		ListNode first = new ListNode();
		first.next = head;
		ListNode p = first;
		ListNode last = p;
		for (int i = 0; i < n; i++) {
			last = last.next;
		}
		while(last!=null && last.next!=null) {
			last = last.next;
			p = p.next;
		}
		p.next = p.next.next;
		return first.next;
    }
}
