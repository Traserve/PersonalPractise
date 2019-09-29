package optional;

import com.test.User;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName OptionalTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/8/12 17:20
 */
@Slf4j
public class OptionalTest {

    public static void main(String[] args) {
//        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
//        Optional<String> longest = names
//                .filter(name -> name.startsWith("S"))
//                .findFirst();
//
//        System.err.println(longest.orElse("Nimrod"));
//        longest.ifPresent(name -> {
//            String s = name.toUpperCase();
//            System.out.println("The longest name is "+ s);
//        });

//        User user = null;
//        log.debug("Using orElse");
//        User result = Optional.ofNullable(user).orElse(createNewUser());
//        log.debug("Using orElseGet");
//        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
//        log.info("-------------------------------------------------------------------------------------------");
//        User user2 = new User("john@gmail.com", 12);
//        log.info("Using orElse");
//        User re = Optional.ofNullable(user2).orElse(createNewUser());
//        log.info("Using orElseGet");
//        User re2 = Optional.ofNullable(user2).orElseGet(() -> createNewUser());
//
//        System.err.println(Optional.ofNullable(null).orElse(1));
//        System.err.println(Optional.ofNullable(2).orElse(1));

//        User user = null;
        User user = new User();
        System.err.println(Optional.ofNullable(user).isPresent());
//        User user = new User("AAA", 12);
        Optional.ofNullable(user).ifPresent(u -> {
            u.setName("BBB");
            System.err.println("The student name is : " + u.getName());
        });
        Optional.ofNullable(user).flatMap(u -> Optional.ofNullable(u.getAge()));
        System.err.println(Optional.ofNullable(user).map(User::getName).orElse("CCC"));

//        Map<Integer, User> map = new HashMap<>();
//        System.err.println(Optional.ofNullable(map.get(1).getAge()).orElse(0));
//        System.err.println(Optional.ofNullable(map.get(1)).orElse(new User().setAge(0)).getAge());
    }

    private static User createNewUser() {
        log.info("Creating New User");
        return new User("extra@gmail.com", 12);
    }
}
