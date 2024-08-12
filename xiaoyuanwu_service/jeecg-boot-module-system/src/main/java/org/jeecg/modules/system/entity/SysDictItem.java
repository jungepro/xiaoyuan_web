package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDictItem implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    
    private String dictId;

    
    @Excel(name = "字典项文本", width = 20)
    private String itemText;

    
    @Excel(name = "字典项值", width = 30)
    private String itemValue;

    
    @Excel(name = "描述", width = 40)
    private String description;

    
    @Excel(name = "排序", width = 15,type=4)
    private Integer sortOrder;


    
    @Dict(dicCode = "dict_item_status")
    private Integer status;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;


}
