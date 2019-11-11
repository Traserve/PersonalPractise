package list;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/8 9:55
 */

public class ListOperation {

    private static ListNode linkAfter = null;

    public static void main(String[] args) {
        ListNode head = creatListTail();
        traverseList(head);
//        traverseList(insertList(head, 9, 3));
//        traverseList(reverseListRecursion(head));
//        traverseList(reverseListRecursion(head, 3));
//        traverseList(reverseListRecursion(head, 3, 5));
//        traverseList(reserveListIteration(head));
//        traverseList(reserveListIteration(head, 3));
//        traverseList(reserveListBetween(head.next, head.next.next.next));
        traverseList(reserveListByGroup(head, 3));
    }

    /**
     * 反转链表，递归
     */
    public static ListNode reverseListRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 反转链表前n位，递归
     */
    public static ListNode reverseListRecursion(ListNode head, int n) {
        if (head.next == null || n == 1) {
            linkAfter = head.next;
            return head;
        }
        ListNode last = reverseListRecursion(head.next, n - 1);
        head.next.next = head;
        head.next = linkAfter;
        return last;
    }

    /**
     * 反转链表第m-n位，递归
     */
    public static ListNode reverseListRecursion(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            //此时n = (n - m + 1)
            return reverseListRecursion(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseListRecursion(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 迭代
     */
    public static ListNode reserveListIteration(ListNode head) {
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            //保留下一个结点
            ListNode nextNode = curNode.next;
            //指针反转
            curNode.next = preNode;
            //前结点后移
            preNode = curNode;
            //当前结点后移
            curNode = nextNode;
        }
        return preNode;
    }

    /**
     * 反转链表前n位，迭代
     */
    public static ListNode reserveListIteration(ListNode head, int n) {
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null && n > 0) {
            //保留下一个结点
            ListNode nextNode = curNode.next;
            //指针反转
            curNode.next = preNode;
            //前结点后移
            preNode = curNode;
            //当前结点后移
            curNode = nextNode;
            n--;
        }
        head.next = curNode;
        return preNode;
    }

    /**
     * 反转链表left和right之间的数据，迭代
     */
    public static ListNode reserveListBetween(ListNode left, ListNode right) {
        ListNode curNode = left;
        ListNode preNode = null;
        ListNode nextNode = null;
        while (curNode != null && curNode != right) {
            //保留下一个结点
            nextNode = curNode.next;
            //指针反转
            curNode.next = preNode;
            //前结点后移
            preNode = curNode;
            //当前结点后移
            curNode = nextNode;
        }
        left.next = curNode;
        return preNode;
    }

    /**
     * 每k个元素一组进行翻转
     * 1 2 3 4 5 6
     * 3 2 1 6 5 4
     */
    public static ListNode reserveListByGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        ListNode startNode = head;
        for (int i = 0; i < k; i++) {
            if (curNode == null) {
                break;
            }
            curNode = curNode.next;
        }
        ListNode newHead = reserveListBetween(startNode, curNode);
        startNode.next = reserveListByGroup(curNode, k);
        return newHead;
    }

    /**
     * 插入元素
     */
    public static ListNode insertList(ListNode head, int data, int pos) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        if (pos == 1) {
            newNode.next = head;
            return newNode;
        }
        ListNode pre = head;
        ListNode after = head;
        int i = 1;
        while (i < pos && after != null) {
            pre = after;
            after = after.next;
            i++;
        }
        pre.next = newNode;
        newNode.next = after;
        return head;
    }

    /**
     * 遍历链表
     */
    public static void traverseList(ListNode head) {
        if (head == null) {
            System.out.println("链表为空");
            System.exit(0);
        }
        ListNode curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != null);
        System.out.print("\n");
    }

    /**
     * 创建链表，在头部插入
     */
    public static ListNode creatListHead() {
        // 头部，空表
        ListNode head = null;
        System.out.println("现在使用头部插入法，请输入数据，以0为结束");
        int newDate;
        Scanner in = new Scanner(System.in);
        while ((newDate = in.nextInt()) != 0) {
            ListNode newNode = new ListNode();
            newNode.data = newDate;
            newNode.next = head;
            head = newNode;
        }
        System.out.println("录入完毕");
        return head;
    }

    /**
     * 创建链表，在尾部插入
     */
    public static ListNode creatListTail() {
        // 头部，空表
        ListNode head = null;
        ListNode last = null;
        System.out.println("现在使用尾部插入法，请输入数据，以0为结束");
        int newDate;
        Scanner in = new Scanner(System.in);
        while ((newDate = in.nextInt()) != 0) {
            ListNode newNode = new ListNode();
            newNode.data = newDate;
            newNode.next = null;
            if (head == null) {
                head = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }
        System.out.println("录入完毕");
        return head;
    }

}
