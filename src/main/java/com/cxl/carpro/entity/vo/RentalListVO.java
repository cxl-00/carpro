package com.cxl.carpro.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 2:46 下午
 */
@Data
public class RentalListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String carModel;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
