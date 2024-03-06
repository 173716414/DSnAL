package designPattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 观察者接⼝
interface Observer {
    void update(int hour);
}

// 主题接⼝
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// 具体主题实现
class Clock implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int hour = 0;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void tick() {
        hour = (hour + 1) % 24; // 模拟时间的推移
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(hour);
        }
    }

}

// 具体观察者实现
class Student implements Observer {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(int hour) {
        System.out.println(name + " " + hour);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取学⽣数量
        int N = scanner.nextInt();
        // 创建时钟
        Clock clock = new Clock();
        // 注册学⽣观察者
        for (int i = 0; i < N; i++) {
            String studentName = scanner.next();
            clock.registerObserver(new Student(studentName));
        }
        // 读取时钟更新次数
        int updates = scanner.nextInt();
        // 模拟时钟每隔⼀个⼩时更新⼀次
        for (int i = 0; i < updates; i++) {
            clock.tick();
        }
    }
}