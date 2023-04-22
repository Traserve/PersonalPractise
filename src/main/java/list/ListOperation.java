package list;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/8 9:55
 */

public class ListOperation {

    private static ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = creatListTail();
        traverseList(head);
//        traverseList(insertList(head, 9, 3));
        traverseList(reverseListRecursion(head));
//        traverseList(reverseListRecursion(head, 3));
//        traverseList(reverseListRecursion(head, 3, 5));
//        traverseList(reserveListIteration(head));
//        traverseList(reserveListIteration(head, 3));
//        traverseList(reserveListBetween(head.next, head.next.next.next));
//        traverseList(reserveListByGroup(head, 3));
        ListNode a = head.next.next;
        ListNode b = head;
        while (b.next != null) {
            b = b.next;
        }
        b.next = a;
        System.err.println(judgeCircle(head));
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
            successor = head.next;
            return head;
        }
        ListNode last = reverseListRecursion(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
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
     * 每k个元素一组进行翻转 1 2 3 4 5 6 3 2 1 6 5 4
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
     * 判断链表是否有环
     */
    public static int judgeCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int i = -1, j = 0;
        while (j < 2 && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                if (i < 0) {
                    i = 0;
                }
                j++;
            }
            if (i >= 0) {
                i++;
            }
        }
        return i - 1;
    }

    /**
     * 判断两个链表是否相交： 两个链表相交，则它们的尾结点一定相同，比较两个链表的尾结点是否相同即可
     */
    public boolean isCross(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        if (temp1 == temp2) {
            return true;
        }
        return false;
    }

    /**
     * 如果链表相交，求链表相交的起始点：
     * 1、首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义
     * 2、求出两个链表长度之差：len=length1-length2
     * 3、让较长的链表先走len步
     * 4、然后两个链表同步向前移动，没移动一次就比较它们的结点是否相等，第一个相等的结点即为它们的第一个相交点
     */
    public ListNode findFirstCrossPoint(ListNode head1, ListNode head2) {
        if (!isCross(head1, head2)) {
            return null;
        }
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        return temp1;
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
            System.out.print(curr.val + " ");
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
            newNode.val = newDate;
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
            newNode.val = newDate;
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
