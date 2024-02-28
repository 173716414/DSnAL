package designPattern.builder;

// 客户端代码
public class Main {
    public static void main(String[] args) {
// 创建具体建造者
        Builder builder = new ConcreteBuilder();
// 创建指导者
        Director director = new Director(builder);
// 指导者构建产品
        director.construct();
// 获取构建好的产品
        Product product = builder.getResult();
// 输出产品信息
        System.out.println(product);
    }
}