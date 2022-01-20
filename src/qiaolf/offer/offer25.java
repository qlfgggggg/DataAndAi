package qiaolf.offer;

/**
 * @Description: 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:qiaolf
 * @Date:2021/8/3 10:52
 **/
public class offer25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode t1;
        ListNode t2;
        ListNode list;
        ListNode head;
        if(l1.val<=l2.val){
            list = new ListNode(l1.val);
            t1=l1.next;
            t2 = l2;
            head=list;
        }else{
            list = new ListNode(l2.val);
            t2=l2.next;
            t1=l1;
            head=list;
        }
        while(t2!=null && t1!=null){
            if(t1.val<=t2.val){
                head.next=t1;
                t1=t1.next;
            }else{
                head.next=t2;
                t2=t2.next;
            }
            head=head.next;
        }
        while(t1!=null){
            head.next=t1;
            t1=t1.next;
            head=head.next;
        }
        while(t2!=null){
            head.next=t2;
            t2=t2.next;
            head=head.next;
        }
        return list;
    }
}

