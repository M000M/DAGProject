package dag.controller;

import dag.dto.RestDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dag.service.SaveService;
import utils.SHA1Utils;

@RestController
public class SaveController {

    @Autowired
    private SaveService saveService;

    /***
     * 将数据存储到DAG中
     * @return
     */
    @RequestMapping(value = "saveDate", method = RequestMethod.POST)
    public RestDto saveData(String value) {
        RestDto restDto = new RestDto();

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
