package com.valueplus.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 问题药品(Problem)实体类
 *
 * @author makejava
 * @since 2021-05-27 14:07:57
 */
@Data
@TableName(value = "problem")
public class Problem implements Serializable {
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
     * 问题药品数量
     */
    private Integer dcount;
    /**
     * 药品单价
     */
    private Float dprice;
    /**
     * 问题原因
     */
    private String resaon;
    /**
     * 操作时间
     */
    private Date createtime;
}
