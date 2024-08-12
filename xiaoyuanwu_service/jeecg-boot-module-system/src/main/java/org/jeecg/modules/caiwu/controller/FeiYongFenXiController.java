package org.jeecg.modules.caiwu.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.caiwu.entity.Amount;
import org.jeecg.modules.caiwu.service.IAmountService;
import org.jeecg.modules.system.entity.SysUser;
import org.jeecg.modules.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/4/25 20:31
 * @Description:
 */
@Api(tags = "报销")
@RestController
@RequestMapping("/caiwu/feiyongfenxi")
@Slf4j
public class FeiYongFenXiController {

    @Autowired
    private IAmountService amountService;

    @Autowired
    private ISysUserService userService;

    @GetMapping(value = "/find")
    public Result<?> find() {
        List<Amount> amountList = amountService.list();

        List<Map<String, String>> list = new ArrayList<>();
        List<List<Map<String, String>>> preList = new ArrayList<>();
//  AmountDto dto;
        Map<String, String> map = new HashMap<>();
        for (Amount temp : amountList) {
            list = new ArrayList<>();
            Double amount = Double.valueOf(temp.getAmount());
            Double shenyu = Double.valueOf(temp.getUseAmount());
            Double useAmount = amount - shenyu;
            String use = accuracy(Double.valueOf(useAmount), Double.valueOf(amount));
            double unUse = (100 - Double.valueOf(use));
            unUse = (double) Math.round(unUse * 100) / 100;
            map = new HashMap<>();
            map.put("item", "已用");
            map.put("count", String.valueOf(use));
            list.add(map);
            map = new HashMap<>();
            map.put("item", "未用");
            map.put("count", String.valueOf(unUse));
            list.add(map);
            preList.add(list);
        }
        return Result.OK(JSON.toJSON(preList));
    }


    public static String accuracy(double num, double total) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(1);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num / total * 100;
        return df.format(accuracy_num);
    }


    @GetMapping(value = "/update")
    public Result<?> update(HttpServletRequest request) {
        String realname = request.getParameter("realname");
        String avatar = request.getParameter("avatar");
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        String id = loginUser.getId();
        SysUser user = new SysUser();
        user.setId(id);
        user.setRealname(realname);
        user.setAvatar(avatar);
        userService.updateById(user);
        return Result.OK();
    }


}
