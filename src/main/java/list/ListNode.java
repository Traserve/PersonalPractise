package list;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/8 9:51
 */

public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" + val + "->" + next.val + "}";
    }
}
