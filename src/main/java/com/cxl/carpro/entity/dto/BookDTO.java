package com.cxl.carpro.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:05 上午
 */
@Data
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * the car id
     */
    @NotNull
    private Integer id;

    /**
     * user id
     */
    @NotNull
    private Integer userId;

    /**
     * start time
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * end time
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
