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
 * 退货给供应商(Returnsupplier)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:57
 */
@Data
@TableName(value = "returnsupplier")
public class Returnsupplier implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 药品名称
     */
    private String dname;
    /**
     * 数量
     */
    private Integer dcount;
    /**
     * 供应商名称
     */
    private String sname;
    /**
     * 进货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;
    /**
     * 退货原因
     */
    private String reason;
    /**
     * 退货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /**
     * 格式化时间
     * @return
     */
    public String getBuytimeStr(){
        return DateUtil.dateConvert(buytime);
    }
    /**
     * 格式化时间
     * @return
     */
    public String getCreatetimeStr(){
        return DateUtil.dateConvert(buytime);
    }

}
