package dag.dao;

import dag.pojo.Block;

import java.util.List;

public interface BlockMapper {

    List<Block> getBlockList();

    int addBlock(Block block);

    Block getBlockByHash(String hash);

}
