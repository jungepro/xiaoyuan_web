package org.jeecg.modules.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.SysUserCacheInfo;
import org.jeecg.modules.system.entity.SysUser;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.model.SysUserSysDepartModel;
import org.springframework.transaction.annotation.Transactional;


public interface ISysUserService extends IService<SysUser> {

	
	public Result<?> resetPassword(String username, String oldpassword, String newpassword, String confirmpassword);

	
	public Result<?> changePassword(SysUser sysUser);

	
	public boolean deleteUser(String userId);

	
	public boolean deleteBatchUsers(String userIds);
	
	public SysUser getUserByName(String username);
	
	
	public void addUserWithRole(SysUser user,String roles);
	
	
	
	public void editUserWithRole(SysUser user,String roles);

	
	public List<String> getRole(String username);
	
	
	public SysUserCacheInfo getCacheUser(String username);

	
	public IPage<SysUser> getUserByDepId(Page<SysUser> page, String departId, String username);

	
	public IPage<SysUser> getUserByDepIds(Page<SysUser> page, List<String> departIds, String username);

	
	public Map<String,String> getDepNamesByUserIds(List<String> userIds);

    
    public IPage<SysUser> getUserByDepartIdAndQueryWrapper(Page<SysUser> page, String departId, QueryWrapper<SysUser> queryWrapper);

	
	IPage<SysUserSysDepartModel> queryUserByOrgCode(String orgCode, SysUser userParams, IPage page);

	
	public IPage<SysUser> getUserByRoleId(Page<SysUser> page,String roleId, String username);

	
	Set<String> getUserRolesSet(String username);

	
	Set<String> getUserPermissionsSet(String username);
	
	
	void updateUserDepart(String username,String orgCode);
	
	
	public SysUser getUserByPhone(String phone);


	
	public SysUser getUserByEmail(String email);


	
	void addUserWithDepart(SysUser user, String selectedParts);

	
	void editUserWithDepart(SysUser user, String departs);
	
	
	Result checkUserIsEffective(SysUser sysUser);

	
	List<SysUser> queryLogicDeleted();

	
	List<SysUser> queryLogicDeleted(LambdaQueryWrapper<SysUser> wrapper);

	
	boolean revertLogicDeleted(List<String> userIds, SysUser updateEntity);

	
	boolean removeLogicDeleted(List<String> userIds);

    
    @Transactional(rollbackFor = Exception.class)
    boolean updateNullPhoneEmail();

	
	void saveThirdUser(SysUser sysUser);

	
	List<SysUser> queryByDepIds(List<String> departIds, String username);
}
