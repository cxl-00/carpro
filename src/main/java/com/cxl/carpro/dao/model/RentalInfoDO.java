package com.cxl.carpro.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiaoling
 * @since 2020-10-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rental_info")
public class RentalInfoDO extends Model<RentalInfoDO> {

    private static final long serialVersionUID = 1L;

    /**
     * primary key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * The car'id which the user had booked
     */
    @TableField("car_id")
    private Integer carId;

    /**
     * The user's id who book the car
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * Car rental start time
     */
    @TableField("start_time")
    private LocalDateTime startTime;

    /**
     * Car rental end time
     */
    @TableField("end_time")
    private LocalDateTime endTime;

    /**
     * The time when the user book car
     */
    @TableField("book_time")
    private LocalDateTime bookTime;

    /**
     * The car model new that user booked
     */
    @TableField("car_model")
    private String carModel;


    public static final String ID = "id";

    public static final String CAR_ID = "car_id";

    public static final String USER_ID = "user_id";

    public static final String START_TIME = "start_time";

    public static final String END_TIME = "end_time";

    public static final String BOOK_TIME = "book_time";

    public static final String CAR_MODEL = "car_model";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
