package designPatterns.decoratorPattern.decoration;

import designPatterns.decoratorPattern.apartment.Apartment;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:23
 */

public class Light extends Decoration {

    public Light(Apartment apartment) {
        super(apartment);
    }

    @Override
    public String getDescription() {
        return apartment.getDescription() + " + 灯";
    }

    @Override
    public double getCost() {
        return apartment.getCost() + 100;
    }
}
