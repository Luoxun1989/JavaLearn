package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈成员内部类、局部内部类、匿名内部类和静态内部类。〉
 *
 * @author Luoxun
 * @create 2020/3/27
 * @since 1.0.0
 */
public class JavaOuterClassTest {
    public static int radius=1;
    private int aaa=1;
    //静态内部类  类内部的静态类，就是静态内部类。
    static class  StaticInnerClass{
        public void staticInnerClassMethod() {
            System.out.println("visit staticInnerClassMethod:" + radius);
            //                System.out.println("visit staticInnerClassMethod:" + aaa);//报错 只能访问静态变量和静态方法

        }
    }
    //成员内部类  定义在类内部，成员位置上的非静态类，就是成员内部类。
    class InnerClass{

        public void innerClassMethod() {
            //成员内部类可以访问外部类所有的变量和方法，包括静态和非静态，私有和公有。
            System.out.println("visit innerClassMethod:" + radius);
            System.out.println("visit innerClassMethod:" + aaa);
            outerClassMethod();
        }
    }

    public void outerClassMethod(){
        //匿名内部类
        // new 类名或接口名(){
        //    重写方法;
        //}；     //注意分号
        //以上就是内部类的格式，其实这整体就相当于是new出来的一个对象
        new AnonymousInnerClassInterface(){
            @Override
            public void show() {
                System.out.printf("AnonymousInnerClassInterface.show");
            }

            @Override
            public void run() {
                System.out.printf("AnonymousInnerClassInterface.run");
            }

            @Override
            public void walk() {
                System.out.printf("AnonymousInnerClassInterface.run");
            }
        }.show();
    }
    //局部内部类（成员方法中） 定义在方法中的内部类，就是局部内部类。

    //定义在实例方法中的局部内部类
    private void outerClassMethod(String str){
        int b = 10;
        final int a = 10;
        class OutMethodInnerClass {
            private String label;
            private OutMethodInnerClass(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
            public void outMethodInnerClassMethod() {
                //局部内部类可以访问外部类所有的变量和方法，包括静态和非静态，私有和公有。
                System.out.println("visit outMethodInnerClassMethod:" + aaa);
                System.out.println("visit outMethodInnerClassMethod:" + radius);
                outerClassMethod();
                //局部内部类和匿名内部类访问局部变量的时候 变量必须要加上final 是因为生命周期不一致， 局部变量直接存储在栈中，当方法执行结束后，
                // 非final的局部变量就被销毁。而局部内部类对局部变量的引用依然存在，如果局部内部类要调用局部变量时
                System.out.println(a); // 变量a 不加final报错，
            }
        }
        System.out.println(b);
    }
    //定义在静态方法中的局部内部类
    private static void outerClassStaticMethod(){

        class OutStaticMethodInnerClass{
            public void outStaticMethodInnerClassMethod() {
                //静态方法局部内部类只可以访问外部类静态。
                System.out.println("visit outStaticMethodInnerClassMethod:" + radius);
//                System.out.println("visit outStaticMethodInnerClassMethod:" + aaa);//报错 只能访问静态变量和静态方法
//                outerClassMethod();// 报错 只能访问静态变量和静态方法
            }
        }
    }


    public static void main(String[] args) {
        //静态内部类创建方式 new 外部类.静态内部类()
        JavaOuterClassTest.StaticInnerClass sInner = new JavaOuterClassTest.StaticInnerClass();
        sInner.staticInnerClassMethod();

        JavaOuterClassTest javaOuterClassTest = new JavaOuterClassTest();
        javaOuterClassTest.outerClassStaticMethod();
        javaOuterClassTest.outerClassMethod();
        //成员内部类依赖于外部类的实例，它的创建方式外部类实例.new 内部类()，
        JavaOuterClassTest.InnerClass innerClass = javaOuterClassTest.new InnerClass();
        innerClass.innerClassMethod();

    }
}
