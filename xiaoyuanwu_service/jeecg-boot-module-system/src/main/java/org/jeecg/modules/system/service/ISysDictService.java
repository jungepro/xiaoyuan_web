package org.jeecg.modules.system.service;

import java.util.List;
import java.util.Map;

import org.jeecg.common.system.vo.DictModel;
import org.jeecg.common.system.vo.DictQuery;
import org.jeecg.modules.system.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.entity.SysDictItem;
import org.jeecg.modules.system.model.TreeSelectModel;


public interface ISysDictService extends IService<SysDict> {

    public List<DictModel> queryDictItemsByCode(String code);

    public Map<String,List<DictModel>> queryAllDictItems();

    @Deprecated
    List<DictModel> queryTableDictItemsByCode(String table, String text, String code);

    @Deprecated
	public List<DictModel> queryTableDictItemsByCodeAndFilter(String table, String text, String code, String filterSql);

    public String queryDictTextByKey(String code, String key);

    @Deprecated
	String queryTableDictTextByKey(String table, String text, String code, String key);

	@Deprecated
	List<String> queryTableDictByKeys(String table, String text, String code, String keys);

    
    boolean deleteByDictId(SysDict sysDict);

    
    public Integer saveMain(SysDict sysDict, List<SysDictItem> sysDictItemList);
    
    
	public List<DictModel> queryAllDepartBackDictModel();
	
	
	public List<DictModel> queryAllUserBackDictModel();
	
	
	@Deprecated
	public List<DictModel> queryTableDictItems(String table, String text, String code,String keyword);

	
	public List<DictModel> queryLittleTableDictItems(String table, String text, String code,String keyword, int pageSize);
	
	@Deprecated
	List<TreeSelectModel> queryTreeList(Map<String, String> query,String table, String text, String code, String pidField,String pid,String hasChildField);

	
	public void deleteOneDictPhysically(String id);

	
	public void updateDictDelFlag(int delFlag,String id);

	
	public List<SysDict> queryDeleteList();

	
	@Deprecated
	public List<DictModel> queryDictTablePageList(DictQuery query,int pageSize, int pageNo);

}
