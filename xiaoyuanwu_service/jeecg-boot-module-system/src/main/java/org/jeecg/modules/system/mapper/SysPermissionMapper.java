package org.jeecg.modules.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jeecg.modules.system.entity.SysPermission;
import org.jeecg.modules.system.model.TreeModel;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface SysPermissionMapper extends BaseMapper<SysPermission> {
	
	public List<TreeModel> queryListByParentId(@Param("parentId") String parentId);
	
	
	public List<SysPermission> queryByUser(@Param("username") String username);
	
	
	@Update("update sys_permission set is_leaf=#{leaf} where id = #{id}")
	public int setMenuLeaf(@Param("id") String id,@Param("leaf") int leaf);
	
	
	@Select("SELECT url FROM sys_permission WHERE del_flag = 0 and menu_type = 2 and url like '%*%'")
    public List<String> queryPermissionUrlWithStar();


	
	public int queryCountByUsername(@Param("username") String username, @Param("permission") SysPermission sysPermission);



}
