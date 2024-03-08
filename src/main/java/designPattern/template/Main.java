package designPattern.template;

/*
 *Author：Victor_htq
 *Package：designPattern.template
 *Project：DSnAL
 *name：Main
 *Date：2024/3/8  9:50
 *Filename：Main
 */

import java.util.Scanner;

abstract class CoffeeMakerTemplate {
    private String coffeeName;

    public CoffeeMakerTemplate(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    void grindCoffeeBeans() {
        System.out.println("Grinding coffee beans");
    }

    void brewCoffee() {
        System.out.println("Brewing coffee");
    }

    abstract void addCondiments();

    //     模板方法定义咖啡制作过程
    final void makeCoffee() {
        System.out.println("Making " + coffeeName + ":");
        grindCoffeeBeans();
        brewCoffee();
        addCondiments();
        System.out.println();
    }
}

class AmericanCoffeeMaker extends CoffeeMakerTemplate {
    public AmericanCoffeeMaker() {
        super("American Coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding condiments");
    }
}

class LatteCoffeeMaker extends CoffeeMakerTemplate {
    public LatteCoffeeMaker() {
        super("Latte");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding milk");
        System.out.println("Adding condiments");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int coffeeType = scanner.nextInt();

            CoffeeMakerTemplate coffeeMaker = null;

            if (coffeeType == 1) {
                coffeeMaker = new AmericanCoffeeMaker();
            } else if (coffeeType == 2) {
                coffeeMaker = new LatteCoffeeMaker();
            } else {
                System.out.println("Invalid coffee type");
                continue;
            }

            coffeeMaker.makeCoffee();
        }
    }
}
