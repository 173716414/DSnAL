package designPattern.mediator;

// 客户端
public class Main1 {
    public static void main(String[] args) {
// 创建中介者
        Mediator mediator = new ConcreteMediator();
// 创建同事对象
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
// 注册同事对象到中介者
        mediator.register(colleague1);
        mediator.register(colleague2);
// 同事对象之间发送消息
        colleague1.send("Hello from Colleague1!");
        colleague2.send("Hi from Colleague2!");
    }
}