package designPattern.statePattern;

// 上下⽂类
public class Context {
    private State currentState;

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle();
    }
}