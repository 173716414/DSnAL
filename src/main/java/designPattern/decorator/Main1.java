package designPattern.decorator;

import java.util.Scanner;

interface Coffee {
    void brew();
}

class BlackCoffee implements Coffee{
    @Override
    public void brew(){
        System.out.println("Brewing Coffee");
    } 
}

class Latte implements Coffee{
    @Override
    public void brew(){
        System.out.println("Brewing Latte");
    } 
}

abstract class Decorator2 implements Coffee {
    Coffee coffee;
    public Decorator2(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public void brew() {
        coffee.brew();
    }
}

class Milk extends Decorator2 {
    public Milk(Coffee coffee) {
        super(coffee);
    }
    @Override
    public void brew() {
        coffee.brew();
        System.out.println("Adding Milk");
    }
}

class Sugar extends Decorator2 {
    public Sugar(Coffee coffee) {
        super(coffee);
    }
    @Override
    public void brew() {
        coffee.brew();
        System.out.println("Adding Sugar");
    }
}

public class Main1 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Coffee coffee;
            if (a == 1) {
                coffee = new BlackCoffee();
            } else {
                coffee = new Latte();
            }
            if (b == 1) {
                new Milk(coffee).brew();
            } else {
                new Sugar(coffee).brew();
            }
        }
    }
}