package org.jeecg.modules.system.entity;

import java.util.Date;

import org.jeecg.common.aspect.annotation.Dict;
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
public class SysLog implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@TableId(type = IdType.ASSIGN_ID)
	private String id;

	
	private String createBy;

	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	
	private String updateBy;

	
	private Date updateTime;

	
	private Long costTime;

	
	private String ip;

	
	private String requestParam;

	
	private String requestType;

	
	private String requestUrl;
	
	private String method;

	
	private String username;
	
	private String userid;
	
	private String logContent;

	
	@Dict(dicCode = "log_type")
	private Integer logType;

	
	@Dict(dicCode = "operate_type")
	private Integer operateType;

}
