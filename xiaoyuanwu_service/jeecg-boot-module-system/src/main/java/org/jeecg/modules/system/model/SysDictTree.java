package org.jeecg.modules.system.model;

import java.io.Serializable;
import java.util.Date;

import org.jeecg.modules.system.entity.SysDict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDictTree implements Serializable {

    private static final long serialVersionUID = 1L;

    private String key;
	
	private String title;
	
    
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    
    private Integer type;
    
    
    private String dictName;

    
    private String dictCode;

    
    private String description;

    
    private Integer delFlag;

    
    private String createBy;

    
    private Date createTime;

    
    private String updateBy;

    
    private Date updateTime;
    
    public SysDictTree(SysDict node) {
    	this.id = node.getId();
		this.key = node.getId();
		this.title = node.getDictName();
		this.dictCode = node.getDictCode();
		this.description = node.getDescription();
		this.delFlag = node.getDelFlag();
		this.type = node.getType();
	}
    
}
