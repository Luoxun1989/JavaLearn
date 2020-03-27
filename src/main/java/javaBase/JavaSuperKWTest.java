package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈super关键字的用法〉
 *
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
//        this();//报错
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