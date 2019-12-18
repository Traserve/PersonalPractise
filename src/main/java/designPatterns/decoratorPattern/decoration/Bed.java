package designPatterns.decoratorPattern.decoration;

import designPatterns.decoratorPattern.apartment.Apartment;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:25
 */

public class Bed extends Decoration {

//    private Apartment apartment;

    //这里需要传入房屋类，可根据需要传入未装饰过得房屋或者已经装饰过得房屋
    public Bed(Apartment apartment) {
//        this.apartment = apartment;
        super(apartment);
    }

    @Override
    public String getDescription() {
        return apartment.getDescription() + " + 床";
    }

    @Override
    public double getCost() {
        return apartment.getCost() + 500;
    }
}
