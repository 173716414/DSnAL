package test;

public class LogicExpressionBuilder {

    public static String buildLogic(String logicStr, int position, int size) {
        // 调整position，从1基数转换为0基数
        position = position - 1;

        // 查找position位置的数字
        StringBuilder numberBuilder = new StringBuilder();
        int startPos = position;

        while (position < logicStr.length() && Character.isDigit(logicStr.charAt(position))) {
            numberBuilder.append(logicStr.charAt(position));
            position++;
        }

        int originalNumber = Integer.parseInt(numberBuilder.toString());

        // 构建逻辑或表达式
        StringBuilder orExpression = new StringBuilder();
        if (size > 1) {
            orExpression.append("(");
        }
        for (int i = 0; i < size; i++) {
            orExpression.append(originalNumber + i);
            if (i < size - 1) {
                orExpression.append("|");
            }
        }
        if (size > 1) {
            orExpression.append(")");
        }

        // 构建新的逻辑表达式
        StringBuilder result = new StringBuilder();
        result.append(logicStr.substring(0, startPos));
        result.append(orExpression);

        // 更新position后面的数字
        int increment = size - 1;
        int pos = position;
        while (pos < logicStr.length()) {
            if (Character.isDigit(logicStr.charAt(pos))) {
                int digitStart = pos;
                while (pos < logicStr.length() && Character.isDigit(logicStr.charAt(pos))) {
                    pos++;
                }
                int number = Integer.parseInt(logicStr.substring(digitStart, pos));
                result.append(number + increment);
            } else {
                result.append(logicStr.charAt(pos));
                pos++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String logicStr = "(1|2)&3";
        int position = 2;  // 从1开始计数，这里2指的是第2个字符
        int size = 2;
        String result = buildLogic(logicStr, position, size);
        System.out.println("Result: " + result);  // 输出: (1|(2|3))&4
    }
}
