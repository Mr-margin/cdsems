package com.gistone.cdsems.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.service.impl.ICompanyService;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.Result;

/**
 * 一张图-初始化方法
 * @author qiang
 *
 */
@RestController
@RequestMapping("OneMapInitializationFun")
public class OneMapInitializationFun {

	@Autowired
	ICompanyService companyService; // 重点行业企业
	
	 /**
     * 
     * @param requestDate
     * @param request
     * @param response
     * @return
     * @Description 一张图-重点行业 (查询行业类别)
     */
    @RequestMapping(value="selectIndustryType",method=RequestMethod.POST)
    public Result selectIndustryType(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
        	List<Map> list = null ;
            list = companyService.selectIndustryType();
            return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图重点行业企业数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图重点行业企业数据统计异常");
        }

    } 
	
	
}
