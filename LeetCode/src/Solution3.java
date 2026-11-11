/**
 * @author 酸汤泡饭
 * data:2026-11-11
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode();
        while (head!=null){
            ListNode t  = head;
            ListNode next = head.next;
            t.next = p.next;
            p.next = t;
            head = next;
        }
        return p.next;
    }

    public ListNode reverseList2(ListNode head) {

        ListNode p = new ListNode();
        while (head!=null){
            ListNode t  = new ListNode(head.val);
            t.next = p.next;
            p.next = t;
            head = head.next;
        }
        return p.next;
    }

}

