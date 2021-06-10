package com.valueplus.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.valueplus.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 销售记录(Saleinfo)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:57
 */
@Data
@TableName(value = "saleinfo")
public class Saleinfo implements Serializable {
    private static final long serialVersionUID = -13624760170089598L;
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
     * 药品编号
     */
    private String dnumber;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 金额
     */
    private Float total;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;

    /**
     * 生产日期转换成字符串
     */
    public String getOperatetimestr() {
        return DateUtil.dateConvert(operatetime);
    }

}
