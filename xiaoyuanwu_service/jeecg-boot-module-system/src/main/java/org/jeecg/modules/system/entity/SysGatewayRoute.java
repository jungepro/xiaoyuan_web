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

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("sys_gateway_route")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_gateway_route对象", description="gateway路由管理")
public class SysGatewayRoute implements Serializable {
    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;

    
    @ApiModelProperty(value = "路由ID")
    private String routerId;

    
    @Excel(name = "服务名", width = 15)
    @ApiModelProperty(value = "服务名")
    private String name;

    
    @Excel(name = "服务地址", width = 15)
    @ApiModelProperty(value = "服务地址")
    private String uri;

    
    private String predicates;

    
    private String filters;

    
    @Excel(name = "忽略前缀", width = 15)
    @ApiModelProperty(value = "忽略前缀")
    @Dict(dicCode = "yn")
    private Integer stripPrefix;

    
    @Excel(name = "是否重试", width = 15)
    @ApiModelProperty(value = "是否重试")
    @Dict(dicCode = "yn")
    private Integer retryable;

    
    @Excel(name = "保留数据", width = 15)
    @ApiModelProperty(value = "保留数据")
    @Dict(dicCode = "yn")
    private Integer persistable;

    
    @Excel(name = "在接口文档中展示", width = 15)
    @ApiModelProperty(value = "在接口文档中展示")
    @Dict(dicCode = "yn")
    private Integer showApi;

    
    @Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    @Dict(dicCode = "yn")
    private Integer status;

    
    @ApiModelProperty(value = "创建人")
    private String createBy;
    
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
    
}
