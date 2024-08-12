package org.jeecg.modules.system.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.entity.SysCheckRule;


public interface ISysCheckRuleService extends IService<SysCheckRule> {

    
    SysCheckRule getByCode(String ruleCode);


    
    JSONObject checkValue(SysCheckRule checkRule, String value);

}
