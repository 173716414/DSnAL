package designPattern.command;

import java.util.Scanner;

// 命令接⼝
// interface Command {
//     void execute();
// }

// 具体命令类 - 点餐命令
class OrderCommand implements Command {
    private String drinkName;
    private DrinkMaker receiver;

    public OrderCommand(String drinkName, DrinkMaker receiver) {
        this.drinkName = drinkName;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.makeDrink(drinkName);
    }
}

// 接收者类 - 制作饮品
class DrinkMaker {
    public void makeDrink(String drinkName) {
        System.out.println(drinkName + " is ready!");
    }
}

// 调⽤者类 - 点餐机
class OrderMachine {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeOrder() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// 创建接收者和命令对象
        DrinkMaker drinkMaker = new DrinkMaker();
// 读取命令数量
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换⾏符
        while (n-- > 0) {
// 读取命令
            String drinkName = scanner.next();
// 创建命令对象
            Command command = new OrderCommand(drinkName, drinkMaker);
// 执⾏命令
            OrderMachine orderMachine = new OrderMachine();
            orderMachine.setCommand(command);
            orderMachine.executeOrder();
        }
        scanner.close();
    }
}