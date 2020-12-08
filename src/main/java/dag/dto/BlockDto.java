package dag.dto;

public class BlockDto {

    private long id;

    private String value;

    private String preTransaction1;

    private String preTransaction2;

    private long num;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPreTransaction1() {
        return preTransaction1;
    }

    public void setPreTransaction1(String preTransaction1) {
        this.preTransaction1 = preTransaction1;
    }

    public String getPreTransaction2() {
        return preTransaction2;
    }

    public void setPreTransaction2(String preTransaction2) {
        this.preTransaction2 = preTransaction2;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
