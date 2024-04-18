package com.superMarket.project.domain;

import java.util.ArrayList;
import java.util.List;

import com.superMarket.project.service.CountDiscount;

public class ProductRecord {

    private Fruit product;

    private int quantity;

    private double discountPrice;

    private List<CountDiscount> discountFuncs = new ArrayList<CountDiscount>();

    public ProductRecord(Fruit product, int quantity) {
        if (quantity <=0) {
            throw new IllegalArgumentException("产品数量不能小于等于0");
        }

        this.product = product;
        this.quantity = quantity;
    }

    // 添加折扣计算规则
    public void addDiscountFunc(CountDiscount countDiscount){
        discountFuncs.add(countDiscount);
    }

    // 计算产品折扣金额
    public double countDiscount(){

        // 计算折扣前金额
        double dPrice = product.getPrice() * quantity;

        // 应用所有折扣
        for (CountDiscount countDiscount : discountFuncs) {
            dPrice = countDiscount.discount(discountPrice);
        }

        // 设置打折后的价格
        this.discountPrice = dPrice;

        return dPrice;
    }

    public double getDiscountPrice() {
        return this.discountPrice;
    }
}
