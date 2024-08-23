package interview;

/*
 *Author：Victor_htq
 *Package：interview
 *Project：DSnAL
 *name：Main
 *Date：2024/8/15  16:05
 *Filename：Main
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 定义各组节点
        String[] groupA = {"A0", "A1"};
        String[] groupB = {"B0", "B1"};
        String[] groupC = {"C0", "C1"};

        // 将所有节点组合成一个列表以进行排列
        List<String> allNodes = new ArrayList<>();
        allNodes.add(groupA[0]);
        allNodes.add(groupA[1]);
        allNodes.add(groupB[0]);
        allNodes.add(groupB[1]);
        allNodes.add(groupC[0]);
        allNodes.add(groupC[1]);

        // 生成所有排列
        List<List<String>> result = new ArrayList<>();
        permute(allNodes, 0, result);

        // 只打印出有效的排列
        for (List<String> permutation : result) {
            if (isValid(permutation, groupA, groupB, groupC)) {
                System.out.println(permutation);
            }
        }
    }

    // 生成所有排列的函数
    public static void permute(List<String> nodes, int index, List<List<String>> result) {
        if (index == nodes.size()) {
            result.add(new ArrayList<>(nodes));
            return;
        }

        for (int i = index; i < nodes.size(); i++) {
            swap(nodes, index, i);
            permute(nodes, index + 1, result);
            swap(nodes, index, i);
        }
    }

    // 检查排列是否有效的函数
    public static boolean isValid(List<String> permutation, String[] groupA, String[] groupB, String[] groupC) {
        return (permutation.indexOf(groupA[0]) < permutation.indexOf(groupA[1])) &&
                (permutation.indexOf(groupB[0]) < permutation.indexOf(groupB[1])) &&
                (permutation.indexOf(groupC[0]) < permutation.indexOf(groupC[1]));
    }

    // 用于交换列表中元素的函数
    public static void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
