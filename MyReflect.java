import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyReflect {
    public void changed(MyObj obj){
        MyObj xObj=new MyObj(123,"My Test");
        List<MyObj> d=new ArrayList<>();
        d.add(new MyObj(1,"My Test01"));
        d.add(new MyObj(2,"My Test02"));
        xObj.setData(d);
        try {
            for(Field f:MyObj.class.getDeclaredFields()){
                f.setAccessible(true);
                f.set(obj,f.get(xObj));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        MyReflect objTest=new MyReflect();
        MyObj o=new MyObj(101,"Test101");
        List<MyObj> d=new ArrayList<>();
        d.add(new MyObj(102,"My Test102"));
        d.add(new MyObj(103,"My Test103"));
        o.setData(d);
        objTest.changed(o);
        System.out.println(o);
    }
}
