package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈super关键字的用法〉
 *   1. super（参数）：调用基类中的某一个构造函数（应该为构造函数中的第一条语句）
 *   2. this（参数）：调用本类中另一种形成的构造函数（应该为构造函数中的第一条语句）
 *   3. super:　它引用当前对象的直接父类中的成员（用来访问直接父类中被隐藏的父类中成员数据或函数，基类与派生类中有相同成员定义时如：super.变量名
 *   super.成员函数据名（实参）
 *   4. this：它代表当前对象名（在程序中易产生二义性之处，应使用this来指明当前对象；如果函数的形参与类中的成员数据同名，这时需用this来指明成员变量名）
 *   5. 调用super()必须写在子类构造方法的第一行，否则编译不通过。每个子类构造方法的第一条语句，都是隐含地调用super()，如果父类没有这种形式的构造
 *   函数，那么在编译的时候就会报错。
 *   6. super()和this()类似,区别是，super()从子类中调用父类的构造方法，this()在同一类内调用其它方法。
 *   7. super()和this()均需放在构造方法内第一行。
 *   8. 尽管可以用this调用一个构造器，但却不能调用两个。
 *   9. this和super不能同时出现在一个构造函数里面，因为this必然会调用其它的构造函数，其它的构造函数必然也会有super语句的存在，所以在同一个
 *   构造函数里面有相同的语句，就失去了语句的意义，编译器也不会通过。
 *   10. this()和super()都指的是对象，所以，均不可以在static环境中使用。包括：static变量,static方法，static语句块。
 *   11. 从本质上讲，this是一个指向本对象的指针, 然而super是一个Java关键字。
 * @author Luoxun
 * @create 2020/3/27
 * @since 1.0.0
 */
public class JavaSuperKWTest {
    protected String name;
    public JavaSuperKWTest(String name) {
        this.name = name;
    }

    protected void mod(){
        System.out.println(this.name);
    }
}
class JavaSuper extends JavaSuperKWTest {
    private String name;
    public JavaSuper(){
//        super();  //报错 Java只会隐式的调用无参构造函数，如果父类没有无参构造函数，那么子类中就必须显示的调用super关键字来调用已有的有参构造函数来初始化父类。
//        this();//报错  this()和super()不能同时出现在一个构造函数里面
        super("ee");

    }
    public JavaSuper(String name, String name1) {
        super(name);
        super.mod();
        this.name = name1;
    }

    protected void mod22(){
        System.out.println(this.name);
        System.out.println(super.name);
    }
    public static void main(String[] args) {
        JavaSuper js = new JavaSuper("faf","son");
        js.mod22();

    }
}