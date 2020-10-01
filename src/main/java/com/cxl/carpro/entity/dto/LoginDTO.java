package com.cxl.carpro.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:04 上午
 */
@Data
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user name
     */
    @NotBlank(message = "userName can not be null")
    private String userName;

    /**
     * password
     */
    @NotBlank(message = "password can not be null")
    private String password;
}
