package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysDepartRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysDepartRolePermissionService extends IService<SysDepartRolePermission> {
    
    public void saveDeptRolePermission(String roleId,String permissionIds,String lastPermissionIds);
}
