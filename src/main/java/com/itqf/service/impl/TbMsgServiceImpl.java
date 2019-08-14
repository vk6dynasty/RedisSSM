package com.itqf.service.impl;

import com.itqf.mapper.TbMsgMapper;
import com.itqf.pojo.TbMsg;
import com.itqf.service.TbMsgService;
import com.itqf.utils.SysConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/19
 * @Time: 下午4:28
 */
@Service
public class TbMsgServiceImpl implements TbMsgService {

    @Resource
    private TbMsgMapper tbMsgMapper;

    //如何操作 redis???  jedis
    //RedisTemplate
    @Resource
    private RedisTemplate<String, TbMsg> redisTemplate;



    @Override
    public List<TbMsg> findAll() {
        //1，先查询缓存,缓存中有     直接返回

//        redisTemplate.opsForList()  list
//        redisTemplate.opsForHash()  hash
//        redisTemplate.opsForValue();//String
//        redisTemplate.opsForSet()  set
//        redisTemplate.opsForZSet(); zset

        List<TbMsg>  list = redisTemplate.opsForList().range(SysConstant.MSG_LIST_KEY,0,-1);
        if (list!=null&&list.size()>0){
            //缓存中
            System.out.println("---------》走缓存"+list);
           return  list;
        }else{
            System.out.println("---------》走数据库");
            //1,查
            list = tbMsgMapper.findAl();
            //2,同步缓存
           Long  l = redisTemplate.opsForList().rightPushAll(SysConstant.MSG_LIST_KEY,list);
            System.out.println("---------》同步缓存");

        }


        return list;
    }

    @Override
    public boolean save(TbMsg msg) {

        int i = tbMsgMapper.save(msg);
        if (i>0){
            redisTemplate.delete(SysConstant.MSG_LIST_KEY);
        }

        //方法1： del/add/update  , 删除缓存中对应数据

        //方法2： del/add/update
        //add:取出缓存中数据, list.add（msg）；
        //redisTemplate.opsForList().rightPush(SysConstant.MSG_LIST_KEY,msg);
        //del
        //redisTemplate.opsForList().remove(SysConstant.MSG_LIST_KEY,0,msg);
        //update
        //redisTemplate.opsForList().set();

        return i>0;
    }
}
