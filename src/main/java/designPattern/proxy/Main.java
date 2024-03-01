package designPattern.proxy;

import java.util.Scanner;

// 抽象主题
interface HomePurchase {
    void requestPurchase(int area);
}

// 真实主题
class HomeBuyer implements HomePurchase {
    @Override
    public void requestPurchase(int area) {
        System.out.println("YES");
    }
}

// 代理类
class HomeAgentProxy implements HomePurchase {
    private HomeBuyer homeBuyer = new HomeBuyer();

    @Override
    public void requestPurchase(int area) {
        if (area > 100) {
            homeBuyer.requestPurchase(area);
        } else {
            System.out.println("NO");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HomePurchase buyerProxy = new HomeAgentProxy();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int area = scanner.nextInt();
            buyerProxy.requestPurchase(area);
        }
        scanner.close();
    }
}