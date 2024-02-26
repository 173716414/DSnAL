package Design_Pattern;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：Design_Pattern
 *Project：DSnAL
 *name：Singleton
 *Date：2024/2/26  16:42
 *Filename：Singleton
 */
public class Singleton {
    public static void main(String[] args) {
        ShoppingCartManager cart = ShoppingCartManager.instance.getInstance();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String itemName = scanner.next();
            int quantity = scanner.nextInt();
            cart.addToCart(itemName, quantity);
        }
        cart.viewCart();
    }
}

class ShoppingCartManager {
    public static final ShoppingCartManager instance = new ShoppingCartManager();
    private Map<String, Integer> cart;
    private ShoppingCartManager() {
        cart = new LinkedHashMap<>();
    }

    public ShoppingCartManager getInstance() {
        return instance;
    }

    public void addToCart(String itemName, int quantity) {
        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
    }

    public void viewCart() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
