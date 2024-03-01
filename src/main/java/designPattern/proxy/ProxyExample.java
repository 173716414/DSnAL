package designPattern.proxy;

// 1. 定义抽象主题
interface Subject {
    void request();
}

// 2. 定义真实主题
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject handles the request.");
    }
}

// 3. 定义代理
class Proxy implements Subject {
    // 包含⼀个引⽤
    private RealSubject realSubject;

    @Override
    public void request() {
        // 在访问真实主题之前可以添加额外的逻辑
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // 调⽤真实主题的⽅法
        realSubject.request();
        // 在访问真实主题之后可以添加额外的逻辑
    }
}

// 4. 客户端使⽤代理
public class ProxyExample {
    public static void main(String[] args) {
// 使⽤代理
        Subject proxy = new Proxy();
        proxy.request();
    }
}