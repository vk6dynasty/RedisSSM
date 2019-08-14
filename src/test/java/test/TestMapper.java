package test;

import com.itqf.mapper.TbMsgMapper;
import com.itqf.pojo.TbMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/19
 * @Time: 下午4:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMapper {

    @Resource
    TbMsgMapper tbMsgMapper;

    @Test
    public  void   test(){


        TbMsg m = new TbMsg();
         m.setMsg("华为5g手机");
         m.setName("hello");

         tbMsgMapper.save(m);

        System.out.println(tbMsgMapper.findAl());


    }



}
