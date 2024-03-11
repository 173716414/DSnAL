package designPattern.iterator;

import java.util.List;

public class ConcreteIterator implements Iterator {
    private int index;
    private List<Object> elements;

    // 构造函数初始化迭代器
    public ConcreteIterator(List<Object> elements) {
        this.elements = elements;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < elements.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return elements.get(index++);
        }
        return null;
    }
}