package designPattern.mediator;

import java.util.ArrayList;
import java.util.List;

// 具体中介者
public class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague colleague) {
        for (Colleague c : colleagues) {
// 排除发送消息的同事对象
            if (c != colleague) {
                c.receive(message);
            }
        }
    }
}