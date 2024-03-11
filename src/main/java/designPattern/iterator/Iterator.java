package designPattern.iterator;

// 迭代器接⼝
public interface Iterator {
    // 检查是否还会有下⼀个元素
    boolean hasNext();

    // 获取下⼀个元素
    Object next();
}