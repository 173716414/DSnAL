package test;

import java.util.*;

public class SacredMarkTraining {
    static class Mark {
        int L, R, T, D;

        public Mark(int L, int R, int T, int D) {
            this.L = L;
            this.R = R;
            this.T = T;
            this.D = D;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of seals
        int n = scanner.nextInt();

        // Initialize the seals array
        Mark[] seals = new Mark[n];
        for (int i = 0; i < n; i++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            int T = scanner.nextInt();
            int D = scanner.nextInt();
            seals[i] = new Mark(L, R, T, D);
        }

        // Sort seals by L
        Arrays.sort(seals, Comparator.comparingInt(seal -> seal.L));

        // Initialize res
        int res = 0;
        int index = 0;

        // Priority queue ordered by T
        PriorityQueue<Mark> pq = new PriorityQueue<>(Comparator.comparingInt(seal -> seal.T));

        while (true) {
            // Add all seals that can now be activated to the priority queue
            while (index < n && seals[index].L <= res) {
                if (res <= seals[index].R) {
                    pq.offer(seals[index]);
                }
                index++;
            }

            // Remove seals that can no longer be activated
            while (!pq.isEmpty() && pq.peek().R < res) {
                pq.poll();
            }

            if (pq.isEmpty()) {
                break;
            }

            // Get the minimal T
            int minT = pq.peek().T;

            // Collect all seals with minimal T
            List<Mark> activatedMarks = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek().T == minT) {
                Mark seal = pq.poll();
                if (res <= seal.R) {
                    activatedMarks.add(seal);
                }
            }

            // Sum D and update res
            for (Mark seal : activatedMarks) {
                res += seal.D;
            }
        }

        System.out.println(res);

        scanner.close();
    }
}
