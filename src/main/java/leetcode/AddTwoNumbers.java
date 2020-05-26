package leetcode;

/**
 * Description:
 *
 * @author Martin
 * @date 2020/3/27 14:36
 */


public class AddTwoNumbers {

    public static void main(String[] args) {
//        ListNode node1 = bulidList(new int[]{2, 4, 3});
//        ListNode node2 = bulidList(new int[]{5, 6, 4});

//        ListNode node1 = bulidList(new int[]{9});
//        ListNode node2 = bulidList(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});

        ListNode node1 = bulidList(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        ListNode node2 = bulidList(new int[]{5, 6, 4});

        ListNode head = addTwoNumbers(node1, node2);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(" -> ");
            }
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        //和大于等于10的时候要进一
        int carry = 0;
        while (p != null || q != null || carry == 1) {
            int m = (p == null) ? 0 : p.val;
            int n = (q == null) ? 0 : q.val;
            int tmp = m + n + carry;
            curNode.next = new ListNode(tmp % 10);
            curNode = curNode.next;
            carry = tmp / 10;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        return head.next;
    }

    public static ListNode bulidList(int[] nums) {
        ListNode head = null;
        ListNode curNode = null;
        ListNode preNode = null;
        for (int i = 0; i < nums.length; i++) {
            preNode = curNode;
            curNode = new ListNode(nums[i]);
            if (i == 0) {
                head = curNode;
            } else {
                preNode.next = curNode;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
