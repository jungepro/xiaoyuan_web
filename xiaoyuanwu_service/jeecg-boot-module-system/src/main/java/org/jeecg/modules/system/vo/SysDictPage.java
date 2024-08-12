package org.jeecg.modules.system.vo;

import lombok.Data;
import org.jeecg.modules.system.entity.SysDictItem;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import java.util.List;

@Data
public class SysDictPage {

    
    private String id;
    
    @Excel(name = "字典名称", width = 20)
    private String dictName;

    
    @Excel(name = "字典编码", width = 30)
    private String dictCode;
    
    private Integer delFlag;
    
    @Excel(name = "描述", width = 30)
    private String description;

    @ExcelCollection(name = "字典列表")
    private List<SysDictItem> sysDictItemList;

}
