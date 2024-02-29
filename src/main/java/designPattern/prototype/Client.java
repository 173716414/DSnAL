package designPattern.prototype;

// 3. 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建原型对象
        Prototype original = new ConcretePrototype("Original Data");
        // 克隆原型对象
        Prototype clone = original.clone();
        // 输出克隆对象的数据
        System.out.println("Clone Data: " + ((ConcretePrototype) clone).getData());
    }
}