package org.jeecg.modules.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.system.model.SysUserSysDepartModel;
import org.jeecg.modules.system.vo.SysUserDepVo;

import java.util.List;


public interface SysUserMapper extends BaseMapper<SysUser> {
	
	public SysUser getUserByName(@Param("username") String username);

	
	IPage<SysUser> getUserByDepId(Page page, @Param("departId") String departId, @Param("username") String username);

	
	List<SysUserDepVo> getDepNamesByUserIds(@Param("userIds")List<String> userIds);

	
	IPage<SysUser> getUserByDepIds(Page page, @Param("departIds") List<String> departIds, @Param("username") String username);

	
	IPage<SysUser> getUserByRoleId(Page page, @Param("roleId") String roleId, @Param("username") String username);
	
	
	void updateUserDepart(@Param("username") String username,@Param("orgCode") String orgCode);
	
	
	public SysUser getUserByPhone(@Param("phone") String phone);
	
	
	
	public SysUser getUserByEmail(@Param("email")String email);

	
	List<SysUserSysDepartModel> getUserByOrgCode(IPage page, @Param("orgCode") String orgCode, @Param("userParams") SysUser userParams);


    
    Integer getUserByOrgCodeTotal(@Param("orgCode") String orgCode, @Param("userParams") SysUser userParams);

    
	void deleteBathRoleUserRelation(@Param("roleIdArray") String[] roleIdArray);

    
	void deleteBathRolePermissionRelation(@Param("roleIdArray") String[] roleIdArray);

	
	List<SysUser> selectLogicDeleted(@Param(Constants.WRAPPER) Wrapper<SysUser> wrapper);

	
	int revertLogicDeleted(@Param("userIds") String userIds, @Param("entity") SysUser entity);

	
	int deleteLogicDeleted(@Param("userIds") String userIds);

    
    int updateNullByEmptyString(@Param("fieldName") String fieldName);
    
	
	List<SysUser> queryByDepIds(@Param("departIds")List<String> departIds,@Param("username") String username);
}
