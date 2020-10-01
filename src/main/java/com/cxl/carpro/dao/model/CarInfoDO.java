package com.cxl.carpro.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("car_info")
public class CarInfoDO extends Model<CarInfoDO> {

    private static final long serialVersionUID = 1L;

    /**
     * Primary key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * The car's model name
     */
    @TableField("car_model")
    private String carModel;

    /**
     * The car 's stock
     */
    @TableField("car_stock")
    private Integer carStock;

    /**
     * The car's total amount
     */
    @TableField("total")
    private Integer total;


    public static final String ID = "id";

    public static final String CAR_MODEL = "car_model";

    public static final String CAR_STOCK = "car_stock";

    public static final String TOTAL = "total";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
