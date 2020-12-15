package dag.controller;

import dag.pojo.Block;
import dag.pojo.Result;
import dag.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlockController {

    @Autowired
    private BlockService blockService;

    @RequestMapping(value = "/getBlockList", method = RequestMethod.GET)
    public List<Block> getBlockList() {
        System.out.println(blockService.getBlockList());
        return blockService.getBlockList();
    }

    @RequestMapping(value="/getBlockById/{id}", method = RequestMethod.GET)
    public Block getBlockById(@PathVariable(name = "id") int id) {
        Block block = blockService.getBlockById(id);
        System.out.println(block.getData());
        return block;
    }

    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public Result saveData(@RequestParam(value = "data", required = true) String data) {
        Result result = new Result();
        String res;
        try {
            res = blockService.addBlock(data);
            if (res != null) {
                result.setData(res);
                result.setSuccess();
            } else {
                result.setFailure();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setException();
            return result;
        }
    }

    @RequestMapping(value = "/readData", method = RequestMethod.POST)
    public Result readData(@RequestParam(name = "hash", required = true) String hash) {
        Result result = new Result();
        try {
            String data = blockService.getBlockByHash(hash);
            if (data != null) {
                result.setSuccess();
                result.setData(data);
            } else {
                result.setFailure();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setException();
            return result;
        }
    }
}
