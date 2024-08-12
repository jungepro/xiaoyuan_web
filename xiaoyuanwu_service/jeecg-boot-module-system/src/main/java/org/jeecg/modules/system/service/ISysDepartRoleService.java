package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysDepartRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface ISysDepartRoleService extends IService<SysDepartRole> {

    
    List<SysDepartRole> queryDeptRoleByDeptAndUser(String orgCode, String userId);

}
