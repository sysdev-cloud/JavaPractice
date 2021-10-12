import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChangeParameterObjectValue {
    public void changedUseReflect(MyObj obj){
        MyObj xObj=new MyObj(123,"My Test123");
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
    public void changedUseMap(Object obj) {
        MyObj xObj=new MyObj(223,"My Test223");
        List<MyObj> d=new ArrayList<>();
        d.add(new MyObj(21,"My Test21"));
        d.add(new MyObj(22,"My Test22"));
        xObj.setData(d);
        ObjectMapper objMapper=new ObjectMapper();
        objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            Map xMap=objMapper.readValue(objMapper.writeValueAsString(xObj),Map.class);
            Map rMap=(Map) obj;
            for(Object s:xMap.keySet()){
                rMap.put(s,xMap.get(s));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        ChangeParameterObjectValue objTest=new ChangeParameterObjectValue();
        MyObj o=new MyObj(101,"Test101");
        List<MyObj> d=new ArrayList<>();
        d.add(new MyObj(102,"My Test102"));
        d.add(new MyObj(103,"My Test103"));
        o.setData(d);
        objTest.changedUseReflect(o);
        System.out.println(o);
        ObjectMapper objMapper=new ObjectMapper();
        objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Map x=null;
        try {
            x=objMapper.readValue(objMapper.writeValueAsString(o),Map.class);
            objTest.changedUseMap(x);
            o=objMapper.readValue(objMapper.writeValueAsString(x),MyObj.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(o);
    }
}
