import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取怪兽数量
        int n = scanner.nextInt();
        
        // 读取每只怪兽的血量和经验值
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        
        // 将怪兽信息打包成元组 (血量, 经验值)
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            monsters.add(new Monster(a[i], b[i]));
        }
        
        // 按照血量从小到大排序，如果血量相同，按照经验值从大到小排序
        Collections.sort(monsters);
        
        // 初始化最小初始攻击力列表
        int[] minAttack = new int[n];
        int currentAttack = 0;
        
        for (int i = 0; i < n; i++) {
            // 当前怪兽的血量和经验值
            int hp = monsters.get(i).hp;
            int exp = monsters.get(i).exp;
            
            // 如果当前攻击力小于怪兽血量，则需要增加初始攻击力
            if (currentAttack < hp) {
                minAttack[i] = hp;
                currentAttack = hp;
            }
            
            // 打败当前怪兽后，攻击力增加经验值
            currentAttack += exp;
        }
        
        // 输出结果
        for (int res : minAttack) {
            System.out.println(res);
        }
    }
    
    // 定义一个Monster类，实现Comparable接口以便排序
    static class Monster implements Comparable<Monster> {
        int hp;
        int exp;
        
        Monster(int hp, int exp) {
            this.hp = hp;
            this.exp = exp;
        }
        
        @Override
        public int compareTo(Monster other) {
            if (this.hp != other.hp) {
                return Integer.compare(this.hp, other.hp);
            } else {
                return Integer.compare(other.exp, this.exp); // 经验值从大到小排序
            }
        }
    }
}