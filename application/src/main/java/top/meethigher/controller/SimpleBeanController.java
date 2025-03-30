package top.meethigher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.meethigher.config.SimpleBean;

import javax.annotation.Resource;

@RestController
public class SimpleBeanController {

    @Resource
    private SimpleBean simpleBean;


    @GetMapping("/**")
    public String result() {
        return simpleBean.getName();
    }
}
