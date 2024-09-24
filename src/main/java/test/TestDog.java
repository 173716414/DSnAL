package test;

class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal {
    public void move() {
        System.out.println("狗可以跑和走");
    }
    
    public void bark() {
        System.out.println("狗可以吠叫");
    }
}

public class TestDog {
    public static void main(String args[]) {
        Animal a = new Animal();  // 声明并实例化一个Animal对象
        Animal b = new Dog();     // 声明一个Animal引用并指向一个Dog对象

        a.move();  // 调用Animal类的move方法
        b.move();  // 调用Dog类的move方法（多态）
        // b.bark();  // 这里会编译报错，因为Animal类中没有定义bark方法
    }
}
