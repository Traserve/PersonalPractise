package designPatterns.decoratorPattern.decoration;

import designPatterns.decoratorPattern.apartment.Apartment;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:23
 */

public abstract class Decoration extends Apartment {

    protected Apartment apartment;

    public Decoration(Apartment apartment){
        this.apartment = apartment;
    }

    public String getDescription() {
        return apartment.getDescription();
    }

    public double getCost() {
        return apartment.getCost();
    }
}
