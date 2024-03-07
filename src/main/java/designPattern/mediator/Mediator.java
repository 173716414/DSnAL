package designPattern.mediator;

// 抽象中介者
public abstract class Mediator {
    abstract void register(Colleague colleague);

    // 定义⼀个抽象的发送消息⽅法
    public abstract void send(String message, Colleague colleague);
}