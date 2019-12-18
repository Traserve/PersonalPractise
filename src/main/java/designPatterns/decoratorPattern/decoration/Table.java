package designPatterns.decoratorPattern.decoration;

import designPatterns.decoratorPattern.apartment.Apartment;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:25
 */

public class Table extends Decoration {

    public Table(Apartment apartment){
        super(apartment);
    }

    @Override
    public String getDescription() {
        return apartment.getDescription() + " + 桌子";
    }

    @Override
    public double getCost() {
        return apartment.getCost() + 80;
    }
}
