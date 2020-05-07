package JavaEffective;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client47 {
    public static void main(String[] args) {

        /*Employee e1 = new Employee("张三",100);
        Employee e2 = new Employee("张三",1001);
        Person2 p1 = new Person2("张三");


        System.out.println(p1.equals(e1));
        System.out.println(p1.equals(e2));
        System.out.println(e1.equals(e2));*/

        Map<Person2,Object> map = new HashMap<Person2, Object>(){
            {
                put(new Person2("张三"),new Object());
            }
        };
        List<Person2> list = new ArrayList<Person2>(){
            {
                add(new Person2("张三"));
            }
        };
        boolean b1 = list.contains(new Person2("张三"));
        boolean b2 = map.containsKey(new Person2("张三"));
        System.out.println(b1+"..."+b2);

    }
}

class Person2{
    private String name;

    public Person2(String _name){
        name = _name;
    }
    public String getName() {
        return name;
    }

    public void setName(String _name ) {
        this.name = _name;
    }

    @Override
    public boolean equals(Object obj) {
//        if(obj!=null && obj instanceof Person2){
        if(obj!=null && obj.getClass() == this.getClass()){
            Person2 p = (Person2) obj;
            if(p.getName()==null || name==null){
                return false;
            }else{
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }
    @Override
    public int hashCode(){
        return new HashCodeBuilder().append(name).toHashCode();
    }
}

class Employee extends Person2{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String _name,int _id) {
        super(_name);
        id = _id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj.getClass() == this.getClass()){
            Employee e = (Employee) obj;
            return super.equals(obj)&& e.getId() == id;
        }
        return false;
    }
}
