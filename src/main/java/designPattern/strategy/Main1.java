package designPattern.strategy;

// 1. 抽象策略抽象类
abstract class Strategy {
    // 抽象⽅法
    public abstract void algorithmInterface();
}

// 2. 具体策略类1
class ConcreteStrategyA extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("Strategy A");
// 具体的策略1执⾏逻辑
    }
}

// 3. 具体策略类2
class ConcreteStrategyB extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("Strategy B");
// 具体的策略2执⾏逻辑
    }
}

// 4. 上下⽂类
class Context {
    private Strategy strategy;
// 设置具体的策略使⽤场景
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 执⾏策略
    public void contextInterface() {
        strategy.algorithmInterface();
    }
}

// 5. 客户端代码
public class Main1 {
    public static void main(String[] args) {
// 创建上下⽂对象，并设置具体的策略
        Context contextA = new Context(new ConcreteStrategyA());
// 执⾏策略
        contextA.contextInterface();
        Context contextB = new Context(new ConcreteStrategyB());
        contextB.contextInterface();
    }
}