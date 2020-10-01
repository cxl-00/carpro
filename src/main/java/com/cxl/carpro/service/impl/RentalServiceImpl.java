package com.cxl.carpro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxl.carpro.dao.model.CarInfoDO;
import com.cxl.carpro.dao.model.RentalInfoDO;
import com.cxl.carpro.dao.repository.RentalInfoRepository;
import com.cxl.carpro.entity.dto.BookDTO;
import com.cxl.carpro.service.RentalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:30 上午
 */
@Service
public class RentalServiceImpl implements RentalService {

    @Resource
    private RentalInfoRepository rentalInfoRepository;

    @Override
    public List<RentalInfoDO> myRentals(Integer userId) {
        RentalInfoDO rentalInfoDO = new RentalInfoDO();
        QueryWrapper<RentalInfoDO> wrapper = new QueryWrapper();
        wrapper.eq(RentalInfoDO.USER_ID,userId);
        return rentalInfoDO.selectList(wrapper);
    }
}
