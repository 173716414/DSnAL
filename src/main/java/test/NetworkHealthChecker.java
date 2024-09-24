package test;

import java.util.*;
import java.util.regex.*;

public class NetworkHealthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取 n 和 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        // 读取 n 个表达式
        List<String> expressions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            expressions.add(scanner.nextLine().trim());
        }

        // 读取 m 个键值对
        Map<String, String> keyValues = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] keyValue = scanner.nextLine().trim().split("\\s+");
            keyValues.put(keyValue[0], keyValue[1]);
        }

        // 对每个表达式进行解析和评估
        for (String expr : expressions) {
            List<String> tokens = tokenize(expr);
            Evaluator evaluator = new Evaluator(tokens, keyValues);
            boolean result = evaluator.parseExpression();

            // 输出结果：0 表示健康，1 表示不健康
            System.out.println(result ? 0 : 1);
        }

        scanner.close();
    }

    // 令牌化函数
    private static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "\\s*(AND|OR|\\(|\\)|=|'[^']*'|[a-zA-Z_][a-zA-Z0-9_]*)\\s*");
        Matcher matcher = pattern.matcher(expr);
        while (matcher.find()) {
            String token = matcher.group(1).trim();
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }
        return tokens;
    }

    // 评估器类
    static class Evaluator {
        private List<String> tokens;
        private int pos;
        private Map<String, String> keyValues;

        public Evaluator(List<String> tokens, Map<String, String> keyValues) {
            this.tokens = tokens;
            this.pos = 0;
            this.keyValues = keyValues;
        }

        public boolean parseExpression() {
            return parseOrExpression();
        }

        private boolean parseOrExpression() {
            boolean left = parseAndExpression();
            while (match("OR")) {
                boolean right = parseAndExpression();
                left = left || right;
            }
            return left;
        }

        private boolean parseAndExpression() {
            boolean left = parseComparison();
            while (match("AND")) {
                boolean right = parseComparison();
                left = left && right;
            }
            return left;
        }

        private boolean parseComparison() {
            if (match("(")) {
                boolean expr = parseOrExpression();
                expect(")");
                return expr;
            } else {
                String fieldName = expectFieldName();
                expect("=");
                String value = expectStringLiteral();
                String actualValue = keyValues.getOrDefault(fieldName, "");
                return actualValue.equals(value);
            }
        }

        private boolean match(String expectedToken) {
            if (pos < tokens.size() && tokens.get(pos).equals(expectedToken)) {
                pos++;
                return true;
            }
            return false;
        }

        private void expect(String expectedToken) {
            if (!match(expectedToken)) {
                throw new RuntimeException("预期的令牌: '" + expectedToken + "', 但找到: '" + tokens.get(pos) + "'");
            }
        }

        private String expectFieldName() {
            if (pos < tokens.size()) {
                String token = tokens.get(pos);
                if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                    pos++;
                    return token;
                }
            }
            throw new RuntimeException("预期字段名，但找到: '" + tokens.get(pos) + "'");
        }

        private String expectStringLiteral() {
            if (pos < tokens.size()) {
                String token = tokens.get(pos);
                if (token.matches("'[^']*'")) {
                    pos++;
                    return token.substring(1, token.length() - 1); // 去除引号
                }
            }
            throw new RuntimeException("预期字符串字面量，但找到: '" + tokens.get(pos) + "'");
        }
    }
}
