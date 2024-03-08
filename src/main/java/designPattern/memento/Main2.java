package designPattern.memento;

import java.util.ArrayList;
import java.util.List;

class Memento {
    private String state;
    // 保存发起⼈的状态
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
class Originator {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    // 创建备忘录对象
    public Memento createMemento() {
        return new Memento(state);
    }
    // 通过备忘录对象恢复状态
    public void restoreFromMemento(Memento memento) {
                state = memento.getState();
    }
}

class Caretaker {
    private List<Memento> mementos = new ArrayList<>();
    public void addMemento(Memento memento) {
        mementos.add(memento);
    }
    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}
public class Main2 {
    public static void main(String[] args) {
// 创建发起⼈对象
        Originator originator = new Originator();
        originator.setState("State 1");
// 创建管理者对象
        Caretaker caretaker = new Caretaker();
// 保存当前状态
        caretaker.addMemento(originator.createMemento());
// 修改状态使⽤场景
        originator.setState("State 2");
// 再次保存当前状态
        caretaker.addMemento(originator.createMemento());
// 恢复到先前状态
        originator.restoreFromMemento(caretaker.getMemento(0));
        System.out.println("Current State: " + originator.getState());
    }
}