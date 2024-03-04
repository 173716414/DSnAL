package designPattern.decorator;

// 定义⼀个抽象的装饰者类，继承⾃Component
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}