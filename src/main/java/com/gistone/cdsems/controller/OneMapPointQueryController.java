package com.gistone.cdsems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TYZCONS;
import com.gistone.cdsems.database.mapper.TBASICSCONTAMINATEDMapper;
import com.gistone.cdsems.database.mapper.TYZCONSMapper;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.Result;
/**
 * 一张图点选查询
 * @author 
 *
 */
@RestController
@RequestMapping("OneMapPointQueryController")
public class OneMapPointQueryController {
	@Autowired
    private TBASICSCONTAMINATEDMapper tbasicscontaminatedMapper;
	@Autowired
    private TYZCONSMapper tyzconsMapper;  // 环评项目
	/**
	 * 
	 * @param requestDate
	 * @param request
	 * @param response
	 * @return
	 * @Description 一张图-通过污染地块编码查询数据
	 */
	@RequestMapping("selectByMassifCode")
    public Result selectByMassifCode(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String massifCode = data.getString("massifCode");//所处阶段
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            List<Map> list = null ;
            if(!"".equals(massifCode)){
                tbasicscontaminated.setMassifCode(massifCode);
                list = tbasicscontaminatedMapper.selectByMassifCode(tbasicscontaminated);
            }
            return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图污染地块点选查询异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图污染地块点选查询异常");
        }

    }
	
    /**
     * @param   
     * @return  
     * @Description 污染地块-建设项目环评分析
     */
    @RequestMapping("getJchpfxMessage")
    public Result getJchpfxMessage(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
        	Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
             String constructionId = data.get("constructionId").toString();
             TYZCONS tztcons = new TYZCONS();
             tztcons.setConstructionId(constructionId);
             List<TYZCONS> list = tyzconsMapper.getJchpfxMessage(tztcons);
             return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 建设项目环评数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 建设项目环评数据统计异常");
        }

    }
    /**
	 * 
	 * @param requestDate
	 * @param request
	 * @param response
	 * @return
	 * @Description 一张图-通过污染地块编码查询数据
	 */
	@RequestMapping("selectById")
    public Result selectById(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            Long cid =  Long.parseLong(data.getString("cid"));//所处阶段
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            List<Map> list = null ;
            if(!"".equals(cid)){
                tbasicscontaminated.setCid(cid);
                list = tbasicscontaminatedMapper.selectById(cid);
            }
            return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图污染地块点选查询异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图污染地块点选查询异常");
        }

    }
}
