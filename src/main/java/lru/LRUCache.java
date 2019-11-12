package lru;

import java.util.HashMap;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/12 15:31
 */

public class LRUCache {

    private HashMap<Integer, LRUNode> map;
    private DoublyLinkedList cache;
    // 最大容量
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoublyLinkedList();
    }

    public void put(int key, int value) {
        LRUNode node = new LRUNode(key, value);
        if (map.containsKey(key)) {
            //key已存在则将其删除后在添加到头部
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        } else {
            if (cache.size() == capacity) {
                //删除最后一个数据
                map.remove(cache.tail.key);
                cache.removeLast();
            }
            //添加到头部
            cache.addFirst(node);
            map.put(key, node);
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).value;
        // 利用 put 方法把该数据提前
        put(key, value);
        return value;
    }
}
