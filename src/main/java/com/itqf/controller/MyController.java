package com.itqf.controller;

import com.itqf.pojo.TbMsg;
import com.itqf.service.TbMsgService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/19
 * @Time: 下午4:31
 */
//@Controller
@RestController
public class MyController {

    @Resource
    private TbMsgService tbMsgService;


    @RequestMapping("/find")
    public List<TbMsg>  find(){
        return tbMsgService.findAll();
    }

    @RequestMapping("/save")
    public boolean  save(TbMsg tbMsg){
        return tbMsgService.save(tbMsg);
    }


}
