package arithmetic.nowcoder;

import list.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @Author: Martin
 * @Date: 2020/1/29 22:28
 * @Description:
 *
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 */

public class PalindromeList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(isPalindrome(node));
    }

    /**
     * 快慢指针
     * @param pHead
     * @return
     */
    public static boolean isPalindrome(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        ArrayDeque<ListNode> arrayDeque = new ArrayDeque<>();
        while (fast != null && fast.next != null){
            arrayDeque.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null){
            arrayDeque.pop();
        }

        while(slow != null){
            //如果两者不相同，则该链表不是回文串
            if (arrayDeque.pop().data != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
