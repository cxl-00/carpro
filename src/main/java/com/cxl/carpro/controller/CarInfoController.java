package com.cxl.carpro.controller;


import com.cxl.carpro.comom.RestBaseResponse;
import com.cxl.carpro.dao.model.CarInfoDO;
import com.cxl.carpro.entity.dto.BookDTO;
import com.cxl.carpro.service.CarInfoService;
import io.swagger.v3.oas.annotations.Operation;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenxiaoling
 * @since 2020-09-30
 */
@RestController
@RequestMapping("/api/v1/carInfo")
public class CarInfoController {
    private final CarInfoService carInfoService;
    @Autowired
    public CarInfoController(CarInfoService carInfoService){
        this.carInfoService =  carInfoService;
    }
    @GetMapping
    @Operation(summary="carInfo",description="get all carInfo")
    public RestBaseResponse<List<CarInfoDO>> getAll(){
       List<CarInfoDO> list = this.carInfoService.getList();
       return RestBaseResponse.success(list);
    }

    @PostMapping("/book")
    @Operation(summary="book car",description="simple login")
    public RestBaseResponse<Boolean> bookCar(@RequestBody @Valid BookDTO bookDTO){
        Boolean result = this.carInfoService.bookCar(bookDTO);
        return RestBaseResponse.success(result);
    }
}
