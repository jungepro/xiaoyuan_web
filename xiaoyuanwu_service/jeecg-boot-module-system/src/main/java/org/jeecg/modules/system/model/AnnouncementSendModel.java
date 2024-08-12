package org.jeecg.modules.system.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class AnnouncementSendModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
	
	@TableId(type = IdType.ASSIGN_ID)
	private java.lang.String id;
	
	private java.lang.String anntId;
	
	private java.lang.String userId;
	
	private java.lang.String titile;
	
	private java.lang.String msgContent;
	
	private java.lang.String sender;
	
	private java.lang.String priority;
	
	private java.lang.String readFlag;
	
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date sendTime;
	
	private java.lang.Integer pageNo;
	
	private java.lang.Integer pageSize;
    
    private java.lang.String msgCategory;
	
	private java.lang.String busId;
	
	private java.lang.String busType;
	
	private java.lang.String openType;
	
	private java.lang.String openPage;

	
	private java.lang.String bizSource;

	
	private java.lang.String msgAbstract;

}
