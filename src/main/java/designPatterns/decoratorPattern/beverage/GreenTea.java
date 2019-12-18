package designPatterns.decoratorPattern.beverage;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 13:59
 */

public class GreenTea extends Beverage {

    @Override
    public String getDescription() {
        return "绿茶";
    }

    @Override
    public double cost() {
        return 11;
    }
}
