package designPattern.memento;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

// 备忘录
class Memento2 {
    private int value;

    public Memento2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// 发起⼈（Originator）
class Counter {
    private int value;
    private Stack<Memento2> undoStack = new Stack<>();
    private Stack<Memento2> redoStack = new Stack<>();

    public void increment() {
        redoStack.clear();
        undoStack.push(new Memento2(value));
        value++;
    }

    public void decrement() {
        redoStack.clear();
        undoStack.push(new Memento2(value));
        value--;
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(new Memento2(value));
            value = undoStack.pop().getValue();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(new Memento2(value));
            value = redoStack.pop().getValue();
        }
    }

    public int getValue() {
        return value;
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter();
// 处理计数器应⽤的输⼊
        while (scanner.hasNext()) {
            String operation = scanner.next();
            switch (operation) {
                case "Increment":
                    counter.increment();
                    break;
                case "Decrement":
                    counter.decrement();
                    break;
                case "Undo":
                    counter.undo();
                    break;
                case "Redo":
                    counter.redo();
                    break;
            }
// 输出当前计数器的值
            System.out.println(counter.getValue());
        }
        scanner.close();
    }
}