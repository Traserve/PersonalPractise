package test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:14
 */

@Data
@Accessors(chain = true)
public class Order {

    private Long id;

    private String userName;

    private String product;
}
