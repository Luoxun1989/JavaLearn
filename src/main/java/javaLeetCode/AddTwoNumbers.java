package javaLeetCode;

/**
 * “Go Further进无止境” <br>
 * 〈两数相加〉
 *
 * @author Luoxun
 * @create 2020/3/26
 * @since 1.0.0
 */
public class AddTwoNumbers {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
