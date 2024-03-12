package designPattern.interpret;

public class TerminalExpression implements Expression {
    private int value;

    public TerminalExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}