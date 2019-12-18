package designPatterns.decoratorPattern.beverage;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 13:59
 */

public class BlackTea extends Beverage {

    @Override
    public String getDescription() {
        return "红茶";
    }

    @Override
    public double cost() {
        return 10;
    }
}
