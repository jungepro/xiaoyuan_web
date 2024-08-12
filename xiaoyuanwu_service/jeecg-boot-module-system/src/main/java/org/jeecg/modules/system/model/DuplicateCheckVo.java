package org.jeecg.modules.system.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value="重复校验数据模型",description="重复校验数据模型")
public class DuplicateCheckVo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value="表名",name="tableName",example="sys_log")
	private String tableName;
	
	
	@ApiModelProperty(value="字段名",name="fieldName",example="id")
	private String fieldName;
	
	
	@ApiModelProperty(value="字段值",name="fieldVal",example="1000")
	private String fieldVal;
	
	
	@ApiModelProperty(value="数据ID",name="dataId",example="2000")
	private String dataId;

}