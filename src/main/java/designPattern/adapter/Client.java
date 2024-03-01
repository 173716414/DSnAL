package designPattern.adapter;

// ⽬标接⼝
interface Target {
    void request();
}

// 被适配者类
class Adaptee {
    void specificRequest() {
        System.out.println("Specific request");
    }
}

// 适配器类
class Adapter implements Target {
    // 持有⼀个被适配者实例
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
// 调⽤被适配者类的⽅法
        adaptee.specificRequest();
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}