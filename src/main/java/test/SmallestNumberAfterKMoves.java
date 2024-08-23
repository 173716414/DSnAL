package test;

public class SmallestNumberAfterKMoves {
    public String removeKDigits(String num, int k) {
        if (k == 0) return num;
        if (num.length() == k) return "0";

        StringBuilder result = new StringBuilder();
        for (char digit : num.toCharArray()) {
            while (result.length() > 0 && result.charAt(result.length() - 1) > digit && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(digit);
        }
        
        // Remove remaining digits if k > 0
        while (k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        SmallestNumberAfterKMoves solver = new SmallestNumberAfterKMoves();
        System.out.println(solver.removeKDigits("1432219", 3)); // Output: 1219
        System.out.println(solver.removeKDigits("10200", 1));    // Output: 200
        System.out.println(solver.removeKDigits("10", 2));       // Output: 0
    }
}
