import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonArray {
    public String dataJson = null;
    static ObjectMapper objMapper = new ObjectMapper();
    public ParseJsonArray() {
        objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<MyObj> data = new ArrayList<>();
        data.add(new MyObj(1, "Test01"));
        data.add(new MyObj(2, "Test02"));
        data.add(new MyObj(3, "Test03"));
        data.add(new MyObj(4, "Test04"));
        data.add(new MyObj(5, "Test05"));
        try {
            dataJson = objMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ParseJsonArray myObj = new ParseJsonArray();
        System.out.println(myObj.dataJson);
        try {
            //可以采用TypeReference进行对象读取
            //这里除了使用List之外，也可以使用Array来处理
            List<MyObj> objData=objMapper.readValue(myObj.dataJson,new TypeReference<List<MyObj>>(){});
            for(MyObj o:objData){
                System.out.println(o);
            }
            //或者直接利用对象数组来读取
            MyObj[] objs=objMapper.readValue(myObj.dataJson,MyObj[].class);
            for(MyObj o:objs){
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
