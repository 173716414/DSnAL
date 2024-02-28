## 设计模式

### 单例模式

#### 单例设计模式优点：

1. 全局控制：保证只有⼀个实例，这样就可以严格的控制客户怎样访问它以及何时访问它，简单的说就是对唯⼀实例的受控访问
2. 节省资源：也正是因为只有⼀个实例存在，就避免多次创建了相同的对象，从⽽节省了系统资源，⽽且多个模块还可以通过单例实例共享数据。
3. 懒加载：单例模式可以实现**懒加载**，只有在需要时才进⾏实例化，这⽆疑会提⾼程序的性能。

#### 单例设计模式的基本要求想：

1. 私有的构造函数
2. 防⽌外部代码直接创建类的实例私有的静态实例变量
3. 保存该类的唯⼀实例公有的静态⽅法
4. 通过公有的静态⽅法来获取类的实例

#### 单例设计模式的实现单例模式的实现⽅式：

1. 饿汉式指的是在类加载时就已经完成了实例的创建，不管后⾯创建的实例有没有使⽤，先创建再说，所以叫做“饿汉”。
2. ⽽懒汉式指的是只有在请求实例时才会创建，如果在⾸次请求时还没有创建，就创建⼀个新的实例，如果已经创建，就返回已有的实例，意思就是需要使⽤了再创建，所以称为“懒汉”。
3. 在多线程环境下，由于饿汉式在程序启动阶段就完成了实例的初始化，因此不存在多个线程同时尝试初始化实例的问题，但是懒汉式中多个线程同时访问 getInstance() ⽅法，并且在同⼀时刻检测到实例没有被创建，就可能会同时创建实例，从⽽导致多个实例被创建，这种情况下我们可以采⽤⼀些同步机制，例如使⽤互斥锁来确保在任何时刻只有⼀个线程能够执⾏实例的创建。

1. 饿汉模式：

   ```java
   public class Singleton {
   	private static final Singleton instance = new Singleton();
   	private Singleton() {
   		// 私有构造⽅法，防⽌外部实例化
   	}
   	public static Singleton getInstance() {
   		return instance;
   	}
   }
   ```

2. 懒汉模式：  

   ```java
   public class Singleton {
   	private static Singleton instance;
   	private Singleton() {
   		// 私有构造⽅法，防⽌外部实例化
   	}
   	// 使⽤了同步关键字来确保线程安全, 可能会影响性能
   	public static synchronized Singleton getInstance() {
   		if (instance == null) {
   			instance = new Singleton();
   		}
   		return instance;
   	}
   }
   ```

   在懒汉模式的基础上，可以使⽤双重检查锁来提⾼性能。  

​		

```java
public class Singleton {
	private static volatile Singleton instance;
	private Singleton() {
		// 私有构造⽅法，防⽌外部实例化
	}
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
```

#### 什么场景下应该考虑使⽤单例设计模式

1. 资源共享多个模块共享某个资源的时候，可以使⽤单例模式，⽐如说应⽤程序需要⼀个全局的配置管理器来存储和管理配置信息、亦或是使⽤单例模式管理数据库连接池。
2. 只有⼀个实例当系统中某个类只需要⼀个实例来协调⾏为的时候，可以考虑使⽤单例模式， ⽐如说管理应⽤程序中的缓存，确保只有⼀个缓存实例，避免重复的缓存创建和管理，或者使⽤单例模式来创建和管理线程池。
3. 懒加载如果对象创建本身就⽐较消耗资源，⽽且可能在整个程序中都不⼀定会使⽤，可以使⽤单例模式实现懒加载。
4. 在许多流⾏的⼯具和库中，也都使⽤到了单例设计模式，⽐如Java中的 Runtime 类就是⼀个经典的单例，表示程序的运⾏时环境。此外 Spring 框架中的应⽤上下⽂ ( ApplicationContext ) 也被设计为单例，以提供对应⽤程序中所有 bean 的集中式访问点。



#### 代码

```java
package designPattern;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：designPattern
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
```

