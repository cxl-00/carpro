package com.cxl.carpro.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 12:00 上午
 */
@Data
public class CarInfoListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * car model name
     */
    private String carModel;

    /**
     * car stock
     */
    private Integer carStock;
}
