package designPattern.visitor;

import java.util.Scanner;

// 元素接⼝
interface Shape {
    void accept(Visitor visitor);
}

// 具体元素类
class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// 访问者接⼝
interface Visitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

// 具体访问者类
class AreaCalculator implements Visitor {
    @Override
    public void visit(Circle circle) {
        double area = 3.14 * Math.pow(circle.getRadius(), 2);
        System.out.println(area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        int area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println(area);
    }
}

// 对象结构类
class Drawing {
    private Shape[] shapes;

    public Drawing(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void accept(Visitor visitor) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
// 创建⼀个数组来存储图形对象
        Shape[] shapes = new Shape[n];
// 根据⽤户输⼊创建不同类型的图形对象
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Circle")) {
                int radius = Integer.parseInt(input[1]);
                shapes[i] = new Circle(radius);
            } else if (input[0].equals("Rectangle")) {
                int width = Integer.parseInt(input[1]);
                int height = Integer.parseInt(input[2]);
                shapes[i] = new Rectangle(width, height);
            } else {
                System.out.println("Invalid input");
                return;
            }
        }
// 创建⼀个图形集合
        Drawing drawing = new Drawing(shapes);
// 创建⼀个⾯积计算访问者
        Visitor areaCalculator = new AreaCalculator();
// 访问图形集合并计算⾯积
        drawing.accept(areaCalculator);
    }
}