package lru;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        cache.put(4, 4);
        cache.put(5, 5);
        System.err.println(cache.get(1));
        System.err.println(cache.get(4));
    }
}
