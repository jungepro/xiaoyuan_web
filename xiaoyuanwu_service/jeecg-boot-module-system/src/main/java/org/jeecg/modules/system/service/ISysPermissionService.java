package org.jeecg.modules.system.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.modules.system.entity.SysPermission;
import org.jeecg.modules.system.model.TreeModel;

import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysPermissionService extends IService<SysPermission> {
	
	public List<TreeModel> queryListByParentId(String parentId);
	
	
	public void deletePermission(String id) throws JeecgBootException;
	
	public void deletePermissionLogical(String id) throws JeecgBootException;
	
	public void addPermission(SysPermission sysPermission) throws JeecgBootException;
	
	public void editPermission(SysPermission sysPermission) throws JeecgBootException;
	
	public List<SysPermission> queryByUser(String username);
	
	
	public void deletePermRuleByPermId(String id);
	
	
	public List<String> queryPermissionUrlWithStar();

	
	public boolean hasPermission(String username, SysPermission sysPermission);

	
	public boolean hasPermission(String username, String url);
}
