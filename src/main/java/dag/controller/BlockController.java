package dag.controller;

import dag.pojo.Block;
import dag.pojo.Result;
import dag.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BlockController {

    @Autowired
    private BlockService blockService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() {
        return "save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(value="data", required = true) String data, Model model, HttpServletRequest request) {
        String hash = blockService.addBlock(data);
        model.addAttribute("data", data);
        model.addAttribute("hash", hash);
        return "save";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read() {
        return "read";
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public String read(@RequestParam(value="hash", required = false) String hash, Model model, HttpServletRequest request) {
        if (hash != null) {
            String data = blockService.getBlockByHash(hash);
            model.addAttribute("hash", hash);
            model.addAttribute("data", data);
        }
        return "read";
    }

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
