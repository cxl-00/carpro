package com.cxl.carpro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxl.carpro.comom.ResultCode;
import com.cxl.carpro.dao.model.UserInfoDO;
import com.cxl.carpro.entity.dto.LoginDTO;
import com.cxl.carpro.exception.BusinessException;
import com.cxl.carpro.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:09 上午
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfoDO login(LoginDTO loginDTO) {
        UserInfoDO userInfoDO = new UserInfoDO();
        QueryWrapper<UserInfoDO> wrapper = new QueryWrapper();
        wrapper.eq(UserInfoDO.USER_NAME,loginDTO.getUserName());
        wrapper.eq(UserInfoDO.PASSWD,loginDTO.getPassword());
        userInfoDO = userInfoDO.selectOne(wrapper);
        if(userInfoDO == null){
           throw new BusinessException(ResultCode.USER_PARAM_INVALID,"username or password invalid");
        }
        return userInfoDO;
    }
}
