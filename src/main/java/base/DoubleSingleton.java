package base;

/*
 *Author：Victor_htq
 *Package：base
 *Project：DSnAL
 *name：DoubleSingleton
 *Date：2024/7/23  17:24
 *Filename：DoubleSingleton
 */
public class DoubleSingleton {

    private static volatile DoubleSingleton singletonInstance;

    private DoubleSingleton() {

    }

    public static DoubleSingleton getInstance() {
        if (singletonInstance == null) {
            synchronized (singletonInstance) {
                if (singletonInstance == null) {
                    singletonInstance = new DoubleSingleton();
                }
            }
        }
        return singletonInstance;
    }
}
