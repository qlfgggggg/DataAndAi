package qiaolf.newCoder;

/**
 * @Description: 反转链表
 * Author:qiaolf
 * @Date:2021/9/27 23:06
 **/
public class nc78 {

    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=node.next;
            node.next=cur;
            cur=next;
        }
        return node.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}