package Design_Pattern;

import java.util.Scanner;

// 抽象椅⼦接⼝
interface Chair {
    void showInfo();
}

// 具体现代⻛格椅⼦
class ModernChair implements Chair {
    @Override
    public void showInfo() {
        System.out.println("modern chair");
    }
}

// 具体古典⻛格椅⼦
class ClassicalChair implements Chair {
    @Override
    public void showInfo() {
        System.out.println("classical chair");
    }
}

// 抽象沙发接⼝
interface Sofa {
    void displayInfo();
}

// 具体现代⻛格沙发
class ModernSofa implements Sofa {
    @Override
    public void displayInfo() {
        System.out.println("modern sofa");
    }
}

// 具体古典⻛格沙发
class ClassicalSofa implements Sofa {
    @Override
    public void displayInfo() {
        System.out.println("classical sofa");
    }
}

// 抽象家居⼯⼚接⼝
interface FurnitureFactory {
    Chair createChair();

    Sofa createSofa();
}

// 具体现代⻛格家居⼯⼚
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

// 具体古典⻛格家居⼯⼚
class ClassicalFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ClassicalChair();
    }

    @Override
    public Sofa createSofa() {
        return new ClassicalSofa();
    }
}

public class FurnitureOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取订单数量
        int N = scanner.nextInt();
        // 处理每个订单
        while (N-- > 0) {
// 读取家具类型
            String furnitureType = scanner.next();
// 创建相应⻛格的家居装饰品⼯⼚
            FurnitureFactory factory = null;
            if (furnitureType.equals("modern")) {
                factory = new ModernFurnitureFactory();
            } else if (furnitureType.equals("classical")) {
                factory = new ClassicalFurnitureFactory();
            }
// 根据⼯⼚⽣产椅⼦和沙发
            Chair chair = factory.createChair();
            Sofa sofa = factory.createSofa();
// 输出家具信息
            chair.showInfo();
            sofa.displayInfo();
        }
    }
}