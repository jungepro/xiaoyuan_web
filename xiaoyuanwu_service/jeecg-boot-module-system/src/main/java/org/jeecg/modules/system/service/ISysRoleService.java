package org.jeecg.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.system.entity.SysRole;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.web.multipart.MultipartFile;


public interface ISysRoleService extends IService<SysRole> {

    
    Result importExcelCheckRoleCode(MultipartFile file, ImportParams params) throws Exception;

    
    public boolean deleteRole(String roleid);

    
    public boolean deleteBatchRole(String[] roleids);

}
