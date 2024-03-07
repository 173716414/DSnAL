package designPattern.mediator;

import java.util.*;

// 抽象中介者
interface ChatRoomMediator {
    void sendMessage(String sender, String message);

    void addUser(ChatUser user);

    Map<String, ChatUser> getUsers();
}
// 具体中介者

class ChatRoomMediatorImpl implements ChatRoomMediator {
    private Map<String, ChatUser> users = new LinkedHashMap<>();

    @Override
    public void sendMessage(String sender, String message) {
        for (ChatUser user : users.values()) {
            if (!user.getName().equals(sender)) {
                user.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(ChatUser user) {
        users.put(user.getName(), user);
    }

    @Override
    public Map<String, ChatUser> getUsers() {
        return users;
    }
}

// 抽象同事类
abstract class ChatUser {
    private String name;
    private ChatRoomMediator mediator;
    // private List<String> receivedMessages = new ArrayList<>();

    public ChatUser(String name, ChatRoomMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(name, message);
    }

    public abstract void receiveMessage(String message);

    // public List<String> getReceivedMessages() {
    //     return receivedMessages;
    // }

    // protected void addReceivedMessage(String message) {
    //     receivedMessages.add(message);
    // }
}

// 具体同事类
class ConcreteChatUser extends ChatUser {
    public ConcreteChatUser(String name, ChatRoomMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receiveMessage(String message) {
        String receivedMessage = getName() + " received: " + message;
        // addReceivedMessage(receivedMessage);
        System.out.println(receivedMessage);
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<String> userNames = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            userNames.add(scanner.next());
        }
        ChatRoomMediator mediator = new ChatRoomMediatorImpl();
// 创建⽤户对象
        for (String userName : userNames) {
            new ConcreteChatUser(userName, mediator);
        }
// 发送消息并输出
        while (scanner.hasNext()) {
            String sender = scanner.next();
            String message = scanner.next();
            ChatUser user = mediator.getUsers().get(sender);
            if (user != null) {
                user.sendMessage(message);
            }
        }
        scanner.close();
    }
}