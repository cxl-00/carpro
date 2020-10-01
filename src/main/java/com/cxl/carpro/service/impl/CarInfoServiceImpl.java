package com.cxl.carpro.service.impl;

import com.cxl.carpro.comom.ResultCode;
import com.cxl.carpro.dao.model.CarInfoDO;
import com.cxl.carpro.dao.model.RentalInfoDO;
import com.cxl.carpro.entity.dto.BookDTO;
import com.cxl.carpro.exception.BusinessException;
import com.cxl.carpro.service.CarInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 12:20 上午
 */
@Service
@Slf4j
public class CarInfoServiceImpl implements CarInfoService {
    @Override
    public List<CarInfoDO> getList() {
        return new CarInfoDO().selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean bookCar(BookDTO bookDTO) {
        CarInfoDO carInfoDO = getCarInfo(bookDTO.getId());
        if(carInfoDO == null || carInfoDO.getCarStock() <= 0){
            throw new BusinessException(ResultCode.BOOK_NO_CAR_FOUND,"no car can book");
        }
        //update car stock
        Integer carStock = carInfoDO.getCarStock() -1;
        CarInfoDO car = new CarInfoDO();
        car.setCarStock(carStock);
        car.setId(bookDTO.getId());
        Boolean result = car.insertOrUpdate();
        if(!result){
            log.error("update car exception");
            throw new BusinessException(ResultCode.BAD_SERVICE_CODE,"bad service");
        }
        //add rentalInfo
        RentalInfoDO rentalInfoDO = new RentalInfoDO();
        rentalInfoDO.setStartTime(bookDTO.getStartTime());
        rentalInfoDO.setEndTime(bookDTO.getEndTime());
        rentalInfoDO.setUserId(bookDTO.getUserId());
        rentalInfoDO.setCarId(bookDTO.getId());
        rentalInfoDO.setCarModel(car.getCarModel());
        rentalInfoDO.setBookTime(LocalDateTime.now());
        result = rentalInfoDO.insertOrUpdate();
        if(!result){
            log.error("add rental exception");
            throw new BusinessException(ResultCode.BAD_SERVICE_CODE,"bad service");
        }
        return true;
    }

    /**
     *  get car information
     * @return
     */
    private CarInfoDO getCarInfo(Integer id){
        CarInfoDO carInfoDO = new CarInfoDO();
        return carInfoDO.selectById(id);
    }
}
