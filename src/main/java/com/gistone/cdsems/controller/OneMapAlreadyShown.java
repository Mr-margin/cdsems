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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.database.mapper.TAGRICUTURALSOILMapper;
import com.gistone.cdsems.database.mapper.TBASICSCONTAMINATEDMapper;
import com.gistone.cdsems.database.mapper.TBULIDINGLANDMapper;
import com.gistone.cdsems.service.impl.ICompanyService;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.Result;
/**
 * 
 * 一张图 - 已上图
 *
 */
@RestController
@RequestMapping("OneMapAlreadyShown")
public class OneMapAlreadyShown {
	@Autowired
    private TBASICSCONTAMINATEDMapper tbasicscontaminatedMapper; // 污染地块
	@Autowired
	ICompanyService companyService; // 重点行业企业
	@Autowired
    private TAGRICUTURALSOILMapper tagricuturalsoilMapper; // 农用地
	@Autowired
    private TBULIDINGLANDMapper tbulidinglandMapper;  // 建设用地
	@RequestMapping("pollutedLandShown")
    public Result selectOneMapContaminsted(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String cityCode = data.getString("shi");//市
            String countyCode = data.getString("xian");//县
            String massifStage = data.getString("scjd");//所处阶段
            String riskLevel = data.getString("fxjb");//风险级别
            String massifName = data.getString("dkmc");//地块名称
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            if(!"".equals(massifName)){
                tbasicscontaminated.setMassifName(massifName);
            }
            if ( !"".equals(massifStage)){
                tbasicscontaminated.setMassifStage(massifStage);
            }
            if( !"".equals(riskLevel)){
                tbasicscontaminated.setRiskLevel(riskLevel);
            }
            
            if ( !"".equals(countyCode)){//查询各县的详细数据
                tbasicscontaminated.setCountyCode(countyCode);
            }    
            List list = null ;
            Map resultMap = new HashMap();
            // 1.已上图 alreadyShown     2.最近30天 confirmedInThelastThirtyDays
            int yst = tbasicscontaminatedMapper.alreadyShown(tbasicscontaminated);
            int nearlyMonth = tbasicscontaminatedMapper.confirmedInThelastThirtyDays(tbasicscontaminated);
            resultMap.put("yst", yst);
            resultMap.put("nearlyMonth", nearlyMonth);
            return Result.ok(resultMap);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图污染地块最近30天统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图污染地块数据最近30天统计异常");
        }

    }
	
	
	/**
     * 
     * @param requestDate
     * @param request
     * @param response
     * @return
     * @Description 一张图-重点行业
     */
    @RequestMapping(value="keyEnterpriseShown",method=RequestMethod.POST)
    public Result keyEnterpriseShown(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String cityCode = data.getString("shi");//市
            String countyCode = data.getString("xian");//县
            String enterpriseName = data.getString("enterpriseName");//企业名称
            String industry = data.getString("industry");//行业
            Map<String, String> map = new HashMap<String, String>();
            if(!"".equals(enterpriseName)){
                map.put("company_name", enterpriseName);
            }
            if ( !"".equals(industry)){
                map.put("industry_type", industry);
            }
            if ( !"".equals(countyCode)){//查询各县的详细数据
                map.put("county_code", countyCode);
            }
            Map resultMap  = new HashMap(); ;
            int yst = companyService.alreadyShown(map);
            resultMap.put("yst", yst);
            return Result.ok(resultMap);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图重点行业企业数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图重点行业企业数据统计异常");
        }

    } 
    
    /**
     * 
     * @param requestDate
     * @param request
     * @param response
     * @return
     * Description 一张图-农用地
     */
    @RequestMapping("agriculturalLandShown")
    public Result agriculturalLandShown(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String cityCode = data.getString("shi");//市
            String countyCode = data.getString("xian");//县
            String agricuturalName = data.getString("agricuturalName");//农用地名称
            String agricuturalCode = data.getString("agricuturalCode");//农用地编码
            String agricuturalType = data.getString("agricuturalType");//土地利用类型
            String fbt = data.getString("fbt");//地块名称
            TAGRICUTURALSOIL tAgricuturalSoil = new TAGRICUTURALSOIL();
            if(!"".equals(agricuturalName)){
            	tAgricuturalSoil.setAgricuturalName(agricuturalName);
            }
            if ( !"".equals(agricuturalCode)){
            	tAgricuturalSoil.setAgricuturalCode(agricuturalCode);
            }
            if( !"".equals(agricuturalType)){
            	tAgricuturalSoil.setAgricuturalType(agricuturalType);
            }
            if ( !"".equals(countyCode)){//查询各县的详细数据
                tAgricuturalSoil.setCountyCode(countyCode);
            }
            Map resultMap = new HashMap();
            int yst = tagricuturalsoilMapper.alreadyShown(tAgricuturalSoil);
            resultMap.put("yst", yst);
            return Result.ok(resultMap);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图农用地数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图农用地数据统计异常");
        }

    }
    /**
     * 
     * @param requestDate
     * @param request
     * @param response
     * @return
     * @Description 一张图-建设用地准入
     */
    @RequestMapping("landForConstructionShown")
    public Result landForConstructionShown(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String cityCode = data.getString("shi");//市
            String countyCode = data.getString("xian");//县
            String riskLevel = data.getString("fxjb");//风险级别
            String massifName = data.getString("dkmc");//地块名称
            String fbt = data.getString("fbt");//地块名称
            TBULIDINGLAND tbulidingland = new TBULIDINGLAND();
            if(!"".equals(massifName)){
            	tbulidingland.setMassifName(massifName);
            }
            if( !"".equals(riskLevel)){
            	tbulidingland.setRiskLevel(riskLevel);
            }
            if ( !"".equals(countyCode)){//查询各县的详细数据
        		tbulidingland.setCountyCode(countyCode);
            } 
            Map resultMap = new HashMap();
            int yst = tbulidinglandMapper.alreadyShown(tbulidingland);
            resultMap.put("yst", yst);
            return Result.ok(resultMap);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图污染地块数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图污染地块数据统计异常");
        }

    }
	
}
