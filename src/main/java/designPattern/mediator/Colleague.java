package designPattern.mediator;

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    // 发送消息
    public abstract void send(String message);

    // 接收消息
    public abstract void receive(String message);
}