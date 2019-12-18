package designPatterns.decoratorPattern;

import designPatterns.decoratorPattern.apartment.Apartment;
import designPatterns.decoratorPattern.apartment.OneBedroom;
import designPatterns.decoratorPattern.beverage.Beverage;
import designPatterns.decoratorPattern.beverage.GreenTea;
import designPatterns.decoratorPattern.condiment.Lemon;
import designPatterns.decoratorPattern.condiment.Mango;
import designPatterns.decoratorPattern.decoration.Bed;
import designPatterns.decoratorPattern.decoration.Light;
import designPatterns.decoratorPattern.decoration.Table;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/17 14:08
 */

public class Main {

    public static void main(String[] args) {
        // 首先，我们需要一个基础饮料，红茶、绿茶或咖啡
        Beverage beverage = new GreenTea();
        // 开始装饰
        // 先加一份柠檬
        beverage = new Lemon(beverage);
        // 再加一份芒果
        beverage = new Mango(beverage);

        //"绿茶, 加柠檬, 加芒果 价格：￥16"
        System.out.println(beverage.getDescription() + "；  价格： ￥" + beverage.cost());



        //首先买一个一室一厅
        Apartment apartment = new OneBedroom();
        //再装修个灯
        apartment = new Light(apartment);
        //再买张桌子
        apartment = new Table(apartment);
        //再配张床
        apartment = new Bed(apartment);

        //一室一厅 + 灯 + 桌子 + 床; 花费： 3000680.0
        System.out.println(apartment.getDescription() + "; 花费： " + apartment.getCost());
    }
}
