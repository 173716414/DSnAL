package designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorPatternExample {
    public static void main(String[] args) {
        List<Object> elements = new ArrayList<>();
        elements.add("Element 1");
        elements.add("Element 2");
        elements.add("Element 3");
        Iterable iterable = new ConcreteIterable(elements);
        Iterator iterator = iterable.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}