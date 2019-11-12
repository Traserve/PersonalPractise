package lru;

/**
 * Description: 双向链表相关操作
 *
 * @author Cao.Zhuang
 * @date 2019/11/12 16:20
 */

public class DoublyLinkedList {

    LRUNode head;
    LRUNode tail;

    /**
     * 在链表头部添加节点 x，时间 O(1)
     */
    public void addFirst(LRUNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    /**
     * 删除链表中的 x 节点（x 一定存在） 由于是双链表且给的是目标 Node 节点，时间 O(1)
     */
    public void remove(LRUNode node) {
        if (node.prev == null) {
            head = node.next;
            node.next.prev = null;
            node.next = null;
        } else if (node.next == null) {
            tail = node.prev;
            node.prev.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    /**
     * 删除链表中最后一个节点，并返回该节点，时间 O(1)
     */
    public void removeLast() {
        LRUNode newTail = tail.prev;
        tail.prev = null;
        newTail.next = null;
        tail = newTail;
    }

    /**
     * 返回链表长度，时间 O(1)
     */
    public int size() {
        LRUNode currNode = head;
        int i = 0;
        while (currNode != null) {
            i++;
            currNode = currNode.next;
        }
        return i;
    }

    public void print() {
        LRUNode currNode = head;
        while (currNode != null) {
            System.out.println(currNode.key + ": " + currNode.value);
            currNode = currNode.next;
        }
    }
}
