package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈Java接口是一系列方法的声明，是一些方法特征的集合〉
 *一个接口只有方法的特征没有方法的实现，因此这些方法可以在不同的地方被不同的类实现，而这些实现可以具有不同的行为（功能）。
 * 1.我们不能直接去实例化一个接口，因为接口中的方法都是抽象的，是没有方法体的
 *
 * 2.一个类可以实现不止一个接口。

 * 3.一个接口可以继承于另一个接口，或者另一些接口，接口也可以继承，并且可以多继承。
 *
 * 4.一个类如果要实现某个接口的话，那么它必须要实现这个接口中的所有方法。
 *
 * 5.接口中所有的方法都是abstract的和public的，所有的属性都是public,static,final的。  可以默认不写 编译器自动加上这些修饰符关键字
 *
 * 6.接口用来弥补类无法实现多继承的局限。
 *
 * 7.接口也可以用来实现解耦。

 * @author Luoxun
 * @create 2020/4/2
 * @since 1.0.0
 */
public class JavaInterfaceTest implements USB,USB3{

    @Override
    public void read() {
        System.out.println("USB read method");
    }

    @Override
    public void write() {
        System.out.println("USB write method");
    }

    @Override
    public void read3() {
        System.out.println("USB3 read method");
    }

    @Override
    public void write3() {
        System.out.println("USB3 write method");
    }

    public static void main(String[] args) {
        JavaInterfaceTest jit = new JavaInterfaceTest();
        jit.read();
        jit.read3();
        USB a = jit;//向上转型
        a.write();
        USB3 b = jit;//向上转型
        b.write3();
    }
}
