package org.jeecg.modules.system.service;


import java.util.List;

import org.jeecg.modules.system.entity.SysUser;
import org.jeecg.modules.system.entity.SysUserDepart;
import org.jeecg.modules.system.model.DepartIdModel;


import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysUserDepartService extends IService<SysUserDepart> {
	

	
	List<DepartIdModel> queryDepartIdsOfUser(String userId);
	

	
	List<SysUser> queryUserByDepId(String depId);
  	
	public List<SysUser> queryUserByDepCode(String depCode,String realname);
}
