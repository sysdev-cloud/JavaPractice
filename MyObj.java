import java.util.List;

public class MyObj {
    private Integer id;
    private String Code;
    private List<MyObj> data;

    public MyObj() {
    }

    public MyObj(Integer id, String code) {
        this.id = id;
        Code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public List<MyObj> getData() {
        return data;
    }

    public void setData(List<MyObj> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyObj{" +
                "id=" + id +
                ", Code='" + Code + '\'' +
                ", data=" + data +
                '}';
    }
}
