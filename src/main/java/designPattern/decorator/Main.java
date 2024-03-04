package designPattern.decorator;

public class Main {
    public static void main(String[] args) {
        // 创建具体组件
        Component concreteComponent = new ConcreteComponent();
        // 使⽤具体装饰者包装具体组件
        Decorator decorator = new ConcreteDecorator(concreteComponent);
        // 调⽤操作
        decorator.operation();
    }
}