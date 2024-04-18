package com.superMarket.project.domain;

import java.util.ArrayList;
import java.util.List;

import com.superMarket.project.service.CountDiscount;

/**
 * 购物车，包括计算单个产品折扣价格和总体折扣价格
 */
public class ShppingCar {

    public List<ProductRecord> shoppingCar = new ArrayList<>();

    // 需要运用的折扣函数
    public List<CountDiscount> discountFuncs = new ArrayList<CountDiscount>();

    public double discount(){

        // 计算单件产品的折扣价格
        for (ProductRecord productRecord : shoppingCar) {
            productRecord.countDiscount();
        }

        // 计算单件产品折后价格的总价
        double totalPriceAfterSingleDiscount = 0;

        for (ProductRecord productRecord : shoppingCar) {
            totalPriceAfterSingleDiscount += productRecord.getDiscountPrice();
        }

        // 计算总体折扣后的价格
        double totalPrice = totalPriceAfterSingleDiscount;

        for (CountDiscount countDiscount : discountFuncs) {
            totalPrice = countDiscount.discount(totalPrice);
        }

        return totalPrice;
    }
}
