package org.jeecg.modules.system.service;

import java.util.List;
import java.util.Map;

import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.modules.system.entity.SysCategory;
import org.jeecg.modules.system.model.TreeSelectModel;

import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysCategoryService extends IService<SysCategory> {

	
	public static final String ROOT_PID_VALUE = "0";

	void addSysCategory(SysCategory sysCategory);
	
	void updateSysCategory(SysCategory sysCategory);
	
	
	public List<TreeSelectModel> queryListByCode(String pcode) throws JeecgBootException;
	
	
	public List<TreeSelectModel> queryListByPid(String pid);

	
	public List<TreeSelectModel> queryListByPid(String pid, Map<String,String> condition);

	
	public String queryIdByCode(String code);

	
	void deleteSysCategory(String ids);
	
}
