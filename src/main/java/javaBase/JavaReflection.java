package javaBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * “Go Further进无止境” <br>
 * Java提供了两种方式获取Class对象，一种是使用.class，另外一种是使用Class.forName()。
 * .class方式适用于在编译时已经知道具体的类。
 * 〈Class.forName()方式适用于运行时动态获取Class对象，只需将类名作为forName方法的参数：〉
 *
 * @author Luoxun
 * @create 2020/4/26
 * @since 1.0.0
 */
public class JavaReflection {
    public static void main(String[] args) {
        Class jrClass = JavaReflection.class;
        System.out.println(jrClass.getName());
        System.out.println(jrClass.getSimpleName());
        try {
            Class jrClass2 = Class.forName("javaBase.JavaStringBase");
            System.out.println(jrClass2.getName());
            System.out.println(jrClass2.getModifiers());
            System.out.println(Modifier.isPublic(jrClass2.getModifiers()));


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Class birdClass = Bird.class;
        try{
            Constructor constructors = birdClass.getConstructor(new Class[]{String.class});
            Bird bird = (Bird)constructors.newInstance("eat tea");

        }catch(Exception  e){
            System.out.println("没有对应的构造函数");
        }
    }
    class Bird {
        public Bird(){

        }

        protected Bird(String eat){

        }
    }
}
