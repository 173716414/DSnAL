package designPattern.template;

// 模板类
abstract class AbstractClass {
    // 模板⽅法，定义了算法的⻣架
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    // 抽象⽅法，由⼦类实现
    protected abstract void step1();

    protected abstract void step2();

    protected abstract void step3();
}

// 具体类
class ConcreteClass extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("Step 1 ");
    }

    @Override
    protected void step2() {
        System.out.println("Step 2 ");
    }

    @Override
    protected void step3() {
        System.out.println("Step 3");
    }
}

public class Main1 {
    public static void main(String[] args) {
        AbstractClass concreteTemplate = new ConcreteClass();
// 触发整个算法的执⾏
        concreteTemplate.templateMethod();
    }
}