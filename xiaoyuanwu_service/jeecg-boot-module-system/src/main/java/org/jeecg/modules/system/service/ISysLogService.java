package org.jeecg.modules.system.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jeecg.modules.system.entity.SysLog;

import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysLogService extends IService<SysLog> {

	
	public void removeAll();
	
	
	Long findTotalVisitCount();


	
	Long findTodayVisitCount(Date dayStart, Date dayEnd);

	
	Long findTodayIp(Date dayStart, Date dayEnd);

	
	
	List<Map<String,Object>> findVisitCount(Date dayStart, Date dayEnd);
}
