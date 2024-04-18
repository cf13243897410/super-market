package com.superMarket.project.service;

/**
 * 根据满减计算折扣
 */
public class TotalCountDiscount implements CountDiscount{

    // 每次享受折扣的金额
    private double total;

    // 一次满减的金额
    private double minus;

    // 根据折扣设置，计算满减金额
    @Override
    public double discount(double price) {
        
        if (price <= 0) {
            throw new UnsupportedOperationException("折扣前价格不能小于等于0");
        }

        // 计算不享受折扣的部分
        double noDisountMount = price % total;

        // 计算享受折扣的次数
        double discountTimes = Math.floor(price / total);

        return price - minus * discountTimes;

    }
    
    public TotalCountDiscount (double total, double minus) {
        if (total <= 0 || minus <= 0) {
            throw new IllegalArgumentException("总价不能小于等于0，并且折扣不能小于等于0");
        }
        this.total = total;
        this.minus = minus;
    }
}
