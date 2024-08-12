package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysDepartPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.entity.SysPermissionDataRule;

import java.util.List;


public interface ISysDepartPermissionService extends IService<SysDepartPermission> {
    
    public void saveDepartPermission(String departId,String permissionIds,String lastPermissionIds);

    
    List<SysPermissionDataRule> getPermRuleListByDeptIdAndPermId(String departId,String permissionId);
}
