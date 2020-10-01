package com.cxl.carpro.dao.repository.impl;

import com.cxl.carpro.dao.model.CarInfoDO;
import com.cxl.carpro.dao.mapper.CarInfoMapper;
import com.cxl.carpro.dao.repository.CarInfoRepository;
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
public class CarInfoRepositoryImpl extends ServiceImpl<CarInfoMapper, CarInfoDO> implements CarInfoRepository {

}
