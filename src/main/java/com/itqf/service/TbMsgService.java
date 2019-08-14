package com.itqf.service;

import com.itqf.pojo.TbMsg;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/19
 * @Time: 下午4:27
 */
public interface TbMsgService {//  alt+/ +enter


    public List<TbMsg> findAll();

    public boolean save(TbMsg msg);


}
