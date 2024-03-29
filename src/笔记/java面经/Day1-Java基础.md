## Day1-Java基础

#### 为什么要重写hashCode()和equals()？



**参考答案**

Object类提供的equals()方法默认是用==来进行比较的，也就是说只有两个对象是同一个对象时，才能返回相等的结果。而实际的业务中，我们通常的需求是，若两个不同的对象它们的内容是相同的，就认为它们相等。鉴于这种情况，Object类中equals()方法的默认实现是没有实用价值的，所以通常都要重写。

由于hashCode()与equals()具有**联动关系**（参考“说一说hashCode()和equals()的关系”一题），所以equals()方法重写时，通常也要将hashCode()进行重写，使得这两个方法始终满足相关的约定。

#### ==和equals()有什么区别？

**参考答案**

==运算符：

- 作用于基本数据类型时，是比较两个数值是否相等；
- 作用于**引用**数据类型时，是比较两个对象的**内存地址**是否相同，即判断它们是否为同一个对象；

equals()方法：

- **没有重写时，**Object默认以 == 来实现，即比较两个对象的内存地址是否相同；
- **进行重写后，**一般会按照对象的内容来进行比较，若两个对象内容相同则认为对象相等，否则认为对象不等。

#### String类有哪些方法？

**参考答案**

String类是Java最常用的API，它包含了大量处理字符串的方法，比较常用的有：

- char charAt(int index)：返回指定索引处的字符；
- String substring(int beginIndex, int endIndex)：从此字符串中截取出一部分子字符串；
- String[] split(String regex)：以指定的规则将此字符串分割成数组；
- String trim()：删除字符串前导和后置的空格；
- int indexOf(String str)：返回子串在此字符串首次出现的索引；
- String toUpperCase()：将此字符串中所有的字符大写；
- String toLowerCase()：将此字符串中所有的字符小写；
- String replaceFirst(String regex, String replacement)：用指定字符串替换第一个匹配的子串；
- String replaceAll(String regex, String replacement)：用指定字符串替换所有的匹配的子串。

#### String可以被继承吗？

**参考答案**

String类由final修饰，所以不能被继承。

**扩展阅读**

在Java中，String类被设计为不可变类，主要表现在它保存字符串的成员变量是final的。

- Java 9之前字符串采用char[]数组来保存字符，即 private final char[] value；
- Java 9做了改进，采用byte[]数组来保存字符，即 private final byte[] value；

之所以要把String类设计为不可变类，主要是出于安全和性能的考虑，可归纳为如下4点。

- 由于字符串无论在任何 Java 系统中都广泛使用，会用来存储敏感信息，如账号，密码，网络路径，文件处理等场景里，保证字符串 String 类的安全性就尤为重要了，如果字符串是可变的，容易被篡改，那我们就无法保证使用字符串进行操作时，它是安全的，很有可能出现 SQL 注入，访问危险文件等操作。
- 在多线程中，只有不变的对象和值是线程安全的，可以在多个线程中共享数据。由于 String 天然的不可变，当一个线程”修改“了字符串的值，只会产生一个新的字符串对象，不会对其他线程的访问产生副作用，访问的都是同样的字符串数据，不需要任何同步操作。
- 字符串作为基础的数据结构，大量地应用在一些集合容器之中，尤其是一些散列集合，在散列集合中，存放元素都要根据对象的 hashCode() 方法来确定元素的位置。由于字符串 hashcode 属性不会变更，保证了唯一性，使得类似 HashMap，HashSet 等容器才能实现相应的缓存功能。由于 String 的不可变，避免重复计算 hashcode，只要使用缓存的 hashcode 即可，这样一来大大提高了在散列集合中使用 String 对象的性能。
- 当字符串不可变时，字符串常量池才有意义。字符串常量池的出现，可以减少创建相同字面量的字符串，让不同的引用指向池中同一个字符串，为运行时节约很多的堆内存。若字符串可变，字符串常量池失去意义，基于常量池的 String.intern() 方法也失效，每次创建新的字符串将在堆内开辟出新的空间，占据更多的内存。

因为要保证String类的不可变，那么将这个类定义为final的就很容易理解了。如果没有final修饰，那么就会存在String的子类，这些子类可以重写String类的方法，强行改变字符串的值，这便违背了String类设计的初衷。