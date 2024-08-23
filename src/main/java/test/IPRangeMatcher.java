package test;

import java.util.*;

public class IPRangeMatcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<String[]> s = new ArrayList<>();
        List<String[]> c = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s.add(scanner.nextLine().split(" "));
        }
        for (int i = 0; i < M; i++) {
            c.add(scanner.nextLine().split(" "));
        }

        // 构建索引
        Map<Key, Set<Integer>> index = buildIndex(s);

        // 匹配连接
        List<List<Integer>> ans = matchConnection(c, index);

        for (List<Integer> a : ans) {
            System.out.println(String.join(" ", a.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }

    static class Key {
        Integer[] srcIpRange;
        Integer[] srcPortRange;
        Integer[] dstIpRange;
        Integer[] dstPortRange;
        int protocolRange;

        Key(Integer[] srcIpRange, Integer[] srcPortRange, Integer[] dstIpRange, Integer[] dstPortRange, int protocolRange) {
            this.srcIpRange = srcIpRange;
            this.srcPortRange = srcPortRange;
            this.dstIpRange = dstIpRange;
            this.dstPortRange = dstPortRange;
            this.protocolRange = protocolRange;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return protocolRange == key.protocolRange &&
                    Arrays.equals(srcIpRange, key.srcIpRange) &&
                    Arrays.equals(srcPortRange, key.srcPortRange) &&
                    Arrays.equals(dstIpRange, key.dstIpRange) &&
                    Arrays.equals(dstPortRange, key.dstPortRange);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(protocolRange);
            result = 31 * result + Arrays.hashCode(srcIpRange);
            result = 31 * result + Arrays.hashCode(srcPortRange);
            result = 31 * result + Arrays.hashCode(dstIpRange);
            result = 31 * result + Arrays.hashCode(dstPortRange);
            return result;
        }
    }

    public static Integer[] parseIpRange(String ipRange) {
        if (ipRange.equals("0.0.0.0")) {
            return null;
        }
        if (ipRange.contains("-")) {
            String[] parts = ipRange.split("-");
            return new Integer[]{ipToInt(parts[0]), ipToInt(parts[1])};
        }
        return new Integer[]{ipToInt(ipRange), ipToInt(ipRange)};
    }

    public static Integer[] parsePortRange(String portRange) {
        if (portRange.equals("0")) {
            return null;
        }
        if (portRange.contains("-")) {
            String[] parts = portRange.split("-");
            return new Integer[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
        }
        return new Integer[]{Integer.parseInt(portRange), Integer.parseInt(portRange)};
    }

    public static int ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        int[] intParts = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        return (intParts[0] << 24) + (intParts[1] << 16) + (intParts[2] << 8) + intParts[3];
    }

    public static String intToIp(int ipInt) {
        return (ipInt >> 24 & 0xFF) + "." +
                (ipInt >> 16 & 0xFF) + "." +
                (ipInt >> 8 & 0xFF) + "." +
                (ipInt & 0xFF);
    }

    public static boolean matchIp(String ip, Integer[] ipRange) {
        if (ipRange == null) {
            return true;
        }
        int ipInt = ipToInt(ip);
        return ipRange[0] <= ipInt && ipInt <= ipRange[1];
    }

    public static boolean matchPort(int port, Integer[] portRange) {
        if (portRange == null) {
            return true;
        }
        return portRange[0] <= port && port <= portRange[1];
    }

    public static boolean matchProtocol(int protocol, int protocolRange) {
        if (protocolRange == 0) {
            return true;
        }
        return protocol == protocolRange;
    }

    public static Map<Key, Set<Integer>> buildIndex(List<String[]> s) {
        Map<Key, Set<Integer>> index = new HashMap<>();
        for (String[] policy : s) {
            int policyId = Integer.parseInt(policy[0]);
            Integer[] srcIpRange = parseIpRange(policy[1]);
            Integer[] srcPortRange = parsePortRange(policy[2]);
            Integer[] dstIpRange = parseIpRange(policy[3]);
            Integer[] dstPortRange = parsePortRange(policy[4]);
            int protocolRange = Integer.parseInt(policy[5]);

            Key key = new Key(srcIpRange, srcPortRange, dstIpRange, dstPortRange, protocolRange);
            index.putIfAbsent(key, new HashSet<>());
            index.get(key).add(policyId);
        }
        return index;
    }

    public static List<List<Integer>> matchConnection(List<String[]> c, Map<Key, Set<Integer>> index) {
        List<List<Integer>> ans = new ArrayList<>();
        for (String[] connection : c) {
            String srcIp = connection[0];
            int srcPort = Integer.parseInt(connection[1]);
            String dstIp = connection[2];
            int dstPort = Integer.parseInt(connection[3]);
            int protocol = Integer.parseInt(connection[4]);

            Set<Integer> matchedPolicies = new HashSet<>();
            for (Map.Entry<Key, Set<Integer>> entry : index.entrySet()) {
                Key key = entry.getKey();
                if (matchIp(srcIp, key.srcIpRange) &&
                        matchPort(srcPort, key.srcPortRange) &&
                        matchIp(dstIp, key.dstIpRange) &&
                        matchPort(dstPort, key.dstPortRange) &&
                        matchProtocol(protocol, key.protocolRange)) {
                    matchedPolicies.addAll(entry.getValue());
                }
            }

            if (!matchedPolicies.isEmpty()) {
                List<Integer> sortedPolicies = new ArrayList<>(matchedPolicies);
                Collections.sort(sortedPolicies);
                ans.add(sortedPolicies);
            } else {
                ans.add(Collections.singletonList(0));
            }
        }
        return ans;
    }
}