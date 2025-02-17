package org.jeecg.modules.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.system.entity.SysPermissionDataRule;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface SysPermissionDataRuleMapper extends BaseMapper<SysPermissionDataRule> {
	
	
	public List<String> queryDataRuleIds(@Param("username") String username,@Param("permissionId") String permissionId);

}
