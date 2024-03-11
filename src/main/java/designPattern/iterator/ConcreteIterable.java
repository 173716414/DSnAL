package designPattern.iterator;

import java.util.List;

// 具体聚合
public class ConcreteIterable implements Iterable {
    private List<Object> elements;

    // 构造函数初始化可迭代对象
    public ConcreteIterable(List<Object> elements) {
        this.elements = elements;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}