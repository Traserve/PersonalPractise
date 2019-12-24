package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import test.User;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/20 9:40
 */

public class ReflectTest {

    public static void main(String[] args) {
        traverse(new User("张三", 20));
    }

    private static void traverse(Object object) {
        Class<?> clz = object.getClass();
        // 获取实体类的所有属性，返回Field数组
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            //打印该类的所有属性类型
            String type = field.getGenericType().getTypeName();
            //字段名称
            String fieldName = field.getName();
            //将属性的首字符大写，方便构造get，set方法
            String methodName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            try {
                Method method = object.getClass().getMethod("get" + methodName);
                String methodValue = String.valueOf(method.invoke(object)) ;
                System.out.println("name: " + methodName + "  value: " + methodValue + "  type: " + type);
//                if("java.lang.String".equals(type)){
//                    String value = String.valueOf(method.invoke(object)) ;
//                    System.out.println(value);
//                }else if ("java.lang.Integer".equals(type)){
//                    Integer value = (Integer) method.invoke(object);
//                    System.out.println(value);
//                }else if ("java.lang.Long".equals(type)){
//                    Long value = (Long) method.invoke(object);
//                    System.out.println(value);
//                }

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
