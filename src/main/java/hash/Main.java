package hash;

import hash.MyHashTable.DataItem;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/28 16:14
 */

public class Main {

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(100);
        hashTable.insert(new DataItem(10));
        hashTable.insert(new DataItem(10));
        System.err.println(hashTable.find(10).getKey());
    }
}
