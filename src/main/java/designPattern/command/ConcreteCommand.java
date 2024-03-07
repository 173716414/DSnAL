package designPattern.command;

public class ConcreteCommand implements Command {
    // 接收者对象
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
// 调⽤接收者相应的操作
        receiver.action();
    }
}