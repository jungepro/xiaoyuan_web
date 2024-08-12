package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    
    
    private Integer type;
    
    
    private String dictName;

    
    private String dictCode;

    
    private String description;

    
    @TableLogic
    private Integer delFlag;

    
    private String createBy;

    
    private Date createTime;

    
    private String updateBy;

    
    private Date updateTime;


}
