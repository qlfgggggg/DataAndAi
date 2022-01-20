package qiaolf.newCoder;

import qiaolf.leetcode.Solution92;

/**
 * @Description: 链表指定区间反转
 * 将一个链表\ m m 位置到\ n n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
 * 例如：
 * 给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
 * 返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
 * 注意：
 * 给出的 mm,nn 满足以下条件：
 * 1 \leq m \leq n \leq 链表长度1≤m≤n≤链表长度
 * 示例1
 * 输入：
 * {1,2,3,4,5},2,4
 * 复制
 * 返回值：
 * {1,4,3,2,5}
 * Author:qiaolf
 * @Date:2021/9/8 22:27
 **/
public class solution {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode front = dummy;
        ListNode rear = head;
        ListNode tail = null;
        for (int i = 1; i <= n; i++) {
            if (i>=m){
                ListNode cu = rear.next;
                rear.next=front.next;
                front.next=rear;
                rear=cu;
            }else{
                rear=rear.next;
                front=front.next;
            }
            if (i==m){
                tail = front.next;
            }
        }
        tail.next=rear;
        return dummy.next;
    }

    public class ListNode { int val;ListNode next = null;}
}
