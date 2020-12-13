package dag.controller;

import dag.pojo.Block;
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
}
