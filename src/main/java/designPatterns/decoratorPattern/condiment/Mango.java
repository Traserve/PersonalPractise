package designPatterns.decoratorPattern.condiment;

import designPatterns.decoratorPattern.beverage.Beverage;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:05
 */

public class Mango extends Condiment {

    private Beverage beverage;

    public Mango(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，加芒果";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3;
    }
}
