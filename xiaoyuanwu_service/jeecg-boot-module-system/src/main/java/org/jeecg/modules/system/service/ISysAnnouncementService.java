package org.jeecg.modules.system.service;

import org.jeecg.modules.system.entity.SysAnnouncement;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ISysAnnouncementService extends IService<SysAnnouncement> {

	public void saveAnnouncement(SysAnnouncement sysAnnouncement);

	public boolean upDateAnnouncement(SysAnnouncement sysAnnouncement);

	public void saveSysAnnouncement(String title, String msgContent);

	public Page<SysAnnouncement> querySysCementPageByUserId(Page<SysAnnouncement> page,String userId,String msgCategory);


}
