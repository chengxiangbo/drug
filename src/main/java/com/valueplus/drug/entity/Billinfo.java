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
 * 供应商账单信息(Billinfo)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:57
 */
@Data
@TableName(value = "billinfo")
public class Billinfo implements Serializable {
    private static final long serialVersionUID = 750928836446984308L;
    /**
     * 主键
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 供应商名称
     */
    private String sname;
    /**
     * 药品名称
     */
    private String dname;
    /**
     * 药品数量
     */
    private Integer count;
    /**
     * 总金额
     */
    private Float total;
    /**
     * 进货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;
    /**
     * 进货时间转换成字符串
     */
    public String getBuytimeStr() {
        return DateUtil.dateConvert(buytime);
    }

}
