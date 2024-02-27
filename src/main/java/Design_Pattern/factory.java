package Design_Pattern;

/*
 *Author：Victor_htq
 *Package：Design_Pattern
 *Project：DSnAL
 *name：factory
 *Date：2024/2/27  9:23
 *Filename：factory
 */
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}

interface ShapeFactory {
    Shape createShape();
}

class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class  SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}
public class factory {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        circleFactory.createShape().draw();
        ShapeFactory squareFactory = new SquareFactory();
        squareFactory.createShape().draw();
    }
}
