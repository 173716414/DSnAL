package test;

import java.util.*;

public class Main {
    static class Seal {
        int Li, Ri, Ti, Di;
        boolean activated = false;
        boolean activating = false;
        int activationId = 0;

        public Seal(int Li, int Ri, int Ti, int Di) {
            this.Li = Li;
            this.Ri = Ri;
            this.Ti = Ti;
            this.Di = Di;
        }
    }

    static class Event implements Comparable<Event> {
        int time;
        int sealIndex;
        int activationId;

        public Event(int time, int sealIndex, int activationId) {
            this.time = time;
            this.sealIndex = sealIndex;
            this.activationId = activationId;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 圣印数量
        Seal[] seals = new Seal[n];

        for (int i = 0; i < n; i++) {
            int Li = in.nextInt();
            int Ri = in.nextInt();
            int Ti = in.nextInt();
            int Di = in.nextInt();
            seals[i] = new Seal(Li, Ri, Ti, Di);
        }

        // 按 Li 升序排序
        Arrays.sort(seals, Comparator.comparingInt(s -> s.Li));

        int S = 0; // 初始修炼值
        int time = 0; // 当前时间
        int index = 0; // seals 数组的索引

        PriorityQueue<Event> eventQueue = new PriorityQueue<>();

        // 初始激活
        while (index < n && seals[index].Li <= S) {
            Seal seal = seals[index];
            if (!seal.activated && !seal.activating && seal.Ri >= S) {
                seal.activating = true;
                seal.activationId++;
                int endTime = time + seal.Ti;
                eventQueue.offer(new Event(endTime, index, seal.activationId));
            }
            index++;
        }

        // 开始事件循环
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            time = event.time;
            int sealIndex = event.sealIndex;
            Seal seal = seals[sealIndex];

            // 处理激活完成事件
            if (seal.activationId == event.activationId && seal.activating) {
                seal.activated = true;
                seal.activating = false;
                S += seal.Di;
            }

            // 检查激活中断
            for (int i = 0; i < n; i++) {
                Seal s = seals[i];
                if (s.activating && (S < s.Li || S > s.Ri)) {
                    s.activating = false;
                    s.activationId++; // 使之前的激活事件失效
                }
            }

            // 检查新的激活
            while (index < n && seals[index].Li <= S) {
                Seal s = seals[index];
                if (!s.activated && !s.activating && s.Ri >= S) {
                    s.activating = true;
                    s.activationId++;
                    int endTime = time + s.Ti;
                    eventQueue.offer(new Event(endTime, index, s.activationId));
                }
                index++;
            }
        }

        // 输出最终的修炼值
        System.out.println(S);

        in.close();
    }
}
