package stream;

/**
 * @ClassName Apple
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/28 11:53
 */

public class Apple {

    String name;
    Integer size;
    String origin;

    public Apple() {
        super();
    }

    public Apple(String name, Integer size, String origin) {
        this.name = name;
        this.size = size;
        this.origin = origin;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
