package designPattern.statePattern;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        State state1 = new ConcreteState1();
        State state2 = new ConcreteState2();
        context.setState(state1);
        context.request(); // 执⾏在状态1下的操作
        context.setState(state2);
        context.request(); // 执⾏在状态2下的操作
    }
}