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
import com.gistone.cdsems.database.entity.TYZCONS;
import com.gistone.cdsems.database.mapper.TAGRICUTURALSOILMapper;
import com.gistone.cdsems.database.mapper.TBASICSCONTAMINATEDMapper;
import com.gistone.cdsems.database.mapper.TBULIDINGLANDMapper;
import com.gistone.cdsems.database.mapper.TYZCONSMapper;
import com.gistone.cdsems.service.impl.ICompanyParkManagementService;
import com.gistone.cdsems.service.impl.ICompanyService;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.Result;

@RestController
@RequestMapping("OneMapContaminstedController")
public class OneMapContaminstedController {
    @Autowired
    private TBASICSCONTAMINATEDMapper tbasicscontaminatedMapper; // 污染地块
    @Autowired
	ICompanyService companyService; // 重点行业企业
    @Autowired
    private ICompanyParkManagementService CompanyParkManagementService;
    @Autowired
    private TAGRICUTURALSOILMapper tagricuturalsoilMapper; // 农用地
    @Autowired
    private TBULIDINGLANDMapper tbulidinglandMapper;  // 建设用地
    @Autowired
    private TYZCONSMapper tyzconsMapper;  // 建设用地
    
    /**
     * @author chendong
     * @date 2018-11-21 17:10
     * @param
     * @return
     * @Description 一张图-污染地块
     */
    @RequestMapping("selectOneMapContaminsted")
    public Result selectOneMapContaminsted(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String cityCode = data.getString("shi");//市
            String countyCode = data.getString("xian");//县
            String massifStage = data.getString("scjd");//所处阶段
            String riskLevel = data.getString("fxjb");//风险级别
            String massifName = data.getString("dkmc");//地块名称
            String fbt = data.getString("fbt");//地块名称
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
            List<Map> list = null ;
            
            if (fbt.equals("0")) { // 专题图
            	if ( !"".equals(countyCode)){//查询各县的详细数据
                    tbasicscontaminated.setCountyCode(countyCode);
                    list = tbasicscontaminatedMapper.selectByCounty(tbasicscontaminated);
                } else {//统计各个县的数据
                    tbasicscontaminated.setCityCode(cityCode);
                    list = tbasicscontaminatedMapper.selectByCity(tbasicscontaminated);
                }
            } else { // 分布图
            	if (!"".equals(countyCode)) { //查询各县的详细数据
            		tbasicscontaminated.setCountyCode(countyCode);
                    list = tbasicscontaminatedMapper.selectByCounty(tbasicscontaminated);
            	} else { // 查询全市数据
            		tbasicscontaminated.setCityCode(cityCode);
                    list = tbasicscontaminatedMapper.selectAllCity(tbasicscontaminated);
            	}
            }
            return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图污染地块数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图污染地块数据统计异常");
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
    @RequestMapping(value="selectOneMapKeyEnterprise",method=RequestMethod.POST)
    public Result selectOneMapKeyEnterprise(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
            JSONObject data = JSONObject.fromObject(requestDate.get("data"));
            String cityCode = data.getString("shi");//市
            String countyCode = data.getString("xian");//县
            String enterpriseName = data.getString("enterpriseName");//企业名称
            String industry = data.getString("industry");//行业
            String fbt = data.getString("fbt");// 是否是分布图
            Map<String, String> map = new HashMap<String, String>();
            
            if(!"".equals(enterpriseName)){
                map.put("company_name", enterpriseName);
            }
            if ( !"".equals(industry)){
                map.put("industry_type", industry);
            }
            List<Map> list = null ;
            
            if (fbt.equals("0")) { // 专题图
            	if ( !"".equals(countyCode)){//查询各县的详细数据
                    map.put("county_code", countyCode);
                    list = companyService.selectByCounty(map);
                } else {//统计各个县的数据
                    list = companyService.selectByCity(map);
                }
            } else { // 分布图
            	if (!"".equals(countyCode)) { //查询各县的详细数据
            		map.put("county_code", countyCode);
                    list = companyService.selectByCounty(map);
            	} else { // 查询全市数据
            		map.put("city_code", cityCode);
            		list = companyService.selectAllCity(map);
            	}
            }
            return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图重点行业企业数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图重点行业企业数据统计异常");
        }

    } 
    
    
    /**
     * 
     * @param requestDate
     * @param response
     * @param request
     * @return
     * Description 一张图-工业园区
     */
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//   	@RequestMapping("selectOneMapIndustrialPark")
//   public Result selectOneMapIndustrialPark(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
//       try {
//
//    	   JSONObject data = JSONObject.fromObject(requestDate.get("data"));
//           String cityCode = data.getString("shi");//市
//           String countyCode = data.getString("xian");//县
//           String parkName = data.getString("parkName");//工业园区名称
//           String contactName = data.getString("contactName");//联系人
//           String contactPhone = data.getString("contactPhone"); // 联系电话
//           String fbt = data.getString("fbt");// 是否是分布图
//           Map<String, String> map = new HashMap<String, String>();
//
//           if(!"".equals(parkName)){
//               map.put("parkName", parkName);
//           }
//           if ( !"".equals(contactName)){
//               map.put("contactName", contactName);
//           }
//           if ( !"".equals(contactPhone)){
//               map.put("contactPhone", contactPhone);
//           }
//           List<Map> list = null ;
//
//           if (fbt.equals("0")) { // 专题图
//	           if ( !"".equals(countyCode)){//查询各县的详细数据
//	                   map.put("countyCode", countyCode);
//	                   list = CompanyParkManagementService.selectByCounty(map);
//	               } else {//统计各个县的数据
//	                   list = CompanyParkManagementService.selectByCity(map);
//	               }
//	           } else { // 分布图
//	           	if (!"".equals(countyCode)) { //查询各县的详细数据
//	           		map.put("countyCode", countyCode);
//	                   list = CompanyParkManagementService.selectByCounty(map);
//	           	} else { // 查询全市数据
//	           		map.put("cityCode", cityCode);
//	           		list = CompanyParkManagementService.selectAllCity(map);
//	           	}
//           }
//           return Result.ok(list);
//       } catch (Exception e) {
//           LogUtil.getLogger().error("selectOneMapIndustrialPark 一张图工业园区数据统计异常",e);
//           return Result.build(1003, "selectOneMapIndustrialPark 一张图工业园区数据统计异常");
//       }
//   }
    
    
    /**
     * 
     * @param requestDate
     * @param request
     * @param response
     * @return
     * Description 一张图-农用地
     */
    @RequestMapping("selectOneMapAgriculturalLand")
    public Result selectOneMapAgriculturalLand(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
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
            List<Map> list = null ;
            
            if (fbt.equals("0")) { // 专题图
            	if ( !"".equals(countyCode)){//查询各县的详细数据
                    tAgricuturalSoil.setCountyCode(countyCode);
                    list = tagricuturalsoilMapper.selectByCounty(tAgricuturalSoil);
                } else {//统计各个县的数据
                    tAgricuturalSoil.setCityCode(cityCode);
                    list = tagricuturalsoilMapper.selectByCity(tAgricuturalSoil);
                }
            } else { // 分布图
            	if (!"".equals(countyCode)) { //查询各县的详细数据
            		tAgricuturalSoil.setCountyCode(countyCode);
                    list = tagricuturalsoilMapper.selectByCounty(tAgricuturalSoil);
            	} else { // 查询全市数据
            		tAgricuturalSoil.setCityCode(cityCode);
                    list = tagricuturalsoilMapper.selectAllCity(tAgricuturalSoil);
            	}
            }
            return Result.ok(list);
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
    @RequestMapping("selectOneMapLandForConstruction")
    public Result selectOneMapLandForConstruction(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
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
            List<Map> list = null ;
            
            if (fbt.equals("0")) { // 专题图
            	if ( !"".equals(countyCode)){//查询各县的详细数据
            		tbulidingland.setCountyCode(countyCode);
                    list = tbulidinglandMapper.selectByCounty(tbulidingland);
                } else {//统计各个县的数据
                	tbulidingland.setCityCode(cityCode);
                    list = tbulidinglandMapper.selectByCity(tbulidingland);
                }
            } else { // 分布图
            	if (!"".equals(countyCode)) { //查询各县的详细数据
            		tbulidingland.setCountyCode(countyCode);
                    list = tbulidinglandMapper.selectByCounty(tbulidingland);
            	} else { // 查询全市数据
            		tbulidingland.setCityCode(cityCode);
                    list = tbulidinglandMapper.selectAllCity(tbulidingland);
            	}
            }
            return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 一张图污染地块数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 一张图污染地块数据统计异常");
        }

    }
    
    /**
     * @param   
     * @return  
     * @Description 污染地块-建设项目环评分析
     */
    @RequestMapping("getJchpfx")
    public Result getJchpfx(@RequestBody Map<String,Object> requestDate, HttpServletRequest request,HttpServletResponse response) {
        try{
        	Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
        	System.out.print(data.get("xmin"));
             String xmin = data.get("xmin").toString();
             String xmax = data.get("xmax").toString();
             String ymin = data.get("ymin").toString();
             String ymax = data.get( "ymax").toString();
             String eiaManageName = data.get( "eiaManageName").toString();
             Map map = new HashMap();
             map.put("xmin", xmin);
             map.put("xmax", xmax);
             map.put("ymin",ymin);
             map.put("ymax", ymax);
             map.put("eiaManageName", eiaManageName);
             List<TYZCONS> list = tyzconsMapper.getJchpfx(map);
             return Result.ok(list);
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectOneMapContaminsted 建设项目环评数据统计异常",e);
            return Result.build(1002, "selectOneMapContaminsted 建设项目环评数据统计异常");
        }

    }

    
}
