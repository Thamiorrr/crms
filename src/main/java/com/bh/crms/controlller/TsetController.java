package com.bh.crms.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hasee
 * @Data 2021/1/27 10:18
 */
@Controller
public class TsetController {
    @RequestMapping("/test")
    public String index(){
        return "index";
    }
}
