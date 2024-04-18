package com.superMarket.project;

import com.superMarket.project.domain.Fruit;
import com.superMarket.project.domain.ProductRecord;
import com.superMarket.project.domain.ShppingCar;
import com.superMarket.project.service.SingleCountDiscount;
import com.superMarket.project.service.TotalCountDiscount;

public class mian {
    
    public static void main(String[] args) {
        new mian().noStaticRun();
    }

    private void noStaticRun(){
        Fruit apple = new Fruit("苹果", 8d);
        Fruit staw = new Fruit("草莓", 13);
        
        ProductRecord appleRec = new ProductRecord(apple, 10);
        ProductRecord stawRec = new ProductRecord(staw, 10);

        ShppingCar sCar = new ShppingCar();

        sCar.shoppingCar.add(appleRec);
        sCar.shoppingCar.add(stawRec);

        double price1 = sCar.discount();
        
        System.out.println(price1);
        System.out.println(price1 == 210);

        // 增加一种芒果
        Fruit mang = new Fruit("芒果", 20);
        ProductRecord mangRec = new ProductRecord(mang, 2);
        sCar.shoppingCar.add(mangRec);
        double price2 = sCar.discount();
        
        System.out.println(price2);
        System.out.println(price2 == 250);

        // 草莓8折
        SingleCountDiscount sDiscount = new SingleCountDiscount(0.8);
        stawRec.addDiscountFunc(sDiscount);
        
        double price3 = sCar.discount();
        
        System.out.println(price3);
        System.out.println(price3 == 224);

        // 100满减10块
        TotalCountDiscount tCount = new TotalCountDiscount(100d, 10d);
        sCar.discountFuncs.add(tCount);

        double price4 = sCar.discount();
        
        System.out.println(price4);
        System.out.println(price4 == 183.2);
    }
}

