// package designPattern.composite;
//
// import java.util.ArrayList;
// import java.util.List;
//
// // 组件接⼝
// interface Component {
//     void operation();
// }
//
// // 叶⼦节点
// class Leaf implements Component {
//     @Override
//     public void operation() {
//         System.out.println("Leaf operation");
//     }
// }
//
// // 组合节点：包含叶⼦节点的操作⾏为
// class Composite implements Component {
//     private List<Component> components = new ArrayList<>();
//
//     public void add(Component component) {
//         components.add(component);
//     }
//
//     public void remove(Component component) {
//         components.remove(component);
//     }
//
//     @Override
//     public void operation() {
//         System.out.println("Composite operation");
//         for (Component component : components) {
//             component.operation();
//         }
//     }
// }
//
// // 客户端代码
// public class Client {
//     public static void main(String[] args) {
// // 创建叶⼦节点
//         Leaf leaf = new Leaf();
// // 创建组合节点，并添加叶⼦节点
//         Composite composite = new Composite();
//         composite.add(leaf);
//         composite.operation(); // 统⼀调⽤
//     }
// }