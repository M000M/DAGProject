package dag.service;

import dag.dao.BlockMapper;
import dag.pojo.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.SHA256Utils;

import java.util.List;
import java.util.TreeSet;

@Service
public class BlockService {

    //private BlockMapper blockMapper = MybatisUtils.getSqlSession().getMapper(BlockMapper.class);

    @Autowired
    private BlockMapper blockMapper;

    private TreeSet<Block> blockSet = new TreeSet<>();

    private void init() {
        blockSet.addAll(blockMapper.getBlockList());
    }

    /***
     * 获取节点列表
     * @return
     */
    public List<Block> getBlockList() {
        return blockMapper.getBlockList();
    }

    /***
     * 根据节点ID获取节点信息
     * @param id
     * @return
     */
    public Block getBlockById(int id) {
        return blockMapper.getBlockById(id);
    }

    /***
     * 添加节点
     * @param data
     * @return
     */
    public String addBlock(String data) {
        if (blockSet.isEmpty()) {
            init();
        }
        String hash;
        Block block = new Block();
        block.setData(data);
        block.setNum(0);
        block.setTimestamp(System.currentTimeMillis() / 1000);
        if (blockSet.size() >= 2) {
            Block pre1 = blockSet.pollFirst();
            Block pre2 = blockSet.pollFirst();
            pre1.setNum(pre1.getNum() + 1);
            pre2.setNum(pre2.getNum() + 1);
            blockSet.add(pre1);
            blockSet.add(pre2);

            block.setPre1(pre1.getHash());
            block.setPre2(pre2.getHash());
            hash = SHA256Utils.sha256Code(pre1.getHash() + pre2.getHash() + data + block.getTimestamp());
            block.setHash(hash);
            blockSet.add(block);
        }
        else if (blockSet.size() == 1) {
            Block pre = blockSet.pollFirst();
            pre.setNum(pre.getNum() + 1);
            blockSet.add(pre);

            block.setPre1(pre.getHash());
            hash = SHA256Utils.sha256Code(pre.getHash() + data);
            block.setHash(hash);
            blockSet.add(block);
        }
        else {
            hash = SHA256Utils.sha256Code(data);
            block.setHash(hash);
            blockSet.add(block);
        }

        int res = blockMapper.addBlock(block);
        if (res > 0) {
            return hash;
        } else {
            return null;
        }
    }

    public String getBlockByHash(String hash) {
        try {
            Block block = blockMapper.getBlockByHash(hash);
            if (block != null) {
                return block.getData();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
