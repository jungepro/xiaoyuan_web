package org.jeecg.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.model.DepartIdModel;
import org.jeecg.modules.system.model.SysDepartTreeModel;
import java.util.List;


public interface ISysDepartService extends IService<SysDepart>{

    
    List<SysDepartTreeModel> queryMyDeptTreeList(String departIds);

    
    List<SysDepartTreeModel> queryTreeList();

    
    public List<DepartIdModel> queryDepartIdTreeList();

    
    void saveDepartData(SysDepart sysDepart,String username);

    
    Boolean updateDepartDataById(SysDepart sysDepart,String username);
    
    
	
    
    
    List<SysDepartTreeModel> searhBy(String keyWord,String myDeptSearch,String departIds);
    
    
    boolean delete(String id);
    
    
	public List<SysDepart> queryUserDeparts(String userId);

    
    List<SysDepart> queryDepartsByUsername(String username);

	 
	void deleteBatchWithChildren(List<String> ids);

    
    List<String> getSubDepIdsByDepId(String departId);

    
    List<String> getMySubDepIdsByDepId(String departIds);
    
    List<SysDepartTreeModel> queryTreeByKeyWord(String keyWord);
    
    List<SysDepartTreeModel> queryTreeListByPid(String parentId);
    
    SysDepart queryCompByOrgCode(String orgCode);
    
    List<SysDepart> queryDeptByPid(String pid);
}
