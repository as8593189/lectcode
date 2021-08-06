package com.ListNode;

public class ListTable {

	/**
	 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
	 * 
	 * 如果有两个中间结点，则返回第二个中间结点。
	 * https://leetcode-cn.com/problems/middle-of-the-linked-list
	 */
	
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		//得到长度
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
	 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
	 * 
	 * 进阶：你能尝试使用一趟扫描实现吗？
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
