package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysDataLog;

import com.baomidou.mybatisplus.extension.service.IService;

public interface ISysDataLogService extends IService<SysDataLog> {
	
	
	public void addDataLog(String tableName, String dataId, String dataContent);

}
