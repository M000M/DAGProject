package dag.dto;

public class BlockDto {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public BlockDto(String hash, String previousHash, String data, long timeStamp) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = timeStamp;
    }
}