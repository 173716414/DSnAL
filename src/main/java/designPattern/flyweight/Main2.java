package designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：designPattern.flyweight
 *Project：DSnAL
 *name：Main2
 *Date：2024/3/6  10:14
 *Filename：Main2
 */
enum ShapeType {
    CIRCLE, RECTANGLE, TRIANGLE
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

interface Shape {
    void draw(Position position);
}

class ConcreteShape implements Shape {
    private ShapeType shapeType;

    public ConcreteShape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    private boolean isFirstTime = true;
    @Override
    public void draw(Position position) {
        System.out.println(shapeType + (isFirstTime ? " drawn" : " shared") + " at (" +
                position.getX() + ", " + position.getY() + ")");
    }

    public void setFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }
}

class ShapeFactory {
    private Map<ShapeType, Shape> shapes = new HashMap<>();

    public Shape getShape(ShapeType type) {
        if (!shapes.containsKey(type)) {
            shapes.put(type, new ConcreteShape(type));
        }
        return shapes.get(type);
    }
}
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeFactory factory = new ShapeFactory();
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            processCommand(factory, command);
        }
    }
    private static void processCommand(ShapeFactory factory, String command) {
        String[] parts = command.split(" ");
        ShapeType type = ShapeType.valueOf(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        Shape shape = factory.getShape(type);
        shape.draw(new Position(x, y));
        ((ConcreteShape) shape).setFirstTime(false);
    }

}
