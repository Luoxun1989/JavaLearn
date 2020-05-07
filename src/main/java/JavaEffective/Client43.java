package JavaEffective;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client43 {
    public static void main(String[] args) {
        //定义父亲
        Person f = new Person("父亲");
        //定义大儿子
        Person s1 = new Person("大儿子",f);
        s1.setName("大儿子");

        //小儿子的信息是通过大儿子克隆过来的
        Person s2 = s1.clone();
        s2.setName("小儿子");

        s1.setFather(new Person("干爹"));

        System.out.println(s1.getName() +" 的父亲是 " + s1.getFather().getName());
        System.out.println(s2.getName() +" 的父亲是 " + s2.getFather().getName());
    }
}
class Person implements Cloneable{
    private String name;
    private Person father;
    public Person(String _name){
        name = _name;
    }
    public Person(String _name, Person _parent){
        this.name = _name;
        this.father = _parent;
    }
    @Override
    public Person clone(){
        Person p = null;
        try {
            p = (Person) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Person getFather() {
        return father;
    }


    public void setFather(Person father) {
        this.father = father;
    }
}
