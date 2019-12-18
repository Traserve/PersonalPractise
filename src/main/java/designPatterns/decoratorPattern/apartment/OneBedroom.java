package designPatterns.decoratorPattern.apartment;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:20
 */

public class OneBedroom extends Apartment {

    @Override
    public String getDescription() {
        return "一室一厅";
    }

    @Override
    public double getCost() {
        return 3000000;
    }
}
