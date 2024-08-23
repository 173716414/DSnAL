package test;

import java.util.*;

public class MonsterAttack {

    static class Monster {
        int health;
        int experience;
        int index;

        Monster(int health, int experience, int index) {
            this.health = health;
            this.experience = experience;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] health = new int[n];
        int[] experience = new int[n];

        for (int i = 0; i < n; i++) {
            health[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            experience[i] = scanner.nextInt();
        }

        // Create a list of monsters with their original index
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            monsters.add(new Monster(health[i], experience[i], i));
        }
        
        // Sort monsters by health
        monsters.sort(Comparator.comparingInt(m -> m.health));

        // Array to store the minimum initial attack needed for each monster
        int[] minInitialAttack = new int[n];

        // Track current attack power
        int currentAttack = 0;
        
        // Compute minimum initial attack for each monster
        for (int i = 0; i < n; i++) {
            Monster monster = monsters.get(i);
            int minAttackForMonster = Math.max(0, monster.health - currentAttack);
            minInitialAttack[monster.index] = minAttackForMonster;
            currentAttack += minAttackForMonster + monster.experience;
        }

        // Print the results
        for (int attack : minInitialAttack) {
            System.out.println(attack);
        }

        scanner.close();
    }
}
