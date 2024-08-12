package org.jeecg.modules.caiwu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.caiwu.entity.Yuangong;
import org.jeecg.modules.caiwu.service.IYuangongService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: yuangong
 * @Author: qjh
 * @Date:   2023-02-19
 * @Version: V1.0
 */
@Api(tags="yuangong")
@RestController
@RequestMapping("/caiwu/yuangong")
@Slf4j
public class YuangongController extends JeecgController<Yuangong, IYuangongService> {
	@Autowired
	private IYuangongService yuangongService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yuangong
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "yuangong-分页列表查询")
	@ApiOperation(value="yuangong-分页列表查询", notes="yuangong-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(Yuangong yuangong,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Yuangong> queryWrapper = QueryGenerator.initQueryWrapper(yuangong, req.getParameterMap());
		Page<Yuangong> page = new Page<Yuangong>(pageNo, pageSize);
		IPage<Yuangong> pageList = yuangongService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yuangong
	 * @return
	 */
	@AutoLog(value = "yuangong-添加")
	@ApiOperation(value="yuangong-添加", notes="yuangong-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody Yuangong yuangong) {
		yuangongService.save(yuangong);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yuangong
	 * @return
	 */
	@AutoLog(value = "yuangong-编辑")
	@ApiOperation(value="yuangong-编辑", notes="yuangong-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody Yuangong yuangong) {
		yuangongService.updateById(yuangong);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "yuangong-通过id删除")
	@ApiOperation(value="yuangong-通过id删除", notes="yuangong-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		yuangongService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "yuangong-批量删除")
	@ApiOperation(value="yuangong-批量删除", notes="yuangong-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yuangongService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "yuangong-通过id查询")
	@ApiOperation(value="yuangong-通过id查询", notes="yuangong-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Yuangong yuangong = yuangongService.getById(id);
		if(yuangong==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yuangong);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yuangong
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yuangong yuangong) {
        return super.exportXls(request, yuangong, Yuangong.class, "yuangong");
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
        return super.importExcel(request, response, Yuangong.class);
    }

}
