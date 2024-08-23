package test;

public class IPPortToUint64 {
    public static long ipPortToUint64(String ipPort) {
        // 分割IP和端口
        String[] parts = ipPort.split(":");
        String ip = parts[0];
        int port = Integer.parseInt(parts[1]);

        // 分割IP地址为四个部分
        String[] ipParts = ip.split("\\.");
        long ipInt = 0;

        // 将每个部分转换为字节并组合成32位整数
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(ipParts[i]);
            ipInt |= (num & 0xFF);
            if (i < 3) {
                ipInt <<= 8;
            }
        }

        // 将IP整数左移32位并加上端口号
        long result = (ipInt << 32) | (port & 0xFFFFFFFFL);

        return result;
    }

    public static void main(String[] args) {
        String ipPort = "127.0.0.1:8080";
        long result = ipPortToUint64(ipPort);
        System.out.println("结果: " + result);
    }
}
