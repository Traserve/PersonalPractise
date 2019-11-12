package lru;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: 直接使用LRULinkedHashMap来实现LRU
 *
 * @author Cao.Zhuang
 * @date 2019/11/12 14:02
 */

public class LRULinkedHashMap {

    static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private int capacity;
    private Map<Integer, Integer> cache;

    public LRULinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRULinkedHashMap cache = new LRULinkedHashMap(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 4);
        for (Map.Entry<Integer, Integer> entry : cache.cache.entrySet()) {
            System.err.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
