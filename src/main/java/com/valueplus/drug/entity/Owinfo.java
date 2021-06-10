package com.valueplus.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 出入库记录(Owinfo)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:57
 */
@Data
@TableName(value = "owinfo")
public class Owinfo implements Serializable {
    private static final long serialVersionUID = -84669766677619665L;
    /**
     * 主键
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 药品名称
     */
    private String dname;
    /**
     * 出库/入库
     */
    private String type;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作时间
     */
    private Date createtime;

}
