package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysRolePermissionService extends IService<SysRolePermission> {
	
	
	public void saveRolePermission(String roleId,String permissionIds);
	
	
	public void saveRolePermission(String roleId,String permissionIds,String lastPermissionIds);

}
