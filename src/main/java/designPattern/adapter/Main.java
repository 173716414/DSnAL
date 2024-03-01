package designPattern.adapter;// 测试程序

import java.util.Scanner;
import java.util.regex.Pattern;

// USB 接⼝
interface USB {
    void charge();
}

// TypeC 接⼝
interface TypeC {
    void chargeWithTypeC();
}

// 适配器类
class TypeCAdapter implements USB {
    private TypeC typeC;

    public TypeCAdapter(TypeC typeC) {
        this.typeC = typeC;
    }

    @Override
    public void charge() {
        typeC.chargeWithTypeC();
    }
}

// 新电脑类，使⽤ TypeC 接⼝
class NewComputer implements TypeC {
    @Override
    public void chargeWithTypeC() {
        System.out.println("TypeC");
    }
}

// 适配器充电器类，使⽤ USB 接⼝
class AdapterCharger implements USB {
    @Override
    public void charge() {
        System.out.println("USB Adapter");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// 读取连接次数
        int N = scanner.nextInt();
        scanner.nextLine(); // 消耗换⾏符
        for (int i = 0; i < N; i++) {
// 读取⽤户选择
            int choice = scanner.nextInt();
// 根据⽤户的选择创建相应对象
            if (choice == 1) {
                TypeC newComputer = new NewComputer();
                USB typeCAdapter = new TypeCAdapter(newComputer);
                typeCAdapter.charge();
            } else if (choice == 2) {
                USB usbAdapter = new AdapterCharger();
                usbAdapter.charge();
            }
        }
        scanner.close();
    }
}
