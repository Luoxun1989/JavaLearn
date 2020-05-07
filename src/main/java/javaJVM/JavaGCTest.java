package javaJVM;

/**
 * “Go Further进无止境” <br>
 * 〈目前主流的垃圾收集器都会采用分代回收算法，因此需要将堆内存分为新生代和老年代，这样我们就可以根据各个年代的特点选择合适的垃圾收集算法。
 *
 * 大多数情况下，对象在新生代中 eden 区分配。当 eden 区没有足够空间进行分配时，虚拟机将发起一次 Minor GC〉
 *
 * @author Luoxun
 * @create 2020/4/27
 * @since 1.0.0
 */
public class JavaGCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];
        allocation2 = new byte[900*1024];
    }
}
