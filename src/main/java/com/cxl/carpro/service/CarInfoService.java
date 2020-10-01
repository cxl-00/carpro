package com.cxl.carpro.service;

import com.cxl.carpro.dao.model.CarInfoDO;
import com.cxl.carpro.entity.dto.BookDTO;
import com.cxl.carpro.entity.vo.CarInfoListVO;

import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/9/30 11:59 下午
 */
public interface CarInfoService {
    /**
     * get all car list
     * @return
     */
    List<CarInfoDO> getList();

    Boolean bookCar(BookDTO bookDTO);
}
