package designPattern.bridge;

import java.util.Scanner;

// 步骤1: 创建实现化接⼝
interface TV {
    void turnOn();

    void turnOff();

    void switchChannel();
}

// 步骤2: 创建具体实现化类
class SonyTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Sony TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV is OFF");
    }

    @Override
    public void switchChannel() {
        System.out.println("Switching Sony TV channel");
    }
}

class TCLTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("TCL TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TCL TV is OFF");
    }

    @Override
    public void switchChannel() {
        System.out.println("Switching TCL TV channel");
    }
}

// 步骤3: 创建抽象化接⼝
abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void performOperation();
}

// 步骤4: 创建扩充抽象化类
class PowerOperation extends RemoteControl {
    public PowerOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.turnOn();
    }
}

class OffOperation extends RemoteControl {
    public OffOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.turnOff();
    }
}

class ChannelSwitchOperation extends RemoteControl {
    public ChannelSwitchOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.switchChannel();
    }
}

// 步骤5: 客户端代码
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            int brand = Integer.parseInt(input[0]);
            int operation = Integer.parseInt(input[1]);
            TV tv;
            if (brand == 0) {
                tv = new SonyTV();
            } else {
                tv = new TCLTV();
            }
            RemoteControl remoteControl;
            if (operation == 2) {
                remoteControl = new PowerOperation(tv);
            } else if (operation == 3) {
                remoteControl = new OffOperation(tv);
            } else {
                remoteControl = new ChannelSwitchOperation(tv);
            }
            remoteControl.performOperation();
        }
        scanner.close();
    }
}