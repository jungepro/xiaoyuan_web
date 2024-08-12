package org.jeecg.modules.caiwu.entity;

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

/**
 * @Description: 报销
 * @Author: qjh
 * @Date: 2021-04-25
 * @Version: V1.0
 */
@Data
@TableName("bao_xiao")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "bao_xiao对象", description = "报销")
public class BaoXiao implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    /**
     * 更新日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
    /**
     * 用户id
     */
    @Excel(name = "用户id", width = 15)
    @ApiModelProperty(value = "用户id")
    private String userId;
    /**
     * 用户姓名
     */
    @Excel(name = "用户姓名", width = 15)
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    /**
     * 报销类型
     */
    @Excel(name = "报销类型", width = 15, dicCode = "baoxiao_type")
    @Dict(dicCode = "baoxiao_type")
    @ApiModelProperty(value = "报销类型")
    private String baoxiaoType;
    /**
     * 报销详情
     */
    @Excel(name = "报销详情", width = 15)
    @ApiModelProperty(value = "报销详情")
    private String baoxiaoInfo;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 15, dicCode = "baoxiao_status")
    @Dict(dicCode = "baoxiao_status")
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 审核id
     */
    @Excel(name = "审核id", width = 15)
    @ApiModelProperty(value = "审核id")
    private String shenheId;
    /**
     * 审核姓名
     */
    @Excel(name = "审核姓名", width = 15)
    @ApiModelProperty(value = "审核姓名")
    private String shenheName;
    /**
     * 审核详情
     */
    @Excel(name = "审核详情", width = 15)
    @ApiModelProperty(value = "审核详情")
    private String shenheInfo;
    /**
     * 报销图片
     */
    @Excel(name = "报销图片", width = 15)
    @ApiModelProperty(value = "报销图片")
    private String image;

    private String baoxiaoMoney;
}
