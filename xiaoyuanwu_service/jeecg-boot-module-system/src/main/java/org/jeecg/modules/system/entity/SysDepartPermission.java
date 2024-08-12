package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;


@Data
@TableName("sys_depart_permission")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_depart_permission对象", description="部门权限表")
public class SysDepartPermission {
    
	
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
	private java.lang.String id;
	
	@Excel(name = "部门id", width = 15)
    @ApiModelProperty(value = "部门id")
	private java.lang.String departId;
	
	@Excel(name = "权限id", width = 15)
    @ApiModelProperty(value = "权限id")
	private java.lang.String permissionId;
	
	@ApiModelProperty(value = "数据规则id")
	private java.lang.String dataRuleIds;

	public SysDepartPermission() {

	}

	public SysDepartPermission(String departId, String permissionId) {
		this.departId = departId;
		this.permissionId = permissionId;
	}
}
