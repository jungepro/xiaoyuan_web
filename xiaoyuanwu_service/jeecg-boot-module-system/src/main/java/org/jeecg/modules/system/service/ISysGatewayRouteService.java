package org.jeecg.modules.system.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.entity.SysGatewayRoute;


public interface ISysGatewayRouteService extends IService<SysGatewayRoute> {

    
     void addRoute2Redis(String key);

    
     void deleteById(String id);

    
    void updateAll(JSONObject array);

    
    void clearRedis();

}
