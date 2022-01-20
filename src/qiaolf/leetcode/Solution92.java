package qiaolf.leetcode;

/**
 * @Description: 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:qiaolf
 * @Date:2021/9/8 21:24
 **/
public class Solution92 {

    //找到left-1节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode rear=head;
        dummy.next= head;
        ListNode front = dummy;
        ListNode tail = null;
        for (int i = 1; i <= right ; i++) {
            if (i>=left){//这里进行反转
                ListNode cu = rear.next;
                rear.next=front.next;
                front.next=rear;
                rear=cu;
            }else{
                front = front.next;
                rear = rear.next;
            }
            if (i==left){
                tail = front.next;
            }
        }
        tail.next = rear;
        return dummy.next;

    }


public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
