package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysThirdAccount;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.entity.SysUser;


public interface ISysThirdAccountService extends IService<SysThirdAccount> {
    
    void updateThirdUserId(SysUser sysUser,String thirdUserUuid);
    
    SysUser createUser(String phone, String thirdUserUuid);
    
}
