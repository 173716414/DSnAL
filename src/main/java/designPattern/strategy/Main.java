package designPattern.strategy;

import java.util.Scanner;

// 抽象购物优惠策略接⼝
interface DiscountStrategy {
    int applyDiscount(int originalPrice);
}

// 九折优惠策略
class DiscountStrategy1 implements DiscountStrategy {
    @Override
    public int applyDiscount(int originalPrice) {
        return (int) Math.round(originalPrice * 0.9);
    }
}

// 满减优惠策略
class DiscountStrategy2 implements DiscountStrategy {
    private int[] thresholds = {100, 150, 200, 300};
    private int[] discounts = {5, 15, 25, 40};

    @Override
    public int applyDiscount(int originalPrice) {
        for (int i = thresholds.length - 1; i >= 0; i--) {
            if (originalPrice >= thresholds[i]) {
                return originalPrice - discounts[i];
            }
        }
        return originalPrice;
    }
}

// 上下⽂类
class DiscountContext {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public int applyDiscount(int originalPrice) {
        return discountStrategy.applyDiscount(originalPrice);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// 读取需要计算优惠的次数
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
// 读取商品价格和优惠策略
            String[] input = scanner.nextLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int strategyType = Integer.parseInt(input[1]);
// 根据优惠策略设置相应的打折策略
            DiscountStrategy discountStrategy;
            switch (strategyType) {
                case 1:
                    discountStrategy = new DiscountStrategy1();
                    break;
                case 2:
                    discountStrategy = new DiscountStrategy2();
                    break;
                default:
// 处理未知策略类型
                    System.out.println("Unknown strategy type");
                    return;
            }
// 设置打折策略
            DiscountContext context = new DiscountContext();
            context.setDiscountStrategy(discountStrategy);
// 应⽤打折策略并输出优惠后的价格
            int discountedPrice = context.applyDiscount(M);
            System.out.println(discountedPrice);
        }
    }
}