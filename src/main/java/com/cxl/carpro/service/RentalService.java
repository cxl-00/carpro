package com.cxl.carpro.service;

import com.cxl.carpro.dao.model.RentalInfoDO;
import com.cxl.carpro.entity.dto.BookDTO;

import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:27 上午
 */
public interface RentalService {

    /**
     * get my rentals
     *
     * @param userId
     * @return
     */
    List<RentalInfoDO> myRentals(Integer userId);
}
