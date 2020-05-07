package JavaEffective;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client41 {
    public static void main(String[] args) {
        Son son = new Son();
        Daughter daughter = new Daughter();
        System.out.println(son.kind());
        System.out.println(son.strong());
        System.out.println(daughter.strong());
        System.out.println(daughter.kind());
    }

}

//父亲
interface Father {
    int strong();
}

//母亲
interface Mother {
    int kind();
}

class FatherImpl implements Father {
    //父亲的强壮指数是8
    public int strong() {
        return 8;
    }
}

class MotherImpl implements Mother {
    //母亲的温柔指数是8
    public int kind() {
        return 8;
    }
}

class Son extends FatherImpl implements Mother {
    @Override
    public int strong() {
        //儿子比父亲强壮
        return super.strong() + 1;
    }

    @Override
    public int kind() {
        return new MotherSpecial().kind();
    }

    private class MotherSpecial extends MotherImpl {
        public int kind() {
            //儿子温柔指数降低了
            return super.kind() - 1;
        }
    }
}

class Daughter extends MotherImpl implements Father {

    @Override
    public int kind() {
        //女儿比母亲温柔
        return super.kind() + 1;
    }

    @Override
    public int strong() {
        return new FatherImpl() {
            @Override
            public int strong() {
                //女儿的强壮指数降低了
                return super.strong() - 2;
            }
        }.strong();
    }


}