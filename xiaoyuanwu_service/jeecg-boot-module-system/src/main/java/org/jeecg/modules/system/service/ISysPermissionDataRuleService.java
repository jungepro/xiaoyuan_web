package org.jeecg.modules.system.service;

import java.util.List;

import org.jeecg.modules.system.entity.SysPermissionDataRule;

import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysPermissionDataRuleService extends IService<SysPermissionDataRule> {

	
	List<SysPermissionDataRule> getPermRuleListByPermId(String permissionId);

	
	List<SysPermissionDataRule> queryPermissionRule(SysPermissionDataRule permRule);
	
	
	
	List<SysPermissionDataRule> queryPermissionDataRules(String username,String permissionId);
	
	
	public void savePermissionDataRule(SysPermissionDataRule sysPermissionDataRule);
	
	
	public void deletePermissionDataRule(String dataRuleId);
	
	
}
