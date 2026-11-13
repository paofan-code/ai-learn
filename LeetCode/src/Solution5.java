/**
 * @author 酸汤泡饭
 * data:2026-11-13
 */

class Solution5 {
    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1!=null && list2!=null){
            if(list1.val>= list2.val){
                head.next = list2;
                list2 = list2.next;
            }
            else {
                head.next = list1;
                list1 = list1.next;
            }
        }
        if(list1!=null) head.next = list1;
        if(list2!=null) head.next = list2;
        return p.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1!=null && list2!=null){
            if(list1.val>= list2.val){
                head.next = list2;
                list2 = list2.next;
            }
            else {
                head.next = list1;
                list1 = list1.next;
            }
        }
        if(list1!=null) head.next = list1;
        if(list2!=null) head.next = list2;
        return p.next;
    }

}
