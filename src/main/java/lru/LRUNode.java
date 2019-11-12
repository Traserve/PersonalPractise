package lru;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/12 15:31
 */

public class LRUNode {

    int key;
    int value;
    LRUNode prev;
    LRUNode next;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
