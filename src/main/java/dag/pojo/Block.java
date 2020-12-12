package dag.pojo;

public class Block {
    private int id;

    private String pre1;

    private String pre2;

    private String data;

    private String hash;

    public Block() {
    }

    public Block(int id, String pre1, String pre2, String data, String hash) {
        this.id = id;
        this.pre1 = pre1;
        this.pre2 = pre2;
        this.data = data;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPre1() {
        return pre1;
    }

    public void setPre1(String pre1) {
        this.pre1 = pre1;
    }

    public String getPre2() {
        return pre2;
    }

    public void setPre2(String pre2) {
        this.pre2 = pre2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", pre1='" + pre1 + '\'' +
                ", pre2='" + pre2 + '\'' +
                ", data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
