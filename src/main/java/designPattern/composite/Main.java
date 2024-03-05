package designPattern.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Component {
    void display(int depth);
}

class Department implements Component {
    private String name;
    private List<Component> children;

    public Department(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" ");
        }
        System.out.println(indent + name);
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}

class Employee implements Component {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" ");
        }
        System.out.println(indent + "  " + name);
    }
}

class Company {
    private String name;
    private Department root;

    public Company(String name) {
        this.name = name;
        this.root = new Department(name);
    }

    public void add(Component component) {
        root.add(component);
    }

    public void display() {
        System.out.println("Company Structure:");
        root.display(0); // 从 1 开始，以适配指定的缩进格式
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// 读取公司名称
        String companyName = scanner.nextLine();
        Company company = new Company(companyName);
// 读取部⻔和员⼯数量
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换⾏符
// 读取部⻔和员⼯信息
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.nextLine().trim();
            if ("D".equals(type)) {
                Department department = new Department(name);
                company.add(department);
            } else if ("E".equals(type)) {
                Employee employee = new Employee(name);
                company.add(employee);
            }
        }
// 输出公司组织结构
        company.display();
    }
}