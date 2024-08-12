package org.jeecg.modules.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    
    @Excel(name = "登录账号", width = 15)
    private String username;

    
    @Excel(name = "真实姓名", width = 15)
    private String realname;

    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    
    @Excel(name = "头像", width = 15,type = 2)
    private String avatar;

    
    @Excel(name = "生日", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    
    @Excel(name = "性别", width = 15,dicCode="sex")
    @Dict(dicCode = "sex")
    private Integer sex;

    
    @Excel(name = "电子邮件", width = 15)
    private String email;

    
    @Excel(name = "电话", width = 15)
    private String phone;

    
    private String orgCode;

    
    private transient String orgCodeTxt;

    
    @Excel(name = "状态", width = 15,dicCode="user_status")
    @Dict(dicCode = "user_status")
    private Integer status;

    
    @Excel(name = "删除状态", width = 15,dicCode="del_flag")
    @TableLogic
    private Integer delFlag;

    
    @Excel(name = "工号", width = 15)
    private String workNo;

    
    @Excel(name = "职务", width = 15)
    @Dict(dictTable ="sys_position",dicText = "name",dicCode = "code")
    private String post;

    
    @Excel(name = "座机号", width = 15)
    private String telephone;

    
    private String createBy;

    
    private Date createTime;

    
    private String updateBy;

    
    private Date updateTime;
    
    private Integer activitiSync;

    
    @Excel(name="（1普通成员 2上级）",width = 15)
    private Integer userIdentity;

    
    @Excel(name="负责部门",width = 15,dictTable ="sys_depart",dicText = "depart_name",dicCode = "id")
    @Dict(dictTable ="sys_depart",dicText = "depart_name",dicCode = "id")
    private String departIds;

    
    private String relTenantIds;

    
    private String clientId;
}
