package designPattern.command;

import designPattern.command.Command;

public class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.execute();
    }
}