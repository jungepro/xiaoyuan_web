package org.jeecg.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


@Data
@TableName("sys_category")
public class SysCategory implements Serializable,Comparable<SysCategory>{
    private static final long serialVersionUID = 1L;
    
	
	@TableId(type = IdType.ASSIGN_ID)
	private java.lang.String id;
	
	private java.lang.String pid;
	
	@Excel(name = "类型名称", width = 15)
	private java.lang.String name;
	
	@Excel(name = "类型编码", width = 15)
	private java.lang.String code;
	
	private java.lang.String createBy;
	
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	
	private java.lang.String updateBy;
	
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
	
	private java.lang.String sysOrgCode;
	
	@Excel(name = "是否有子节点(1:有)", width = 15)
	private java.lang.String hasChild;

	@Override
	public int compareTo(SysCategory o) {




		int	 s = this.code.length() - o.code.length();
		return s;
	}
	@Override
	public String toString() {
		return "SysCategory [code=" + code + ", name=" + name + "]";
	}
}
