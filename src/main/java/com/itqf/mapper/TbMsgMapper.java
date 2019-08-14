package com.itqf.mapper;

import com.itqf.pojo.TbMsg;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/19
 * @Time: 下午4:17
 */

public interface TbMsgMapper {

    List<TbMsg>  findAl();


   int  save(TbMsg msg);




}
