package JavaEffective;

/**
 * “Go Further进无止境” <br>
 * 〈匿名类的构造函数很特殊〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client40 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator(1,2) {
            //构造代码块
            {
                setOperator(Ops.ADD);
            }
        };

        System.out.println(c1.getResult());

        Calculator c2 = new Add(1,2);
        System.out.println(c2.getResult());

    }
}

enum Ops {ADD, SUB}

class Calculator {
    private int i, j, result;
    //无参构造
    public Calculator() {}
    //有参构造
    public Calculator(int _i, int _j) {
        i = _i;
        j = _j;
    }
    //设置符号，是加法运算还是减法运算
    protected void setOperator(Ops _op) {
        result = _op.equals(Ops.ADD)?i+j:i-j;
    }
    //取得运算结果
    public int getResult(){
        return result;
    }
}

//加法计算
class Add extends Calculator {
    {
        setOperator(Ops.ADD);
    }
    //覆写父类的构造方法
    public Add(int _i, int _j) {
//        super(_i,_j);   //不注释c2.getResult()结果为3，注释后结果为0
    }
}