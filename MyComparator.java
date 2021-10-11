import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparator {
    public String uniqData(String dataPrefix, List<String> data){
        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.replace(dataPrefix,"0")) - Integer.parseInt(o2.replace(dataPrefix,"0"));
            }
        });
        String uniqName=dataPrefix;
        int k=0;
        if (dataPrefix.equals(data.get(0))){
            for (k=1;k<data.size();k++){
                if (!(dataPrefix+k).equals(data.get(k))){
                    uniqName=dataPrefix+k;
                    break;
                }
            }
            if (k==data.size()){
                uniqName=dataPrefix+k;
            }
        }
        return uniqName;
    }

    public static void main(String[] args){
        MyComparator mySort=new MyComparator();
        List<String> data= Arrays.asList("cguanhao","cguanhao1","cguanhao4","cguanhao2","cguanhao3");
        System.out.println(mySort.uniqData("cguanhao",data));
    }
}
