package com.valueplus.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.valueplus.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 退货表记录(Returngoods)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:57
 */
@Data
@TableName(value = "returngoods")
public class Returngoods implements Serializable {
    private static final long serialVersionUID = -73194539812143890L;
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
     * 数量
     */
    private Integer count;
    /**
     * 退货原因
     */
    private String reason;
    /**
     * 退货总金额
     */
    private Float total;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;

    /**
     * 格式化时间
     * @return
     */
    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }
}
