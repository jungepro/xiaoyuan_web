package org.jeecg.modules.caiwu.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: zichan
 * @Author: qjh
 * @Date:   2023-02-19
 * @Version: V1.0
 */
@Data
@TableName("zichan")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zichan对象", description="zichan")
public class Zichan implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**资产名称*/
	@Excel(name = "资产名称", width = 15)
    @ApiModelProperty(value = "资产名称")
    private String name;
	/**资产数量*/
	@Excel(name = "资产数量", width = 15)
    @ApiModelProperty(value = "资产数量")
    private String num;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String bz;
	/**资产类型*/
	@Excel(name = "资产类型", width = 15, dicCode = "zichantype")
	@Dict(dicCode = "zichantype")
    @ApiModelProperty(value = "资产类型")
    private String type;
}
