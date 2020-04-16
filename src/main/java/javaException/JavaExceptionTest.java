package javaException;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *  Exception（异常）:是程序本身可以处理的异常。Exception 类有一个重要的子类 RuntimeException。RuntimeException 类及其子类表示“JVM
 * 常用操作”引发的错误。例如，若试图使用空值对象引用、除数为零或数组越界，则分别引发运行时异常（NullPointerException、ArithmeticException）
 * 和 ArrayIndexOutOfBoundException。
 *       Exception（异常）分两大类：运行时异常和非运行时异常(编译异常)。程序中应当尽可能去处理这些异常。
 *       1.运行时异常：都是RuntimeException类及其子类异常，如NullPointerException(空指针异常)、IndexOutOfBoundsException(下标越
 * 界异常)等，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异
 * 常的发生。运行时异常的特点是Java编译器不会检查它，也就是说，当程序中可能出现这类异常，即使没有用try-catch语句捕获它，也没有用throws子句声明
 * 抛出它，也会编译通过。
 *       2.非运行时异常 （编译异常）：是RuntimeException以外的异常，类型上都属于Exception类及其子类。从程序语法角度讲是必须进行处理的异常，
 * 如果不处理，程序就不能编译通过。如IOException、SQLException等以及用户自定义的Exception异常，一般情况下不自定义检查异常
 * <p>
 * 注意： 在finally块中不能抛出异常。JAVA异常处理机制保证无论在任何情况下必须先执行finally块然后再离开try块，因此在try块中发生异常的时候，
 * JAVA虚拟机先转到finally块执行finally块中的代码，finally块执行完毕后，再向外抛出异常。如果在finally块中抛出异常，try块捕捉的异常就不能抛出
 * ，外部捕捉到的异常就是finally块中的异常信息，而try块中发生的真正的异常堆栈信息则丢失了。
 *
 * @Description:
 * @Date: 2020/4/16 16:09
 * @param:
 * @return:
 **/
public class JavaExceptionTest {
    public static void main(String[] args) {
       /* int a = 6;
        int b = 0;

        try {
            if (b == 0) {
                throw new ArithmeticException();
                //"除数为0"等ArithmeticException，是RuntimException的子类。而运行时异常将由运行时系统自动抛出，不需要使用throw语句,
                // 这里把throw new ArithmeticException()去掉也是不影响运行结果的。
            }
            System.out.println("a/b的值是：" + a / b);
        } catch (ArithmeticException e) {
            System.out.println("程序出现异常，变量b不能为0。");
        }

        System.out.println("程序正常结束。");*/
        try {
            test();
        } catch (ArithmeticException e) {
            System.out.println("变量b不能为0。");
        }

    }

    public static void test() {
        int a = 6;
        int b = 0;

        if (b == 0) {
            throw new ArithmeticException("程序出现异常，变量b不能为0。");
        }
//        System.out.println("a/b的值是：" + a / b);
        System.out.println("程序正常结束。");
    }

}
