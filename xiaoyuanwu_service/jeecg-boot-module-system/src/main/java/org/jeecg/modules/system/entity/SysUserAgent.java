package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;


@Data
@TableName("sys_user_agent")
public class SysUserAgent implements Serializable {
    private static final long serialVersionUID = 1L;
    
	
	@TableId(type = IdType.ASSIGN_ID)
	private java.lang.String id;
	
	@Excel(name = "用户名", width = 15)
	private java.lang.String userName;
	
	@Excel(name = "代理人用户名", width = 15)
	private java.lang.String agentUserName;
	
	@Excel(name = "代理开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date startTime;
	
	@Excel(name = "代理结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date endTime;
	
	@Excel(name = "状态0无效1有效", width = 15)
	private java.lang.String status;
	
	@Excel(name = "创建人名称", width = 15)
	private java.lang.String createName;
	
	@Excel(name = "创建人登录名称", width = 15)
	private java.lang.String createBy;
	
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	
	@Excel(name = "更新人名称", width = 15)
	private java.lang.String updateName;
	
	@Excel(name = "更新人登录名称", width = 15)
	private java.lang.String updateBy;
	
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
	
	@Excel(name = "所属部门", width = 15)
	private java.lang.String sysOrgCode;
	
	@Excel(name = "所属公司", width = 15)
	private java.lang.String sysCompanyCode;
}
