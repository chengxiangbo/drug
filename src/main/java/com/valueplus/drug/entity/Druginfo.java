package com.valueplus.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.valueplus.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * 药品信息(Druginfo)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:26
 */
@Data
@TableName(value = "druginfo")
public class Druginfo implements Serializable {
    private static final long serialVersionUID = -10916279257335128L;
    /**
     * 主键
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 供应商
     */
    private String supplier;
    /**
     * 生产时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;
    /**
     * 保质期（月）
     */
    private String warrenty;
    /**
     * 药品编号
     */
    private String number;
    /**
     * 价格
     */
    private Float price;
    /**
     * 库存
     */
    private Integer stock;

    /**
     * 生产日期转换成字符串
     */
    public String getProducttimestr() {
        return DateUtil.dateConvert(producttime);
    }
}
