package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

// 主题接⼝ （主题）
interface Subject {
    // 注册观察者
    void registerObserver(Observer observer);

    // 移除观察者
    void removeObserver(Observer observer);

    // 通知观察者
    void notifyObservers();
}

// 观察者接⼝ (观察者)
interface Observer {
    // 更新⽅法
    void update(String message);
}

// 具体主题实现
class ConcreteSubject implements Subject {
    // 观察者列表
    private List<Observer> observers = new ArrayList<>();
    // 状态
    private String state;

    // 注册观察者
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // 移除观察者
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // 通知观察者
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
// 观察者根据传递的信息进⾏处理
            observer.update(state);
        }
    }

    // 更新状态
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

// 具体观察者实现
class ConcreteObserver implements Observer {
    // 更新⽅法
    @Override
    public void update(String message) {
    }
}