package org.jeecg.modules.caiwu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.caiwu.entity.Amount;
import org.jeecg.modules.caiwu.service.IAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @Description: 费用管理
 * @Author: qjh
 * @Date: 2021-04-25
 * @Version: V1.0
 */
@Api(tags = "费用管理")
@RestController
@RequestMapping("/caiwu/amount")
@Slf4j
public class AmountController extends JeecgController<Amount, IAmountService> {
    @Autowired
    private IAmountService amountService;

    /**
     * 分页列表查询
     *
     * @param amount
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @AutoLog(value = "费用管理-分页列表查询")
    @ApiOperation(value = "费用管理-分页列表查询", notes = "费用管理-分页列表查询")
    @GetMapping(value = "/list")
    public Result<?> queryPageList(Amount amount,
                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {
        QueryWrapper<Amount> queryWrapper = QueryGenerator.initQueryWrapper(amount, req.getParameterMap());
        Page<Amount> page = new Page<Amount>(pageNo, pageSize);
        IPage<Amount> pageList = amountService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param amount
     * @return
     */
    @AutoLog(value = "费用管理-添加")
    @ApiOperation(value = "费用管理-添加", notes = "费用管理-添加")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody Amount amount) {
        amount.setUseAmount(amount.getAmount());
        amountService.save(amount);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param amount
     * @return
     */
    @AutoLog(value = "费用管理-编辑")
    @ApiOperation(value = "费用管理-编辑", notes = "费用管理-编辑")
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody Amount amount) {
        amount.setUseAmount(amount.getAmount());
        amountService.updateById(amount);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "费用管理-通过id删除")
    @ApiOperation(value = "费用管理-通过id删除", notes = "费用管理-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        amountService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "费用管理-批量删除")
    @ApiOperation(value = "费用管理-批量删除", notes = "费用管理-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.amountService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "费用管理-通过id查询")
    @ApiOperation(value = "费用管理-通过id查询", notes = "费用管理-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        Amount amount = amountService.getById(id);
        if (amount == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(amount);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param amount
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Amount amount) {
        return super.exportXls(request, amount, Amount.class, "费用管理");
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
        return super.importExcel(request, response, Amount.class);
    }

}
