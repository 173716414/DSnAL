package designPattern.decorator;

import java.io.BufferedReader;
import java.io.BufferedWriter;

// 具体的装饰者实现
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    // 根据需要添加额外的⽅法
    @Override
    public void operation() {
        // 可以在调⽤前后添加额外的⾏为
        System.out.println("Before operation in ConcreteDecorator");
        super.operation();
        System.out.println("After operation in ConcreteDecorator");
    }
}