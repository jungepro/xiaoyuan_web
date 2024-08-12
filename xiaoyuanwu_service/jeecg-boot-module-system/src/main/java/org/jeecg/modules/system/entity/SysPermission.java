package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@TableId(type = IdType.ASSIGN_ID)
	private String id;

	
	private String parentId;

	
	private String name;

	
	private String perms;
	
	private String permsType;

	
	private String icon;

	
	private String component;
	
	
	private String componentName;

	
	private String url;
	
	private String redirect;

	
	private Double sortNo;

	
	@Dict(dicCode = "menu_type")
	private Integer menuType;

	
	@TableField(value="is_leaf")
	private boolean leaf;
	
	
	@TableField(value="is_route")
	private boolean route;


	
	@TableField(value="keep_alive")
	private boolean keepAlive;

	
	private String description;

	
	private String createBy;

	
	private Integer delFlag;
	
	
	private Integer ruleFlag;
	
	
	private boolean hidden;

	
	private Date createTime;

	
	private String updateBy;

	
	private Date updateTime;
	
	
	private java.lang.String status;
	
	
    private boolean alwaysShow;

	
    
    private boolean internalOrExternal;
	

    public SysPermission() {
    	
    }
    public SysPermission(boolean index) {
    	if(index) {
    		this.id = "9502685863ab87f0ad1134142788a385";
        	this.name="首页";
        	this.component="dashboard/Analysis";
        	this.componentName="dashboard-analysis";
        	this.url="/dashboard/analysis";
        	this.icon="home";
        	this.menuType=0;
        	this.sortNo=0.0;
        	this.ruleFlag=0;
        	this.delFlag=0;
        	this.alwaysShow=false;
        	this.route=true;
        	this.keepAlive=true;
        	this.leaf=true;
        	this.hidden=false;
    	}
    	
    }
}
