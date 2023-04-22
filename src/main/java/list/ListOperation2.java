package list;

/**
 * Description:
 *
 * @author Martin
 * @date 2021/4/17 16:10
 */

public class ListOperation2 {

    private static ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = init();
//        traverse(head);
//        head = init();
//        traverse(reverse(head));
//        head = init();
//        traverse(reverseRecursion(head));
//        head = init();
//        traverse(reverseN(head, 3));
//        head = init();
        traverse(reverseBetween(head, 2, 4));
    }

    private static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        return node1;
    }

    private static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println("\n---------------------------");
    }

    /**
     * 迭代反转
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {

        ListNode newHead = head;

        while (head.next != null) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = newHead;
            newHead = next;
        }

        return newHead;
    }

    /**
     * 递归反转
     *
     * @param head
     * @return
     */
    private static ListNode reverseRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 递归反转前N个节点
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseN(ListNode head, int n) {
        if (head.next == null) {
            return head;
        }
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 反转第m到第n的节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) {
            return head;
        }
        if (m <= 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

//    private static ListNode reverseBetween(ListNode left, ListNode right){
//
//    }

}
