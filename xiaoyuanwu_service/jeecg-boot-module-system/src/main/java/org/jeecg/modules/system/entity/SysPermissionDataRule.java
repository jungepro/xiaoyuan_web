package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermissionDataRule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	
	
	private String permissionId;
	
	
	private String ruleName;
	
	
	private String ruleColumn;
	
	
	private String ruleConditions;
	
	
	private String ruleValue;
	
	
	private String status;
	
	
	private Date createTime;
	
	
	private String createBy;
	
	
	private Date updateTime;
	
	
	private String updateBy;
}
