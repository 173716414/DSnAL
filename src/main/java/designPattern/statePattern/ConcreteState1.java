package designPattern.statePattern;

// 具体状态类1
public class ConcreteState1 implements State {
    @Override
    public void handle() {
// 执⾏在状态1下的操作
        System.out.println("handle1");
    }
}

