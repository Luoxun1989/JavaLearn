package JavaEffective;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/23
 * @since 1.0.0
 */
public class Client73 {
    public static void main(String[] args) {
        List<Employee2> list = new ArrayList<Employee2>(10);
        list.add(new Employee2(Position.Boss,"luo",10101));
        list.add(new Employee2(Position.Manager,"zhang",11002));
        list.add(new Employee2(Position.Manager,"liu",10011));
        list.add(new Employee2(Position.Staff,"li",10023));
        list.add(new Employee2(Position.Staff,"wang",10012));
        list.add(new Employee2(Position.Staff,"zhao",10021));
        list.add(new Employee2(Position.Staff,"shi",10431));
        Collections.sort(list,new PositionComparator());
//        Collections.sort(list,Collections.reverseOrder(new PositionComparator()));
//        Collections.sort(list);
//        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
//这里的顺序要求已经排好
enum Position{
    Boss("老板"),Manager(""),Staff("");
    private String desc;
    Position(String _desc){
        this.desc = _desc;
    }
    public String getDesc(){
        return desc;
    }
}

class Employee2 implements Comparable<Employee2>{
    private int id;
    private String  name;
    private Position position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee2(Position _position,String _name,int _id) {
        this.position = _position;
        this.name = _name;
        this.id = _id;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
    @Override
    public int compareTo(Employee2 employee){
        return new CompareToBuilder().append(position,employee.position).append(id,employee.id).toComparison();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

class PositionComparator implements Comparator<Employee2>{

    @Override
    public int compare(Employee2 o1,Employee2 o2) {
        return o1.getPosition().compareTo(o2.getPosition());
    }
}