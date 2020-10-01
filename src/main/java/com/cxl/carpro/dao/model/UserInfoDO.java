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
@TableName("user_info")
public class UserInfoDO extends Model<UserInfoDO> {

    private static final long serialVersionUID = 1L;

    /**
     * Primary key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * The user's name
     */
    @TableField("user_name")
    private String userName;

    /**
     * Login password
     */
    @TableField("passwd")
    private String passwd;

    /**
     * The user's contact info
     */
    @TableField("contact_info")
    private String contactInfo;


    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String PASSWD = "passwd";

    public static final String CONTACT_INFO = "contact_info";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
