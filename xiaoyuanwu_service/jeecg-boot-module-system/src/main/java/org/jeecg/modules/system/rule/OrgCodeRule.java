package org.jeecg.modules.system.rule;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.netty.util.internal.StringUtil;
import org.jeecg.common.handler.IFillRuleHandler;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.common.util.YouBianCodeUtil;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.service.ISysDepartService;

import java.util.ArrayList;
import java.util.List;


public class OrgCodeRule implements IFillRuleHandler {

    @Override
    public Object execute(JSONObject params, JSONObject formData) {
        ISysDepartService sysDepartService = (ISysDepartService) SpringContextUtils.getBean("sysDepartServiceImpl");

        LambdaQueryWrapper<SysDepart> query = new LambdaQueryWrapper<SysDepart>();
        LambdaQueryWrapper<SysDepart> query1 = new LambdaQueryWrapper<SysDepart>();

        List<SysDepart> departList = new ArrayList<>();
        String[] strArray = new String[2];

        String orgType = "";

        String newOrgCode = "";

        String oldOrgCode = "";

        String parentId = null;
        if (formData != null && formData.size() > 0) {
            Object obj = formData.get("parentId");
            if (obj != null) parentId = obj.toString();
        } else {
            if (params != null) {
                Object obj = params.get("parentId");
                if (obj != null) parentId = obj.toString();
            }
        }


        if (StringUtil.isNullOrEmpty(parentId)) {

            query1.eq(SysDepart::getParentId, "").or().isNull(SysDepart::getParentId);
            query1.orderByDesc(SysDepart::getOrgCode);
            departList = sysDepartService.list(query1);
            if (departList == null || departList.size() == 0) {
                strArray[0] = YouBianCodeUtil.getNextYouBianCode(null);
                strArray[1] = "1";
                return strArray;
            } else {
                SysDepart depart = departList.get(0);
                oldOrgCode = depart.getOrgCode();
                orgType = depart.getOrgType();
                newOrgCode = YouBianCodeUtil.getNextYouBianCode(oldOrgCode);
            }
        } else {

            query.eq(SysDepart::getParentId, parentId);

            query.orderByDesc(SysDepart::getOrgCode);

            List<SysDepart> parentList = sysDepartService.list(query);

            SysDepart depart = sysDepartService.getById(parentId);

            String parentCode = depart.getOrgCode();

            orgType = String.valueOf(Integer.valueOf(depart.getOrgType()) + 1);

            if (parentList == null || parentList.size() == 0) {

                newOrgCode = YouBianCodeUtil.getSubYouBianCode(parentCode, null);
            } else {

                String subCode = parentList.get(0).getOrgCode();

                newOrgCode = YouBianCodeUtil.getSubYouBianCode(parentCode, subCode);
            }
        }

        strArray[0] = newOrgCode;
        strArray[1] = orgType;
        return strArray;
    }
}
