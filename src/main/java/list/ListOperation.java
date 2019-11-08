package list;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/8 9:55
 */

@Slf4j
public class ListOperation {

    public static void main(String[] args) {
        ListNode head = creatListTail();
        traverseList(head);
//        traverseList(insertList(head, 9, 1));
//        traverseList(insertList(head, 9, 3));
        traverseList(reverseList(head));
    }

    /**
     * 反转链表，递归
     */
    public static ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 插入元素
     */
    public static ListNode insertList(ListNode head, int data, int pos) {
        ListNode newNode = new ListNode(data, null);
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
