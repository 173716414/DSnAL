package designPattern.responsibility;

import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：designPattern.responsibility
 *Project：DSnAL
 *name：Main
 *Date：2024/3/11  10:18
 *Filename：Main
 */
// 请求类
class LeaveRequest {
    private String name;
    private int days;
    public LeaveRequest(String name, int days) {
        this.name = name;
        this.days = days;
    }
    public String getName() {
        return name;
    }
    public int getDays() {
        return days;
    }
}

interface LeaveHandler {
    void handleRequest(LeaveRequest request);
}

class Supervisor implements LeaveHandler {
    private static final int MAX_DAYS_SUPERVIOR_CAN_APPROVE = 3;
    private LeaveHandler nextHandler;

    public Supervisor(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS_SUPERVIOR_CAN_APPROVE) {
            System.out.println(request.getName() + " Approved by Supervisor.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println(request.getName() + " Denied by Supervisor.");
        }
    }
}

class Manager implements LeaveHandler {
    private static final int MAX_DAYS_SUPERVIOR_CAN_APPROVE = 7;
    private LeaveHandler nextHandler;

    public Manager(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS_SUPERVIOR_CAN_APPROVE) {
            System.out.println(request.getName() + " Approved by Manager.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println(request.getName() + " Denied by Manager.");
        }
    }
}

class Director implements LeaveHandler {
    private static final int MAX_DAYS_SUPERVIOR_CAN_APPROVE = 10;

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS_SUPERVIOR_CAN_APPROVE) {
            System.out.println(request.getName() + " Approved by Director.");
        } else {
            System.out.println(request.getName() + " Denied by Director.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        // 倒着组装责任链
        LeaveHandler director = new Director();
        LeaveHandler manager = new Manager(director);
        LeaveHandler supervisor = new Supervisor(manager);

        while (n-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 2) {
                String name = input[0];
                int days = Integer.parseInt(input[1]);
                LeaveRequest leaveRequest = new LeaveRequest(name, days);
                supervisor.handleRequest(leaveRequest);
            } else {
                System.out.println("bad request");
                return;
            }
        }
    }
}
