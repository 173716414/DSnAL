package designPattern.interpret;

import java.util.Scanner;
import java.util.Stack;

/*
 *Author：Victor_htq
 *Package：designPattern.interpret
 *Project：DSnAL
 *name：Main
 *Date：2024/3/12  16:07
 *Filename：Main
 */
interface Exp {
    int interpret();
}

class Num implements Exp {
    private int val;

    Num(int val) {
        this.val = val;
    }

    @Override
    public int interpret() {
        return val;
    }
}

class Add implements Exp {
    private Exp exp1;
    private Exp exp2;

    Add(Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public int interpret() {
        return exp1.interpret() + exp2.interpret();
    }
}

class Multi implements Exp {
    private Exp exp1;
    private Exp exp2;

    Multi(Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public int interpret() {
        return exp1.interpret() * exp2.interpret();
    }
}

class Context2 {
    private Stack<Exp> expressionStack = new Stack<>();

    public void pushExpression(Exp expression) {
        expressionStack.add(expression);
    }

    public Exp popExpression() {
        return expressionStack.pop();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] all = scanner.nextLine().split(" ");
            int num1 = Integer.parseInt(all[0]);
            int num2 = Integer.parseInt(all[2]);
            Exp numExp1 = new Num(num1);
            Exp numExp2 = new Num(num2);
            if (all[1].equals("+")) {
                System.out.println(
                        new Add(numExp1, numExp2).interpret()
                );
            } else {
                System.out.println(
                        new Multi(numExp1, numExp2).interpret()
                );
            }
        }
    }

    // 解析⽤户输⼊的数学表达式并返回相应的抽象表达式类
    private static Exp parseExpression(String userInput) {
        try {
            Stack<Exp> expressionStack = new Stack<>();
            char[] tokens = userInput.toCharArray();
            for (int i = 0; i < tokens.length; i++) {
                char token = tokens[i];
                if (Character.isDigit(token)) {
                    expressionStack.push((Exp) new
                            Num(Character.getNumericValue(token)));
// 如果下⼀个字符不是数字，且栈中有两个以上的元素，说明可以进⾏运算
                    if (i + 1 < tokens.length && !Character.isDigit(tokens[i + 1]) &&
                            expressionStack.size() >= 2) {
                        Exp right = expressionStack.pop();
                        Exp left = expressionStack.pop();
                        char operator = tokens[i + 1];
                        if (operator == '+') {
                            expressionStack.push(new Add(left, right));
                        } else if (operator == '*') {
                            expressionStack.push(new Multi((Exp) left, right));
                        }
                        i++; // 跳过下⼀个字符，因为已经处理过了
                    }
                } else {
                    return null; // Invalid token
                }
            }
            return expressionStack.pop();
        } catch (Exception e) {
            return null;
        }
    }
}
