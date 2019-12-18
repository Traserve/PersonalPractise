package designPatterns.decoratorPattern.condiment;

import designPatterns.decoratorPattern.beverage.Beverage;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:02
 */

public class Lemon extends Condiment {

    private Beverage beverage;

    public Lemon(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，加柠檬";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2;
    }
}
