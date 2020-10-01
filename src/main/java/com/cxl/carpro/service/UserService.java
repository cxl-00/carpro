package com.cxl.carpro.service;

import com.cxl.carpro.dao.model.UserInfoDO;
import com.cxl.carpro.entity.dto.LoginDTO;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:04 上午
 */
public interface UserService {
    /**
     * login
     *
     * @param loginDTO
     * @return
     */
    UserInfoDO login(LoginDTO loginDTO);
}
