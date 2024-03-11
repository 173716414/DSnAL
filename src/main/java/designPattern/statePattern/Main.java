package designPattern.statePattern;

import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：designPattern.statePattern
 *Project：DSnAL
 *name：Main
 *Date：2024/3/11  9:48
 *Filename：Main
 */
interface LampState {
    void handle();
}

class OnState implements LampState {

    @Override
    public void handle() {
        System.out.println("Light is ON");
    }
}

class OffState implements LampState {

    @Override
    public void handle() {
        System.out.println("Light is OFF");
    }
}

class BlinkState implements LampState {

    @Override
    public void handle() {
        System.out.println("Light is Blinking");
    }
}

class LampContext {
    private LampState state;

    void setState(LampState state) {
        this.state = state;
    }

    void request() {
        state.handle();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        LampContext lampContext = new LampContext();
        while (count-- > 0) {
            String state = scanner.nextLine();
            switch (state) {
                case "ON":
                    lampContext.setState(new OnState());

                    break;
                case "OFF":
                    lampContext.setState(new OffState());

                    break;
                case "BLINK":
                    lampContext.setState(new BlinkState());

                    break;
                default:
            }
            lampContext.request();
        }
    }

}
