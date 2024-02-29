package designPattern.prototype;

// 2. 创建具体原型类
public class ConcretePrototype extends Prototype {
private String data;
public ConcretePrototype(String data) {
this.data = data;
}
@Override
public Prototype clone() {
return new ConcretePrototype(this.data);
}
public String getData() {
return data;
}
}