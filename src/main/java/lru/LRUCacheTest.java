package lru;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/12 11:29
 */

public class LRUCacheTest {

    static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.err.println(cache.toString());
        cache.put(4, 4);
        cache.put(5, 5);
        System.err.println(cache.toString());
        cache.put(4, 4);
        System.err.println(cache.toString());
        cache.get(3);
        System.err.println(cache.toString());
        Map<Integer, LRUNode> map = new HashMap<>();
        LRUNode node = new LRUNode(1, 1);
        map.put(1, node);
        System.err.println(map.get(1).value);
        node.value = 2;
        System.err.println(map.get(1).value);
        map.get(1).value = 3;
        System.err.println(map.get(1).value);
        System.err.println(node.value);
    }
}
