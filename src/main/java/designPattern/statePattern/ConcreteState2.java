package designPattern.statePattern;

// 具体状态类2
public class ConcreteState2 implements State {
    @Override
    public void handle() {
// 执⾏在状态2下的操作
        System.out.println("handle 2");
    }
}