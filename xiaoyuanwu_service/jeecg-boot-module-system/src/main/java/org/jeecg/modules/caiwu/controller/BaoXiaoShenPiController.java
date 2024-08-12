package org.jeecg.modules.caiwu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.caiwu.entity.Amount;
import org.jeecg.modules.caiwu.entity.BaoXiao;
import org.jeecg.modules.caiwu.service.IAmountService;
import org.jeecg.modules.caiwu.service.IBaoXiaoService;
import org.jeecg.modules.system.entity.SysUserRole;
import org.jeecg.modules.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @Description: 报销
 * @Author: qjh
 * @Date: 2021-04-25
 * @Version: V1.0
 */
@Api(tags = "报销")
@RestController
@RequestMapping("/caiwu/baoxiaoshenpi")
@Slf4j
public class BaoXiaoShenPiController extends JeecgController<BaoXiao, IBaoXiaoService> {
    @Autowired
    private IBaoXiaoService baoXiaoService;
    @Autowired
    private IAmountService amountService;
    @Autowired
    private ISysUserRoleService userRoleService;

    /**
     * 分页列表查询
     *
     * @param baoXiao
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @AutoLog(value = "报销-分页列表查询")
    @ApiOperation(value = "报销-分页列表查询", notes = "报销-分页列表查询")
    @GetMapping(value = "/list")
    public Result<?> queryPageList(BaoXiao baoXiao,
                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {

        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<SysUserRole> query = new LambdaQueryWrapper<>();
        query.eq(SysUserRole::getUserId, loginUser.getId());
        query.eq(SysUserRole::getRoleId, "1387391753386835970");
        SysUserRole one = userRoleService.getOne(query);


        QueryWrapper<BaoXiao> queryWrapper = QueryGenerator.initQueryWrapper(baoXiao, req.getParameterMap());
        if (null != one) {
            //会计
            queryWrapper.le("baoxiao_money", 2000);
        }
        Page<BaoXiao> page = new Page<BaoXiao>(pageNo, pageSize);
        IPage<BaoXiao> pageList = baoXiaoService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param baoXiao
     * @return
     */
    @AutoLog(value = "报销-添加")
    @ApiOperation(value = "报销-添加", notes = "报销-添加")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody BaoXiao baoXiao) {
        baoXiaoService.save(baoXiao);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param baoXiao
     * @return
     */
    @AutoLog(value = "报销-编辑")
    @ApiOperation(value = "报销-编辑", notes = "报销-编辑")
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody BaoXiao baoXiao) {

        Integer status = baoXiao.getStatus();
        if ("1".equals(status.toString())) {
            //报销通过
            QueryWrapper<Amount> query = new QueryWrapper<>();
            query.eq("baoxiao_type", baoXiao.getBaoxiaoType());
            Amount amount = amountService.getOne(query);
            if (Double.valueOf(baoXiao.getBaoxiaoMoney()) >= Double.valueOf(amount.getUseAmount())) {
                return Result.error("超过报销金额，无法报销!");
            } else {
                QueryWrapper<Amount> query1 = new QueryWrapper<>();
                query1.eq("baoxiao_type", baoXiao.getBaoxiaoType());
                Double shenyu = Double.valueOf(amount.getUseAmount()) - Double.valueOf(baoXiao.getBaoxiaoMoney());
                amount.setUseAmount(shenyu.toString());
                amountService.update(amount, query1);
                LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
                baoXiao.setShenheId(loginUser.getId());
                baoXiao.setShenheName(loginUser.getRealname());
                baoXiaoService.updateById(baoXiao);
                return Result.OK("审批成功!");
            }
        } else {
            LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
            baoXiao.setShenheId(loginUser.getId());
            baoXiao.setShenheName(loginUser.getRealname());
            baoXiaoService.updateById(baoXiao);
            return Result.OK("审批成功!");
        }


    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "报销-通过id删除")
    @ApiOperation(value = "报销-通过id删除", notes = "报销-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        baoXiaoService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "报销-批量删除")
    @ApiOperation(value = "报销-批量删除", notes = "报销-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.baoXiaoService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "报销-通过id查询")
    @ApiOperation(value = "报销-通过id查询", notes = "报销-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        BaoXiao baoXiao = baoXiaoService.getById(id);
        if (baoXiao == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(baoXiao);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param baoXiao
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BaoXiao baoXiao) {
        return super.exportXls(request, baoXiao, BaoXiao.class, "报销");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BaoXiao.class);
    }

}
