package springLearning.ioc;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/24 11:33
 */

public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "hello world";
    }
}
