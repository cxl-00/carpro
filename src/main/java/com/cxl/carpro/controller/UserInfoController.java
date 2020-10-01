package com.cxl.carpro.controller;


import com.cxl.carpro.comom.RestBaseResponse;
import com.cxl.carpro.dao.model.CarInfoDO;
import com.cxl.carpro.dao.model.UserInfoDO;
import com.cxl.carpro.entity.dto.LoginDTO;
import com.cxl.carpro.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/api/v1/user")
public class UserInfoController {
    private final UserService userService;

    @Autowired
    public UserInfoController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary="login",description="simple login")
    public RestBaseResponse<Integer> Login(@RequestBody @Valid LoginDTO loginDTO){
        UserInfoDO user = this.userService.login(loginDTO);
        return RestBaseResponse.success(user.getId());
    }
}
