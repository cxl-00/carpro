package com.cxl.carpro.controller;


import com.cxl.carpro.comom.RestBaseResponse;
import com.cxl.carpro.dao.model.RentalInfoDO;
import com.cxl.carpro.dao.model.UserInfoDO;
import com.cxl.carpro.entity.dto.BookDTO;
import com.cxl.carpro.entity.dto.LoginDTO;
import com.cxl.carpro.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/v1/rentals")
public class RentalInfoController {
    private final RentalService rentalService;

    @Autowired
    public RentalInfoController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping
    @Operation(summary="login",description="simple login")
    public RestBaseResponse<List<RentalInfoDO>> getMyRentals(@RequestParam Integer userId){
        List<RentalInfoDO> rentalInfoList= this.rentalService.myRentals(userId);
        return RestBaseResponse.success(rentalInfoList);
    }
}
