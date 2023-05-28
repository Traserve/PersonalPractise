package serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.util.SerializationUtils.serialize;

/**
 * @author: Martin
 * @date: 2023/5/12 14:22
 * Description:
 */
public class Test implements Cloneable {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.setId(1L);
        info.setName("Tom");

        int loop = 100_0000;
        ByteArrayOutputStream bout = null;
        ObjectOutputStream out = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bout = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bout);
            out.flush();
            out.close();
            byte[] b = bout.toByteArray();
            bout.close();
        }
        System.out.println("jdk serializable time : " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("------------------------------");

        bomb();
    }

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // Make t1 unequal to t2
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root); // Method omitted for brevity
    }

}



