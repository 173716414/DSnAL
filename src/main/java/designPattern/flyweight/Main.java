package designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

// 步骤 1: 定义享元接⼝
interface Flyweight {
    // 操作外部状态
    void operation(String externalState);
}

// 步骤 2: 实现具体享元类
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState; // 内部状态
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    @Override
    public void operation(String externalState) {
        System.out.println("Intrinsic State: " + intrinsicState + ", External State: "
                + externalState);
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();
    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}
public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
// 获取或创建享元对象，并传递外部状态
        Flyweight flyweight1 = factory.getFlyweight("A");
        flyweight1.operation("External State 1");
        Flyweight flyweight2 = factory.getFlyweight("B");
        flyweight2.operation("External State 2");
        Flyweight flyweight3 = factory.getFlyweight("A"); // 重复使⽤已存在的享元对象
        flyweight3.operation("External State 3");
    }
}