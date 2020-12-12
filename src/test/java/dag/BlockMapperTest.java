package dag;

import dag.dao.BlockMapper;
import dag.pojo.Block;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;
import utils.SHA256Utils;

import java.util.List;

public class BlockMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.getSqlSession();

            BlockMapper blockMapper = sqlSession.getMapper(BlockMapper.class);

            List<Block> blockList = blockMapper.getBlockList();

            for (Block block: blockList) {
                System.out.println(block);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!= null) sqlSession.close();
        }
    }

    @Test
    public void test1() {
        Block block = new Block();
        block.setPre1(SHA256Utils.sha256Code("3"));
        block.setPre2(SHA256Utils.sha256Code("4"));
        block.setData("value1");
        block.setHash(SHA256Utils.sha256Code("value1"));

        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlockMapper blockMapper = sqlSession.getMapper(BlockMapper.class);
            int res = blockMapper.addBlock(block);
            sqlSession.commit();
            if (res != 0) {
                System.out.println("add success");
            } else {
                System.out.println("add failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlockMapper blockMapper = sqlSession.getMapper(BlockMapper.class);
            String hash = "1eb79602411ef02cf6fe117897015fff89f80face4eccd50425c45149b148408";
            Block block = blockMapper.getBlockByHash(hash);
            if (block == null) {
                System.out.println("not exists");
            } else {
                System.out.println(block.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
    }
}
