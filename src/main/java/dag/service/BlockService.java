package dag.service;

import dag.dao.BlockMapper;
import dag.pojo.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.MybatisUtils;

import java.util.List;

@Service
public class BlockService {

    //private BlockMapper blockMapper = MybatisUtils.getSqlSession().getMapper(BlockMapper.class);

    @Autowired
    private BlockMapper blockMapper;

    public List<Block> getBlockList() {
        return blockMapper.getBlockList();
    }

    public Block getBlockById(int id) {
        return blockMapper.getBlockById(id);
    }
}
