package org.jeecg.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@TableName("sys_data_source")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "sys_data_source对象", description = "多数据源管理")
public class SysDataSource {

    
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
    
    @Excel(name = "数据源编码", width = 15)
    @ApiModelProperty(value = "数据源编码")
    private java.lang.String code;
    
    @Excel(name = "数据源名称", width = 15)
    @ApiModelProperty(value = "数据源名称")
    private java.lang.String name;
    
    @Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
    
    @Dict(dicCode = "database_type")
    @Excel(name = "数据库类型", width = 15, dicCode = "database_type")
    @ApiModelProperty(value = "数据库类型")
    private java.lang.String dbType;
    
    @Excel(name = "驱动类", width = 15)
    @ApiModelProperty(value = "驱动类")
    private java.lang.String dbDriver;
    
    @Excel(name = "数据源地址", width = 15)
    @ApiModelProperty(value = "数据源地址")
    private java.lang.String dbUrl;
    
    @Excel(name = "数据库名称", width = 15)
    @ApiModelProperty(value = "数据库名称")
    private java.lang.String dbName;
    
    @Excel(name = "用户名", width = 15)
    @ApiModelProperty(value = "用户名")
    private java.lang.String dbUsername;
    
    @Excel(name = "密码", width = 15)
    @ApiModelProperty(value = "密码")
    private java.lang.String dbPassword;
    
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
    
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
    
    @Excel(name = "所属部门", width = 15)
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
}
