package com.cxl.carpro.dao.repository.impl;

import com.cxl.carpro.dao.model.UserInfoDO;
import com.cxl.carpro.dao.mapper.UserInfoMapper;
import com.cxl.carpro.dao.repository.UserInfoRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenxiaoling
 * @since 2020-10-01
 */
@Service
public class UserInfoRepositoryImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> implements UserInfoRepository {

}
