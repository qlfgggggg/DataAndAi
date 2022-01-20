package qiaolf.newCoder;

/**
 * @Description: 判断链表是否有环:
 * 使用快慢指针的方式:快指针走两步，慢指针走一步，如果快指针走到null说明无环，如果没有走到null，总会两个走到一块
 * Author:qiaolf
 * @Date:2021/9/27 23:24
 **/
public class nc4 {
    public boolean hasCycle(ListNode head){
        ListNode kuai = head,man = head;
        while (kuai!=null && kuai.next!=null){
            kuai=kuai.next.next;//走两步
            man=man.next;
            if (kuai==man){
                return true;
            }
        }
        return false;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

