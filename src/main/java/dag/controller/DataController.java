package dag.controller;

import dag.dto.RestDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dag.service.DataService;
import utils.SHA1Utils;

@RestController
@RequestMapping(value = "/dag")
public class DataController {

    @Autowired
    private DataService dataService;

    /***
     * 将数据存储到DAG中
     * @return
     */
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public RestDto saveData(@RequestParam(name = "value") String value) {
        RestDto restDto = null;
        restDto = dataService.save(value);
        return restDto;
    }

    /***
     *
     * @param hashCode
     * @return
     */
    @RequestMapping(value = "readData", method = RequestMethod.GET)
    public RestDto readData(String hashCode) {
        RestDto restDto = null;
        restDto = dataService.read(hashCode);
        return restDto;
    }

    @Test
    public void test() {
        String str = "attack 2020.12.08 12:00:00";
        //int code = str.hashCode();
        String code = SHA1Utils.sha1Code(str);
        System.out.println(code);
    }
}
