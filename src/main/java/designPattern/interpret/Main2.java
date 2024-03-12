package designPattern.interpret;

public class Main2 {
    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = new AddExpression(
                new TerminalExpression(1),
                new TerminalExpression(2)
        );
        int result = expression.interpret();
        System.out.println("Result: " + result);
    }
}