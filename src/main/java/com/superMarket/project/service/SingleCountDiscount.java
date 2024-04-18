package com.superMarket.project.service;

/**
 * 计算单件商品的折扣
 */
public class SingleCountDiscount implements CountDiscount {

    // 折扣比例
    private double percent;

    // 计算折扣金额
    @Override
    public double discount(double price) {
        return price * percent;
    }

    public SingleCountDiscount (double percent) {
        if (percent <= 0 ||  percent > 1) {
            throw new IllegalArgumentException("折扣不能小于等于0或大于1");
        }

        this.percent = percent;
    }
    
}
