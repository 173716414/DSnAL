package test;

import java.util.*;

class test {
    public static void main(String[] args) {
        List<String> mutable = new ArrayList<>();
        mutable.add("苹果");
        mutable.add("西瓜");

        List<String> immutable = Collections.unmodifiableList(mutable);
        mutable.add("橙子");  // 这里修改了 mutable 列表

        System.out.println(mutable);
        System.out.println(immutable);
    }
}
