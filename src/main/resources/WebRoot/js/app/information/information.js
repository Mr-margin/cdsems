var tuceng = [{ name: "省级行政界线", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/provincemap/MapServer", id: "shengJie" },
{ name: "市级行政界线", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/citymap/MapServer", id: "shiJie" }, { name: "县级行政界线", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/countymap/MapServer", id: "xianJie" },
{ name: "地名数据", url: "" }, { name: "地形地貌", url: "" }, { name: "卫星影像", url: "http://t0.tianditu.com/img_c/wmts" },
{ name: "河流", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/river/MapServer", id: "heliu" }, { name: "湖泊", url: "" },
{ name: "道路", url: ["http://" + ip + ":6080/arcgis/rest/services/seimp/高速/MapServer", "http://" + ip + ":6080/arcgis/rest/services/seimp/省道/MapServer"], id: ["gaosu", "shengdao"] },
{ name: "京津冀", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/京津冀/MapServer", id: "jingjinji" },
{ name: "长三角", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/长三角/MapServer", id: "changsanjiao" },
{ name: "珠三角", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/珠三角/MapServer", id: "zhusanjiao" }, { name: "六大综合防治先行区", url: "" }, { name: "土壤污染治理与修复试点", url: "" }, { name: "重点地区-其他", url: "" }, { name: "第二次全国土地调查数据", url: "" },
{ name: "土地利用", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/landuse/MapServer", id: "tudiliyong" },
{ name: "土壤类型", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/soiltype/MapServer", id: "turangleixing" }, { name: "土壤PH值", url: "" }, { name: "有机质", url: "" }, { name: "地质类型", url: "" }, { name: "矿带分布", url: "" }, { name: "作物类型", url: "" },
{ name: "作物分布", url: "" }, { name: "降雨数据", url: "" }, { name: "温度数据", url: "" }, { name: "大型灌区分布", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/灌区/MapServer", id: "guanqu" }, { name: "“七五”背景调查", url: "" }, { name: "多目标区域地球化学调查", url: "" },
{ name: "农产品产地土壤重金属污染调查", url: "" }, { name: "环境重金属污染健康监测数据", url: "" }, { name: "汞污染排放调查", url: "" }, { name: "全国土壤污染状况调查", url: "" },
{ name: "全国土壤污染状况详查（2017年-2020年）", url: "" }, { name: "自行监测", url: "" }, { name: "例行监测", url: "" }, { name: "农产品质量检测", url: "" }, { name: "农产品临田检测", url: "" },
{ name: "严格管控类", url: "" }, { name: "优先保护类", url: "" }, { name: "安全利用类", url: "" }, { name: "污染地块", url: "" }, { name: "疑似污染地块", url: "" }, { name: "未利用地", url: "" }, { name: "突发环境事件监管", url: "" },
{ name: "有色金属矿采选", url: "" }, { name: "石油开采", url: "" }, { name: "有色金属冶炼", url: "" }, { name: "石油加工", url: "" }, { name: "化工", url: "" }, { name: "焦化", url: "" }, { name: "电镀", url: "" },
{ name: "制革", url: "" }, { name: "畜禽", url: "" }, { name: "农药", url: "" }, { name: "化肥", url: "" }, { name: "废弃农膜", url: "" }, { name: "灌溉水", url: "" }, { name: "生活垃圾污染", url: "" }, { name: "垃圾填埋场", url: "" },
{ name: "危险废物集中处置", url: "" }, { name: "修复治理技术", url: "" }, { name: "修复治理项目", url: "" }, { name: "土地利用总体规划", url: "" }, { name: "城市总体规划", url: "" }, { name: "控制性详细规划", url: "" },
{ name: "建设工程施工许可", url: "" }, { name: "农村饮用水工程", url: "" }, { name: "工业园区", url: "" }, { name: "网络舆情", url: "" }, { name: "举报投诉", url: "" }, { name: "文献资料", url: "" },
{ name: "人口分布", url: "http://" + ip + ":6080/arcgis/rest/services/seimp/population/MapServer", id: "renkou" }];

$(function () {
    $("#wrdk_bar").height($(".info-right").height() * 0.7)
    //主菜单切换
    $(".left-nav>li").click(function () {
        $(this).addClass("info-li-active").siblings(".left-nav>li").removeClass("info-li-active");
        $(".left-menu .menu-list").eq($(this).index()).show().siblings(".left-menu .menu-list").hide();
        var index = $(this).index();
        if (index == 0) { // 图层控制
            $('.menuType').show();
        } else if (index == 1) { // 图层控制
            $('.menuType').hide();
            $(".tool_hover").html(tckzHtml);
            huaDiv();
        } else if (index == 2) { // 图例
            $('.menuType').hide();
        }
    })
    //侧边栏二级菜单
    $(".menuList>li>a").click(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active").next(".sub_menu").slideUp(100);
            $(this).children(".iconfont").css("transform", "rotateZ(0deg)");
        } else {
            if ($(this).siblings().size() != 0) {
                $(this).addClass("active").next(".sub_menu").slideDown(100);
                $(this).children(".iconfont").css("transform", "rotateZ(90deg)");
            }
        }
    })
    //专题图/分布图 切换
    $(".menuType>div>label").click(function () {
        $(this).addClass("menuType-active").parent().siblings(".menuType>div").children(".menuType>div>label").removeClass("menuType-active");

    })
    $('input[type=radio][name=menuType]').change(function () {
        dong.ztorfb = $(this).val();
        switchInThematicMapAndDistributeMap();
    });
    //地图堆叠效果
    $('ul.cards').mouseenter(function () {
        $(this).toggleClass('transition');

    }).mouseleave(function () {
        $(this).toggleClass('transition');
    });
    //地图类型切换
    var Zindex = 20;
    $('.yx-box li').click(function () {
        $(this).addClass("yx_active").siblings(".yx-box li").removeClass("yx_active");
        if ($(this).index() == 2) {//天地图矢量   		
            tianShi();
        } else if ($(this).index() == 1) {//天地图影像
            tianYing();
        } else if ($(this).index() == 0) {//谷歌影像
            googleYing();
        }
        $(this).css("zIndex", Zindex)
        Zindex++;
    })
    //工具栏hover
    $('.tool-box>li').hover(function () {
        $(this).toggleClass("tool_active")
    })
    $(".info_modal .close").click(function () {
        $("#myModal").hide();
    });
    $(".info_modal .btn-default").click(function () {
        $("#myModal").hide();
    });
    //关闭统计表1
    $("#info_table1  .switch").click(function () {
        $("#info_table1").hide();
        if ($("#info_table1 span").text().indexOf("敏感点分布") != -1 || $("#info_table1 span").text().indexOf("环评项目分布") != -1 ) {//附近易受影响分析
            removeTc("countryGraphicsLayer1");
            removeTc("countryGraphicsLayer2")
        }
        removeTc("wrdkcentral")
    })
    getIndustryTypeOfkeyEnterprise(); // 获取重点行业行业类别下拉列表
    getTbCiyt(); // 	获取市下拉列表
    // 获取左侧目录
    getLiftMenu();
})
/////////////////////////////////////////////////////地图/////////////////////////////////////////////////////////////////////////
var app = {};
var dong = {};
var thematicMapBar; // 专题图状图
dong.basicGeographyAndOthersClickRecord = 0; // 记录基础地理和其他的点击情况
var user = JSON.parse(sessionStorage.user);
var returnTocity = "<img src='../../img/information/backToPre.png' onclick = 'fanhuiShi()' style='position: relative;left: 93px;;cursor:pointer' title='返回上一级'/>";;
$(function () {
    require(["esri/map", "esri/SpatialReference", "esri/geometry/Extent", "esri/dijit/InfoWindowLite",
        "esri/tasks/QueryTask", "esri/tasks/query", "esri/graphic", "esri/geometry/Polyline", "esri/symbols/SimpleLineSymbol", "esri/Color",
        "esri/layers/WMTSLayer", "esri/layers/WMTSLayerInfo", "esri/layers/TileInfo", "dojo/dom-construct", "esri/tasks/LengthsParameters",
        "esri/tasks/AreasAndLengthsParameters", "esri/tasks/GeometryService", "esri/toolbars/draw", "esri/geometry/Point",
        "esri/tasks/PrintTask", "esri/tasks/PrintTemplate", "esri/tasks/PrintParameters", "esri/layers/FeatureLayer",
        "esri/symbols/SimpleFillSymbol", "dojo/dom", "esri/layers/GraphicsLayer", "esri/symbols/SimpleMarkerSymbol", "esri/symbols/Font",
        "esri/symbols/TextSymbol", "esri/geometry/Polygon", "extras/TianDiTuLayer", "esri/layers/LabelClass", "esri/renderers/SimpleRenderer",
        "esri/symbols/PictureMarkerSymbol", "extras/DEBubblePopup", "esri/geometry/Circle", "esri/geometry/webMercatorUtils", "esri/layers/ArcGISDynamicMapServiceLayer",
        "esri/tasks/IdentifyTask", "esri/tasks/IdentifyParameters", "esri/symbols/Font", "esri/dijit/Scalebar", "esri/InfoTemplate", "dojo/domReady!"
    ], function (Map, SpatialReference, Extent, InfoWindowLite,
        QueryTask, Query, Graphic, Polyline, SimpleLineSymbol, Color,
        WMTSLayer, WMTSLayerInfo, TileInfo, domConstruct, LengthsParameters, AreasAndLengthsParameters, GeometryService, Draw, Point,
        PrintTask, PrintTemplate, PrintParameters, FeatureLayer, SimpleFillSymbol, dom, GraphicsLayer, SimpleMarkerSymbol, Font, TextSymbol, Polygon,
        TianDiTuLayer, LabelClass, SimpleRenderer, PictureMarkerSymbol, DEBubblePopup, Circle, webMercatorUtils, ArcGISDynamicMapServiceLayer, IdentifyTask,
        IdentifyParameters, Font, Scalebar, InfoTemplate
    ) {
            dong.SpatialReference = SpatialReference;
            dong.Extent = Extent;
            dong.InfoWindowLite = InfoWindowLite;
            dong.QueryTask = QueryTask;
            dong.Query = Query;
            dong.Graphic = Graphic;
            dong.Polyline = Polyline;
            dong.SimpleLineSymbol = SimpleLineSymbol;
            dong.Color = Color;
            dong.WMTSLayer = WMTSLayer;
            dong.WMTSLayerInfo = WMTSLayerInfo;
            dong.TileInfo = TileInfo;
            dong.domConstruct = domConstruct;
            dong.LengthsParameters = LengthsParameters;
            dong.AreasAndLengthsParameters = AreasAndLengthsParameters;
            dong.GeometryService = GeometryService;
            dong.Draw = Draw;
            dong.Point = Point;
            dong.PrintTask = PrintTask;
            dong.PrintTemplate = PrintTemplate;
            dong.PrintParameters = PrintParameters;
            dong.FeatureLayer = FeatureLayer;
            dong.SimpleFillSymbol = SimpleFillSymbol;
            dong.dom = dom;
            dong.GraphicsLayer = GraphicsLayer;
            dong.SimpleMarkerSymbol = SimpleMarkerSymbol;
            dong.Font = Font;
            dong.TextSymbol = TextSymbol;
            dong.Polygon = Polygon;
            dong.TianDiTuLayer = TianDiTuLayer;
            dong.LabelClass = LabelClass;
            dong.SimpleRenderer = SimpleRenderer;
            dong.PictureMarkerSymbol = PictureMarkerSymbol;
            dong.DEBubblePopup = DEBubblePopup;
            dong.Circle = Circle;
            dong.webMercatorUtils = webMercatorUtils;
            dong.ArcGISDynamicMapServiceLayer = ArcGISDynamicMapServiceLayer;
            dong.IdentifyTask = IdentifyTask;
            dong.IdentifyParameters = IdentifyParameters;
            dong.Font = Font;
            dong.Scalebar = Scalebar;
            dong.InfoTemplate = InfoTemplate;

            dong.measure = false;

            var extentPar = {
                "xmin": 65.765135846784, "ymin": 13.1245384992698, "xmax": 150.23486415321602, "ymax": 54.8754615007302,
                "spatialReference": { "wkid": 4326 }
            }
            extent = new Extent(extentPar);
            var infoWindow = new dong.DEBubblePopup();
            //初始化地图
            app.map = new Map("map", {
                logo: false,
                minZoom: 2,
                extent: extent,
                showLabels: true,
                sliderPosition: "top-left",
                infoWindow: infoWindow
            })
            toolbar = new esri.toolbars.Draw(app.map);
            dojo.connect(toolbar, "onDrawEnd", doMeasure);

            app.geometryService = new dong.GeometryService("http://" + ip + ":6080/arcgis/rest/services/Utilities/Geometry/GeometryServer");
            app.baseLayer = new TianDiTuLayer(TianDiTuLayer.VEC_BASE_WEBMERCATOR, { id: "vectorLayer" });//矢量
            app.annoLayer = new TianDiTuLayer(TianDiTuLayer.VEC_ANNO_WEBMERCATOR, { id: "vectorNoteLayer" });//注记
            app.map.addLayer(app.baseLayer);
            app.map.addLayer(app.annoLayer);
            /*var eraseLayer = new dong.ArcGISDynamicMapServiceLayer("http://"+"182.150.31.88"+":20018/arcgis/rest/services/v/MapServer",{
                   "id": "m_dl_map_cover",
                  "showAttribution": false,
                  "spatialReference":{"wkid": 4490 }
                // "opacity": 0.5, 
             });
           app.map.addLayer(eraseLayer);*/
            var scalebar = new dong.Scalebar({
                map: app.map, // 必须的
                scalebarUnit: "metric"  // 指定比例尺单位,有效值是"english" or "metric".默认"english"
            }, dong.dom.byId("scalebar"));
            app.map.on("mouse-move", function (e) {
                var normalizedVal = dong.webMercatorUtils.xyToLngLat(e.mapPoint.x, e.mapPoint.y)
                $(".jwd").html(normalizedVal[0].toFixed(6) + "," + normalizedVal[1].toFixed(6))
            });
            $(".esriScalebarRulerBlock").css("background", "white");//比例尺中的背景色
            $(".scaleLabelDiv").css("margin-top", "5px");//比例尺距离文字
            var mapPoint = new dong.Point({ "x": 104.04, "y": 30.77, "spatialReference": { "wkid": 4326 } });
            app.map.centerAndZoom(mapPoint, 9);
            $('.tool-jl').click(function () {
                dong.measure = true;
                isAttributeSearch = false; // 属性查询
                toolbar.activate(esri.toolbars.Draw.POLYLINE);
            });
            $('.tool-mj').click(function () { // tool-mj
                dong.measure = true;
                isAttributeSearch = false; // 属性查询
                toolbar.activate(esri.toolbars.Draw.POLYGON)
            });
            $('.tool-qt').click(function () { // 全图
                isAttributeSearch = false;
                if (user.suLevel == "3") { // 县级用户
                    queryPosition(dong.xianCode);
                } else {
                    queryPosition("");
                }
            });
            $('.tool-qc').click(function () { // 
                dong.measure = false; // 设置测量按钮状态为false
                if (app.map.graphics != null && app.map.graphics != null && app.map.graphics != undefined) {
                    app.map.graphics.clear();
                }
                removeFujin();
                removeTc("wrdkcentral");
                if (user.suLevel == "3") { // 县级用户
                    queryPosition(dong.xianCode);
                } else {
                    queryPosition("");
                }
            });
            $('.tool-idQuery').click(function () { // 
                isAttributeSearch = true; // 属性查询
                startAttributeSearch();
            });
            $('.conditionQuery').click(function () { // 条件查询
            	if (dong.ztorfb == "专题图") {
            		conditionQuery();
            	} else {
            		distributeMapQuery();
            	}
                
            });
            $('.tool-bg').click(function () { // 
                $("#tongjituDiv").show();
                $(this).addClass("repres_active").siblings(".map_representation>li").removeClass("repres_active")
            });
            //基础地理复选框的选择
            $('.basicDl input:checkbox').click(function () {
                tuliDiv(this.checked, $(this).context.getAttribute("data"))
                if (this.checked) {
                    tjTc($(this).context.getAttribute("data"), 0)//num ： 0 添加 1移除
                    dong.basicGeographyAndOthersClickRecord++;
                } else {
                    tjTc($(this).context.getAttribute("data"), 1)//num ： 0 添加 1移除
                    dong.basicGeographyAndOthersClickRecord--;
                }
            })
            if (user.suLevel == "3") { // 县级用户
                dong.xianCode = user.suRegioncode;
                queryPosition(user.suRegioncode);
                $("#county").val(user.suRegioncode);
                $('#county').attr("disabled", true);
                dong.xianName = $("#county option:selected").text();
            } else {
                queryPosition("");
            }
            toolTableFuntion(); // 工具条表格放大关闭事件
        })
})

/**
 * 条件查询
 */
function conditionQuery() {
    // 获取查询条件
    var queryJson = getQueryCondition();
    //查询定位
    queryPosition(queryJson.xian);
    // 获取查询图层
    getQueryLayer();
    // 图层加载完毕后加载数据 
    updateEndLayer(queryJson);
}
/**
 * 图层加载完毕添加数据
 * @param queryJson
 */
function updateEndLayer(queryJson) {
    if (dong.tucengType == "shi") {
        app.xian.on("update-end", function (e) {
            moduleQuery(queryJson);
        });
    } else if (dong.tucengType == "xian") { // 县下一级
        // 县下一级
        moduleQuery(queryJson);
    }
}
/**
 * 模块查询
 * @param queryJson
 */
function moduleQuery(queryJson) {
    // 清空计数图层
    removeTc("countLayer");
    // 清空点图层
    removeTc("diangraphicsLayer");

    if (dong.num == "1") {
        pollutedLandQuery(queryJson);
    } else if (dong.num == "8") {
        keyEnterpriseQuery(queryJson);
    } else if (dong.num == "13") {
        industrialParkQuery(queryJson);
    } else if (dong.num == "12") {
        agriculturalLandQuery(queryJson);
    } else if (dong.num == "14") { // 建设用地准入
        landForConstructionQuery(queryJson);
    }
}
/**
 * 污染地块查询
 * @param queryJson 
 */
function pollutedLandQuery(queryJson) {
    ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapContaminsted", queryJson).done(function (result) {
        if (queryJson.xian) { // 展示县详情数据
            countyDetailsOfPollutedLand(result.data);
            // 展示工具条中表格数据
        } else { // 县计数数据
            countyCount(result.data); // 
            // 县数据处理
            $(".wrdk_barTip").empty();
            $(".wrdk_barTip").append("<p>污染地块数量排名</p>");
            // 市数据描述
            showIntroduction(sumCountData(result.data));
            countyCountDataProcessing(result.data, "个"); // 数据处理
            // 展示工具条中表格数据
            var url = getPointPNG();
            // 表格显示
            toolbarForm(result.data, "", url);

        }
    })
}
/**
 * 重点行业企业查询
 * @param queryJson
 */
function keyEnterpriseQuery(queryJson) {
    ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapKeyEnterprise", queryJson).done(function (result) {
        if (queryJson.xian) { // 展示县详情数据
            countyDetailsOfKeyEnterprise(result.data);
        } else { // 县计数数据
            countyCount(result.data); // 
            // 县数据处理
            $(".wrdk_barTip").empty();
            $(".wrdk_barTip").append("<p>重点行业企业数量排名</p>");
            // 市数据描述
            showIntroduction(sumCountData(result.data));

            countyCountDataProcessing(result.data, "块"); // 数据处理

            // 展示工具条中表格数据
            var url = getPointPNG();;
            // 表格显示
            toolbarForm(result.data, "zhongdian", url);
        }
    })
}
/**
 * 工业园区条件查询
 * @param queryJson
 */
function industrialParkQuery(queryJson) {
    ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapIndustrialPark", queryJson).done(function (result) {
        if (queryJson.xian) { // 展示县详情数据
            countyDetailsOfKeyEnterprise(result.data);
        } else { // 县计数数据
            countyCount(result.data); // 
            // 县数据处理
            $(".wrdk_barTip").empty();
            $(".wrdk_barTip").append("<p>工业园区数量排名</p>");
            // 市数据描述
            showIntroduction(sumCountData(result.data));

            countyCountDataProcessing(result.data, "个"); // 数据处理
            // 展示工具条中表格数据
            var url = getPointPNG();
            // 表格显示
            toolbarForm(result.data, "gongyeyuanqu", url);
        }
    })
}
/**
 * 农用地条件查询
 * @param queryJson
 */
function agriculturalLandQuery(queryJson) {
    ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapAgriculturalLand", queryJson).done(function (result) {
        if (queryJson.xian) { // 展示县详情数据
            countyDetailsOfAgriculturalLand(result.data);
        } else { // 县计数数据
            countyCount(result.data); // 
            // 县数据处理
            $(".wrdk_barTip").empty();
            $(".wrdk_barTip").append("<p>农用地数量排名</p>");
            // 市数据描述
            showIntroduction(sumCountData(result.data));
            countyCountDataProcessing(result.data, "块"); // 数据处理
            // 展示工具条中表格数据
            var url = getPointPNG();
            // 表格显示
            toolbarForm(result.data, "nongyongdi", url);
        }
    })
}
/**
 * 建设用地条件查询
 * @param queryJson
 */
function landForConstructionQuery(queryJson) {
    ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapLandForConstruction", queryJson).done(function (result) {
        if (queryJson.xian) { // 展示县详情数据
            countyDetailsOfConstructionLand(result.data);
            // 展示工具条中表格数据

        } else { // 县计数数据
            countyCount(result.data); // 
            // 县数据处理
            $(".wrdk_barTip").empty();
            $(".wrdk_barTip").append("<p>建设用地准入数量排名</p>");
            // 市数据描述
            showIntroduction(sumCountData(result.data));

            countyCountDataProcessing(result.data, "个"); // 数据处理

            // 展示工具条中表格数据
            var url = getPointPNG();
            // 表格显示
            toolbarForm(result.data, "jiansheCount", url);

        }
    })
}
/**
 * 计算数据总量
 * @param data
 * @returns {Number}
 */
function sumCountData(data) {
    var sumCount = 0;
    if (data) {
        for (var i = 0; i < data.length; i++) {
            sumCount += data[i].COUNT;
        }
    }
    return sumCount;
}
/**
 * 污染地块文字简介
 * @param isProvinceOrCity 是否是省或者市
 * @param totalNumPloat 总数
 * @param showNum 已上图
 * @param nameNumOne 数量第一
 * @param numLaterMonth 最近一月
 */
function showIntroduction(totalNumPloat, showNum, nameNumOne, numLaterMonth) {
    $("#wrdk_detail").html("");
    var detail = "";
    var queryJson = getQueryCondition();
    if (dong.num == "1") {
        ajaxPost("/cdsems/OneMapAlreadyShown/pollutedLandShown", queryJson).done(function (result) {
            if (result.status == 0) {
                detail = "根据上报地块数据确认<strong>成都市</strong>污染地块共计<strong>" + totalNumPloat + "</strong>块，已上图<strong>" + result.data.yst +
                    "</strong>块，其中最近 30 天内确认污染地块数据为<strong>" + result.data.nearlyMonth + "块。</strong>";
                $("#wrdk_detail").html(detail);
            }
        });
    } else if (dong.num == "8") {
        ajaxPost("/cdsems/OneMapAlreadyShown/keyEnterpriseShown", queryJson).done(function (result) {
            if (result.status == 0) {
                detail = "根据上报数据确认<strong>成都市</strong>重点行业企业共计<strong>" + totalNumPloat + "</strong>个，已上图<strong>" + result.data.yst +
                    "</strong>个";
                $("#wrdk_detail").html(detail);
            }
        });
    } else if (dong.num == "12") { // 农用地 
        ajaxPost("/cdsems/OneMapAlreadyShown/agriculturalLandShown", queryJson).done(function (result) {
            if (result.status == 0) {
                detail = "根据上报数据确认<strong>成都市</strong>农用地共计<strong>" + totalNumPloat + "</strong>块，已上图<strong>" + result.data.yst +
                    "</strong>块";
            }
            $("#wrdk_detail").html(detail);
        });
    } else if (dong.num == "14") {
        ajaxPost("/cdsems/OneMapAlreadyShown/landForConstructionShown", queryJson).done(function (result) {
            if (result.status == 0) {
                detail = "根据上报数据确认<strong>成都市</strong>建设用地准入共计<strong>" + totalNumPloat + "</strong>块，已上图<strong>" + result.data.yst +
                    "</strong>块";
            }
            $("#wrdk_detail").html(detail);
        });
    }
}
/**
 * 县计数数据处理
 * @param countyCountData
 * @param barName 柱状图名称
 * @param unit 单位
 *  
 */
function countyCountDataProcessing(countyCountData, unit) {
    var bar_xAxisData = [];
    var bar_yAxisData = [];
    for (i = 0; i < countyCountData.length; i++) {
        var temp = {
            value: countyCountData[i].COUNT,
            code: countyCountData[i].CODE
        }
        if (countyCountData[i].NAME) {
            bar_yAxisData.push(countyCountData[i].NAME);
            bar_xAxisData.push(temp);
        }
    }
    creatBar(bar_yAxisData, bar_xAxisData, unit);
}
/**
 * 获取查询条件
 * @return json
 */
function getQueryCondition() {
    var xianCode = "";
    if (dong.xianCode) {
        xianCode = dong.xianCode.toString();
    }
    var json = {
        shi: "510100",
        xian: xianCode
    }
    if (dong.ztorfb == "分布图") {
    	json.fbt = 1;
    } else {
    	json.fbt = 0;
    }
    if (dong.num == "1") { // 污染地块
        json.scjd = $("#scjd").val(); // 所处阶段
        json.dkbm = $("#dkbm").val(); // 地块编码
        json.fxjb = $("#fxjb").val(); // 风险级别 
        json.dkmc = $("#dkmc").val();  // 地块名称
    } else if (dong.num == "8") {
        json.enterpriseName = $("#enterpriseName").val();
        json.industry = $("#industry option:selected").val();
    } else if (dong.num == "13") { // 工业园区
        json.parkName = $("#parkName").val();
        json.contactName = $("#park_contactName").val();
        json.contactPhone = $("#park_contactPhone").val();
    } else if (dong.num == "12") { // 农用地
        json.agricuturalName = $("#agricuturalName").val();
        json.agricuturalCode = $("#agricuturalCode").val();
        json.agricuturalType = $("#agricuturalType").val();
    } else if (dong.num == "14") { // 建设用地准入
        json.dkmc = $("#jsyd_dkmc").val();  // 地块名称  MASSIF_NAME
        json.dkbm = $("#jsyd_dkbm").val(); // 地块编码  MASSIF_CODE  
        json.fxjb = $("#jsyd_fxjb").val(); // 风险级别  RISK_LEVEL
    }
    return json;
}

/**
 * 县级污染地块点的详细信息
 * @param data
 */
function countyDetailsOfPollutedLand(data) {
    var urlPNG = getPointPNG();
    removeTc("countLayer");
    removeTc("diangraphicsLayer");
    app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
    app.map.addLayer(app.diangraphicsLayer);
    app.diangraphicsLayer.on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.diangraphicsLayer.on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    //点击事件
    app.diangraphicsLayer.on("click", function (evt) {
        clickDian(evt.graphic.geometry.x, evt.graphic.geometry.y, urlPNG);
        fujin(evt, dong.num);
    })
    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/wurandikuai.png", 24, 24);
    pointSymbol.setOffset(0, 16);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.massifLongitude), handle_y(item.massifLatitude), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({ id: item.massifCode, WRDKBM: item.massifCode, WRDKMC: item.massifName, SCJDBM: item.massifStage, FXJB: item.riskLevel });
        app.diangraphicsLayer.add(graphic);
    })
    // 表格显示
    toolbarForm(data, "dian", urlPNG);
    showCountyDetail(data, "dian", urlPNG);
}

/**
 * 重点行业监管企业县级详情
 * @param data
 */
function countyDetailsOfKeyEnterprise(data) {
    var urlPNG = getPointPNG();
    removeTc("diangraphicsLayer");
    removeTc("countLayer");
    app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
    app.map.addLayer(app.diangraphicsLayer);
    app.diangraphicsLayer.on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.diangraphicsLayer.on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    app.diangraphicsLayer.on("click", function (evt) {
        clickDian(evt.graphic.geometry.x, evt.graphic.geometry.y, urlPNG);
        zhongdianMessage(evt);
    })

    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/zhongdianhangye.png", 18, 18);
    pointSymbol.setOffset(0, 0);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.LONGITUDE), handle_y(item.LATITUDE), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({
            id: "zhongdian" + item.ID, organizingCode: item.ORGANIZING_CODE,
            enterpriseName: item.COMPANY_NAME, industry: item.INDUSTRY_TYPE

        });
        app.diangraphicsLayer.add(graphic);
    })
    toolbarForm(data, "dianZhondian", urlPNG);
    showCountyDetail(data, "dianZhondian", urlPNG);
}

/**
 * 农用地县级详情
 * @param data
 */
function countyDetailsOfAgriculturalLand(data) {
    var urlPNG = getPointPNG();
    removeTc("diangraphicsLayer");
    removeTc("countLayer");
    app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
    app.map.addLayer(app.diangraphicsLayer);
    app.diangraphicsLayer.on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.diangraphicsLayer.on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    app.diangraphicsLayer.on("click", function (evt) {
        clickDian(evt.graphic.geometry.x, evt.graphic.geometry.y, urlPNG);
        nongyongdiMessage(evt);
    })

    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/nongyongdi.png", 18, 18); 
    pointSymbol.setOffset(0, 0);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.longitude), handle_y(item.latitude), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({
            id: "nongyong" + item.aid, agricuturalName: item.agricuturalName, agricuturalCode: item.agricuturalCode,
            agricuturalType: item.agricuturalType
        });
        app.diangraphicsLayer.add(graphic);
    })
    toolbarForm(data, "nongyongdian", urlPNG);
    showCountyDetail(data, "nongyongdian", urlPNG);
}

/**
 * 县级建设用地详细信息
 * @param data
 */
function countyDetailsOfConstructionLand(data) {
    var urlPNG = getPointPNG();
    removeTc("countLayer");
    removeTc("diangraphicsLayer");
    app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
    app.map.addLayer(app.diangraphicsLayer);
    app.diangraphicsLayer.on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.diangraphicsLayer.on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    //点击事件
    app.diangraphicsLayer.on("click", function (evt) {
        clickDian(evt.graphic.geometry.x, evt.graphic.geometry.y, urlPNG);
        jiansheMessage(evt, dong.num);
    })
    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/jianshe.png", 24, 24); // TODO 更换图片
    pointSymbol.setOffset(0, 16);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.massifLongitude), handle_y(item.massifLatitude), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({
            id: item.lid, enterpriseName: item.enterpriseName,
            massifName: item.massifName, massifCode: item.massifCode,
            riskLevel: item.riskLevel, massifCovered: item.massifCovered, massifAroundArea: item.massifAroundArea,
            constructionPhone: item.constructionPhone, constructionPeople: item.constructionPeople
        });
        app.diangraphicsLayer.add(graphic);
    })
    // 表格显示
    toolbarForm(data, "jianshe", urlPNG);
    showCountyDetail(data, "jianshe", urlPNG);
}
/**
 * 获取地图上点的图片
 */
function getPointPNG() {
    var url = "../../img/dian/wurandikuai64_2.png";
    if (dong.num == 1) {
        url = "../../img/dian/wurandikuai64_2.png";
    } else if (dong.num == 8) {
        url = "../../img/dian/zhongdianhangye64_2.png";
    } else if (dong.num == 12) { // 农用地
        url = "../../img/dian/nongyongdi64_2.png";
    } else if (dong.num == 14) { // 农用地
        url = "../../img/dian/jianshe.png";
    }
    return url;
}
/**
 * 显示县数据详情
 * @param data
 * @param str
 * @param url
 */
function showCountyDetail(data, str, url) {
    var headHtml = "";
    var bodyHtml = '';
    $("#countryDetail").show(); // 显示县表格数据
    $("#wrdk_bar").hide(); // 隐藏柱状图
    countyDataDescribe(data.length);
    $(".wrdk_barTip").empty();
    if (str == "dian") { // 污染地块信息
        if (user.suLevel == "3") { // 县级用户
            $(".wrdk_barTip").append("<p>污染地块信息</p>");
        } else {
            $(".wrdk_barTip").append("<p>污染地块信息</p>" + returnTocity);
        }
        headHtml = "<tr><td style='width:40px'>序号</td><td>地块名称</td></tr>";
        $.each(data, function (i, item) {
            var WRDKMC = "";
            WRDKMC = item.massifName;
            if (item.massifName) {
                if (item.massifName.length > 12) WRDKMC = WRDKMC.substr(0, 12) + "..."
                // S0: 疑似地块 S1:初步调查 S2: 详细调查 S3: 风险评估 S4:风险管控 S5: 土壤修复与治理 S6: 土壤修复与治理评估
                bodyHtml += "<tr id='" + item.massifCode + "' ondblclick='ondbclickDingwei(" + item.massifLongitude + "," + item.massifLatitude + ")'><td style='display:none;'>" + handle_x(item.massifLongitude) + "," + handle_y(item.massifLatitude) + "</td><td>" + (i + 1) + "</td><td title='" + item.massifName + "'>" + WRDKMC + "</td></tr>";
            }
        })
    } else if (str == "jianshe") {
        if (user.suLevel == "3") { // 县级用户
            $(".wrdk_barTip").append("<p>建设用地准入信息</p>");
        } else {
            $(".wrdk_barTip").append("<p>建设用地准入信息</p>" + returnTocity);
        }
        headHtml = "<tr><td style='width:40px'>序号</td><td>地块名称</td></tr>";
        $.each(data, function (i, item) {
            var WRDKMC = "";
            WRDKMC = item.massifName;
            if (item.massifName) {
                if (item.massifName.length > 12) WRDKMC = WRDKMC.substr(0, 12) + "..."
                // S0: 疑似地块 S1:初步调查 S2: 详细调查 S3: 风险评估 S4:风险管控 S5: 土壤修复与治理 S6: 土壤修复与治理评估
                bodyHtml += "<tr id='" + item.massifCode + "' ondblclick='ondbclickDingwei(" + item.massifLongitude + "," + item.massifLatitude + ")'><td style='display:none;'>" + handle_x(item.massifLongitude) + "," + handle_y(item.massifLatitude) + "</td><td>" + (i + 1) + "</td><td title='" + item.massifName + "'>" + WRDKMC + "</td></tr>";
            }
        })
    } else if (str == "dianZhondian") {
        // 重点行业监管企业
        if (user.suLevel == "3") { // 县级用户
            $(".wrdk_barTip").append("<p>重点行业企业</p>");
        } else {
            $(".wrdk_barTip").append("<p>重点行业企业</p>" + returnTocity);
        }
        headHtml = "<tr><td style='width:40px'>序号</td><td>企业名称</td></tr>";
        $.each(data, function (i, item) {
            if (item.COMPANY_NAME == undefined || item.COMPANY_NAME == null) item.COMPANY_NAME = "";
            if (item.unifiedSocialCreditIdentifier == undefined || item.unifiedSocialCreditIdentifier == null) item.unifiedSocialCreditIdentifier = "";
            if (item.organizingInstitutionBarCode == undefined || item.organizingInstitutionBarCode == null) item.organizingInstitutionBarCode = "";
            if (item.industry == undefined || item.industry == null) item.industry = "";
            var enterpriseName = "";
            enterpriseName = item.COMPANY_NAME
            if (item.COMPANY_NAME.length > 12) enterpriseName = item.COMPANY_NAME.substr(0, 12) + "..."
            bodyHtml += "<tr id='zhongdian" + item.id + "' ondblclick='ondbclickDingwei(" + item.LONGITUDE + "," + item.LATITUDE + ")'><td style='display:none;'>" + handle_x(item.LONGITUDE) + "," + handle_y(item.LATITUDE) + "</td><td>" + (i + 1) + "</td><td title='" + item.COMPANY_NAME + "'>" + enterpriseName + "</td></tr>";
        })
    } else if (str == "nongyongdian") {
        if (user.suLevel == "3") { // 县级用户
            $(".wrdk_barTip").append("<p>农用地信息</p>");
        } else {
            $(".wrdk_barTip").append("<p>农用地信息</p>" + returnTocity);
        }
        headHtml = "<tr><td style='width:40px'>序号</td><td>农用地名称</td></tr>";
        $.each(data, function (i, item) {
            var agricuturalName = "";
            if (item.agricuturalName) {
                agricuturalName = item.agricuturalName;
                if (item.agricuturalName.length > 12) agricuturalName = item.agricuturalName.substr(0, 12) + "..."
                bodyHtml += "<tr id='" + item.agricuturalCode + "' ondblclick='ondbclickDingwei(" + item.longitude + "," + item.latitude + ")'><td style='display:none;'>" + handle_x(item.longitude) + "," + handle_y(item.latitude) + "</td><td>" + (i + 1) + "</td><td title='" + item.agricuturalName + "'>" + agricuturalName + "</td></tr>";
            }
        })
    }
    $("#countryDetail thead").html(headHtml);
    $("#countryDetail tbody").html(bodyHtml);
    changBkColorCountyData(url);
}

/**
 * 柱状图
 * @param xdata
 * @param ydata
 * @param dw // 单位
 */
function creatBar(xdata, ydata, dw) {
    option = {
        title: {
            text: "",
            x: 'center',
            textStyle: {
                fontSize: 15
            },
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
            },
            confine: true,
            formatter: function (params) {
                var result = '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + params[0].color + ';"></span>'
                    + params[0].seriesName + '<br>' + params[0].name + ': ' + params[0].value + "(" + dw + ")";
                return result;
            }
        },
        grid: {
            left: '5%',
            bottom: '1%',
            top: '1%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            name: dw,
            nameGap: 2,
            axisLabel: {
                fontSize: 8,
                rotate: 40
            }
        },
        yAxis: {
            type: 'category',
            data: xdata,
            name: "县名",
            axisLabel: {
                interval: 0,
                fontSize: 11,
                formatter: function (v) {
                    var name = v;
                    if (name.length > 5) {
                        return name.substring(0, 5) + '\n' + name.substring(5);

                    } else {
                        return name
                    }
                }
            }
        },
        series: [
            {
                name: name,
                type: 'bar',
                itemStyle: {
                    normal: { color: '#5b9bd5' }
                },
                barWidth: 5,
                barCateGoryGap: 20,
                data: ydata
            }
        ]
    };
    if (thematicMapBar) {
        thematicMapBar.dispose();
    }
    $("#wrdk_bar").show();
    $("#countryDetail").hide();
    thematicMapBar = echarts.init(document.getElementById("wrdk_bar"));
    if (xdata.length > 0) {
    	thematicMapBar.setOption(option);
        thematicMapBar.on('click', function (params) {
            var code = params.data.code;
            var name = params.name;
            $("#county").val(code);
            dong.xianCode = code;
            queryPosition(code); // 定位
            var queryJson = getQueryCondition();
            moduleQuery(queryJson);
        });
    }
}
/**
 * 改变县详情数据背景
 * @param url
 */
function changBkColorCountyData(url) {
    $('#countryDetail tbody tr').hover(function () {
        var dians = $(this).children('td:eq(0)').text();
        var dian = dians.split(",")
        var lon = dian[0];
        var lat = dian[1];
        $(this).css("background", "#c0d5e8")
        removeTc("messageHeightayer");
        app.messageHeightayer = new dong.GraphicsLayer({ id: "messageHeightayer" });
        app.map.addLayer(app.messageHeightayer);
        var pointSymbol = new dong.PictureMarkerSymbol(url, 45, 45);
        pointSymbol.setOffset(0, 16);
        var point = new dong.Point(lon, lat, new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        app.messageHeightayer.add(graphic);
    }, function () {
        removeTc("messageHeightayer");
        $('#countryDetail tbody tr').css("background", "none")
    });
}
/**
 * 返回市
 */
function fanhuiShi() {
    // 1.下拉框值设置为空
    $("#county").val("");
    // 2.dong.xianCode = ""
    dong.xianCode = "";
    removeFujin();
    removeGraphic("provinceHigh");
    removeGraphic("provinceHigh1");
    removeGraphic("provinceHigh2");
    removeTc("diangraphicsLayer");
    // 重新查询数据
    conditionQuery();
}
/**
 * 县数据描述
 * @param numberOfPicturesAbove 已上图数量
 */
function countyDataDescribe(numberOfPicturesAbove) {
    $("#wrdk_detail").html("");
    var detail = "";
    if (dong.num == "1") {
        detail = "根据上报地块数据确认<strong>" + dong.xianName + "</strong>污染地块已上图<strong>" + numberOfPicturesAbove + "</strong>块。";
    } else if (dong.num == "8") {
        detail = "根据上报重点行业监管企业数据确认<strong>" + dong.xianName + "</strong>组织机构代码数据上图共计<strong>" + numberOfPicturesAbove + "</strong>个。";
    } else if (dong.num == "12") {
        detail = "根据上报农用地数据数据确认<strong>" + dong.xianName + "</strong>组织机构代码数据上图共计<strong>" + numberOfPicturesAbove + "</strong>个。";
    } else if (dong.num == "14") {
        detail = "根据上报建设用地准入数据数据确认<strong>" + dong.xianName + "</strong>建设用地准数据上图共计<strong>" + numberOfPicturesAbove + "</strong>个。";
    }
    $("#wrdk_detail").html(detail);
}
/**
 * 工具条上表格
 * @param data
 * @param str 模块标识
 * @param url 图片地址
 */
function toolbarForm(data, str, url) {
    $("#tongjituDiv tbody").html("");
    var headHtml = "", bodyHtml = '';
    if (str == "dian") {
        $("#title").html("污染地块信息");
        headHtml = "<tr><td style='width:40px'>序号</td><td>地块名称</td><td>污染地块编码</td><td style='border-right:0'>所处阶段</td></tr>";
        $.each(data, function (i, item) {
            var WRDKMC;
            if (item.massifName) {
            	 WRDKMC = item.massifName;
                if (item.massifName.length > 12) WRDKMC = item.massifName.substr(0, 12) + "..."
                // S0: 疑似地块 S1:初步调查 S2: 详细调查 S3: 风险评估 S4:风险管控 S5: 土壤修复与治理 S6: 土壤修复与治理评估
                bodyHtml += "<tr id='" + item.massifCode + "' ondblclick='ondbclickDingwei(" + item.massifLongitude + "," + item.massifLatitude + ")'><td style='display:none;'>" + handle_x(item.massifLongitude) + "," + handle_y(item.massifLatitude) + "</td><td>" + (i + 1) + "</td><td title='" + item.WRDKMC + "'>" + WRDKMC + "</td><td>" + item.massifCode + "</td><td style='border-right:0'>" + item.massifStage + "</td></tr>";
            }
        })
    } else if (str == "jianshe") {
        $("#title").html("建设用地准入信息");
        headHtml = "<tr><td style='width:40px'>序号</td><td>地块名称</td><td>地块编码</td></tr>";
        $.each(data, function (i, item) {
            var WRDKMC;
            if (item.massifName) {
            	 WRDKMC = item.massifName;
                if (item.massifName.length > 12) WRDKMC = item.massifName.substr(0, 12) + "..."
                // S0: 疑似地块 S1:初步调查 S2: 详细调查 S3: 风险评估 S4:风险管控 S5: 土壤修复与治理 S6: 土壤修复与治理评估
                bodyHtml += "<tr id='" + item.massifCode + "' ondblclick='ondbclickDingwei(" + item.massifLongitude + "," + item.massifLatitude + ")'><td style='display:none;'>" + handle_x(item.massifLongitude) + "," + handle_y(item.massifLatitude) + "</td><td>" + (i + 1) + "</td><td title='" + item.WRDKMC + "'>" + WRDKMC + "</td><td>" + item.massifCode + "</td></tr>";
            }
        })
    } else if (str == "jiansheCount") {
        $("#title").html("建设用地准入信息");
        var headHtml = "<tr><td style='width:40px'>序号</td><td>地区</td><td style='border-right: 0;'>污染地块数量</td></tr>";
        var bodyHtml = '';
        var sumCount = 0;
        $.each(data, function (i, item) {
            var name = "";
            if (!item.NAME) {
                name = "";
            } else {
                name = item.NAME;
                bodyHtml += "<tr><td>" + (i + 1) + "</td><td>" + name + "</td><td style='border-right: 0;'>" + item.COUNT + "</td></tr>";
                sumCount += item.COUNT;
            }
        })
        bodyHtml += "<tr><td></td><td><strong>总数</strong></td><td><strong>" + sumCount + "</strong></td></tr>";
    } else if (str == "dianZhondian") {
        $("#title").html("重点行业监管企业");
        headHtml = "<tr><td style='width:40px'>序号</td><td>企业名称</td><td >组织机构代码</td><td style='border-right:0'>行业</td></tr>";
        $.each(data, function (i, item) {
            if (!item.COMPANY_NAME) item.COMPANY_NAME = "";
            if (!item.ORGANIZING_CODE) item.ORGANIZING_CODE = "";
            if (!item.INDUSTRY_TYPE) item.INDUSTRY_TYPE = "";
            bodyHtml += "<tr id='zhongdian" + item.ID + "' ondblclick='ondbclickDingwei(" + item.LONGITUDE + "," + item.LATITUDE + ")'><td style='display:none;'>" + handle_x(item.LONGITUDE) + "," + handle_y(item.LATITUDE) + "</td><td>" + (i + 1) + "</td><td>" + item.COMPANY_NAME + "</td>" +
                "<td >" + item.ORGANIZING_CODE + "</td><td style='border-right:0'>" + item.INDUSTRY_TYPE + "</td></tr>";
        })

    } else if (str == "zhongdian") {
        $("#title").html("重点行业企业");
        var headHtml = "<tr><td>序号</td><td>地区</td><td>重点行业数量</td></tr>";
        var bodyHtml = '';
        var sumCount = 0;
        $.each(data, function (i, item) {
            var name = "";
            if (!item.NAME) {
                name = ""
            } else {
                name = item.NAME
                bodyHtml += "<tr><td>" + (i + 1) + "</td><td>" + name + "</td><td>" + item.COUNT + "</td></tr>";
                sumCount += item.COUNT;
            }
        })
        bodyHtml += "<tr><td></td><td><strong>总数</strong></td><td><strong>" + sumCount + "</strong></td></tr>";
    } else if (str == "dianZhondian") {
        $("#title").html("重点行业企业");
        headHtml = "<tr><td style='width:40px'>序号</td><td>企业名称</td><td>组织机构代码</td><td style='border-right:0'>行业</td></tr>";
        $.each(data, function (i, item) {
            var enterpriseName = "";
            if (item.enterpriseName) {
                if (item.enterpriseName.length > 12) enterpriseName = item.COMPANY_NAME.substr(0, 12) + "..."
                bodyHtml += "<tr id='" + item.ORGANIZING_CODE + "' ondblclick='ondbclickDingwei(" + item.LONGITUDE + "," + item.LATITUDE + ")'><td style='display:none;'>" + handle_x(item.LONGITUDE) + "," + handle_y(item.LATITUDE) + "</td><td>" + (i + 1) + "</td><td title='" + item.COMPANY_NAME + "'>" + enterpriseName + "</td><td>" + item.ORGANIZING_CODE + "</td><td style='border-right:0'>" + item.INDUSTRY_TYPE + "</td></tr>";
            }
        })
    }
    else if (str == "gongyeyuanqu") {
        $("#title").html("工业园区信息");
        var headHtml = "<tr><td style='width:40px'>序号</td><td>地区</td><td style='border-right: 0;'>工业园区数量</td></tr>";
        var bodyHtml = '';
        var sumCount = 0;
        $.each(data, function (i, item) {
            var name = "";
            if (!item.NAME) {
                name = "";
            } else {
                name = item.NAME;
                bodyHtml += "<tr><td>" + (i + 1) + "</td><td>" + name + "</td><td style='border-right: 0;'>" + item.COUNT + "</td></tr>";
                sumCount += item.COUNT;
            }
        })
        bodyHtml += "<tr><td></td><td><strong>总数</strong></td><td><strong>" + sumCount + "</strong></td></tr>";
    } else if (str == "nongyongdi") {
        $("#title").html("农用地信息");
        var headHtml = "<tr><td style='width:40px'>序号</td><td>地区</td><td style='border-right: 0;'>农用地数量</td></tr>";
        var bodyHtml = '';
        var sumCount = 0;
        $.each(data, function (i, item) {
            var name = "";
            if (!item.NAME) {
                name = "";
            } else {
                name = item.NAME;
                bodyHtml += "<tr><td>" + (i + 1) + "</td><td>" + name + "</td><td style='border-right: 0;'>" + item.COUNT + "</td></tr>";
                sumCount += item.COUNT;
            }
        })
        bodyHtml += "<tr><td></td><td><strong>总数</strong></td><td><strong>" + sumCount + "</strong></td></tr>";
    } else if (str == "nongyongdian") {
        $("#title").html("农用地信息");
        headHtml = "<tr><td style='width:40px'>序号</td><td>农用地名称</td><td>农用地编码</td><td style='border-right:0'>土地利用类型</td></tr>";
        $.each(data, function (i, item) {
            var agricuturalName = "";
            if (item.agricuturalName) {
            	agricuturalName = item.agricuturalName;
                if (item.agricuturalName.length > 12) agricuturalName = item.agricuturalName.substr(0, 12) + "..."
                bodyHtml += "<tr id='" + item.agricuturalCode + "' ondblclick='ondbclickDingwei(" + item.longitude + "," + item.latitude + ")'><td style='display:none;'>" + handle_x(item.longitude) + "," + handle_y(item.latitude) + "</td><td>" + (i + 1) + "</td><td title='" + item.agricuturalName + "'>" + agricuturalName + "</td><td>" + item.agricuturalCode + "</td><td style='border-right:0'>" + item.agricuturalType + "</td></tr>";
            }
        })
    } else {
        $("#title").html("污染地块信息");
        var headHtml = "<tr><td style='width:40px'>序号</td><td>地区</td><td style='border-right: 0;'>污染地块数量</td></tr>";
        var bodyHtml = '';
        var sumCount = 0;
        $.each(data, function (i, item) {
            var name = "";
            if (!item.NAME) {
                name = "";
            } else {
                name = item.NAME;
                bodyHtml += "<tr><td>" + (i + 1) + "</td><td>" + name + "</td><td style='border-right: 0;'>" + item.COUNT + "</td></tr>";
                sumCount += item.COUNT;
            }
        })
        bodyHtml += "<tr><td></td><td><strong>总数</strong></td><td><strong>" + sumCount + "</strong></td></tr>";
    }
    $("#tongjituDiv thead").html(headHtml);
    $("#tongjituDiv tbody").html(bodyHtml);
    changBkColor(url);
}
/**
 * 县计数数据
 * @param data
 */
function countyCount(data) {
    removeTc("countLayer");
    var graphicsLayer = new dong.GraphicsLayer({ id: "countLayer" });
    app.map.addLayer(graphicsLayer);
    var xianLayer = app.map.getLayer("xian");
    if (xianLayer) {
        var feaGraphics = app.map.getLayer("xian").graphics;
        addGraphicsToMap(data, feaGraphics);
    } else {
        addLayerXian();
        app.xian.on("update-end", function (e) {
            var feaGraphics = app.map.getLayer("xian").graphics;
            addGraphicsToMap(data, feaGraphics);
        });
    }
    app.map.getLayer("countLayer").on("click", function (evt) {
        $("#tongjituDiv thead").html("");
        $("#tongjituDiv tbody").html("");
        dong.xianCode = evt.graphic.attributes.code;
        dong.xianName = evt.graphic.attributes.name;
        var queryJson = getQueryCondition(); // 获取查询条件
        moduleQuery(queryJson)
    })
}

/**
 * 将graphics添加到地图上
 * @param data
 * @param feaGraphics
 */
function addGraphicsToMap(data, feaGraphics) {
    for (var i = 0; i < feaGraphics.length; i++) {
        var currFeaGraphic = feaGraphics[i];
        //遍历数据
        for (var j = 0; j < data.length; j++) {
            var currItem = data[j];
            //判断省界的PROV_CODE属性值与当前数据的province属性值是否相同
            if (currItem.CODE) {
                if (currFeaGraphic.attributes.KIND_1 == currItem.CODE.substr(0, 4) || currFeaGraphic.attributes.CODE == currItem.CODE) {
                    var attributes = {
                        provoinceCode: currItem.CODE,
                        provinceName: currItem.NAME
                    }
                    var point = currFeaGraphic.geometry.getCentroid();
                    var symbolSize = 30;
                    if (currItem.COUNT.toString().length == 1) {
                        symbolSize = 40;
                    } else if (currItem.COUNT.toString().length == 2) {
                        symbolSize = 50;
                    } else if (currItem.COUNT.toString().length == 3) {
                        symbolSize = 60;
                    } else if (currItem.COUNT.toString().length == 4) {
                        symbolSize = 70;
                    } else if (currItem.COUNT.toString().length == 5) {
                        symbolSize = 80;
                    } else {
                        symbolSize = currItem.COUNT.toString().length * 12;
                    }
                    var img = "../../img/information/number.png";
                    if (dong.num == "11" || dong.num == "1") {
                        img = "../../img/information/chang.png";
                    }
                    var symbol1 = new dong.PictureMarkerSymbol(img, symbolSize, symbolSize).setOffset(0, symbolSize / 2);
                    var symbol2 = new dong.TextSymbol(currItem.COUNT).setOffset(0, symbolSize / 2 - 5).setColor(new dong.Color([255, 255, 255, 1]));//.setHaloSize(3).setHaloColor(new Color([255,255,255]));
                    symbol2.font.setFamily("Times");
                    symbol2.font.setSize("10pt");
                    symbol2.font.setWeight(600);
                    var graphic1 = new dong.Graphic(point, symbol1, attributes);
                    var graphic2 = new dong.Graphic(point, symbol2, attributes);
                    graphic1.setAttributes({ lon: currItem.LON, lat: currItem.LAT, name: currItem.NAME, code: currItem.CODE, level: "8" });
                    graphic2.setAttributes({ lon: currItem.LON, lat: currItem.LAT, name: currItem.NAME, code: currItem.CODE, level: "8" });
                    app.map.getLayer("countLayer").add(graphic1);
                    app.map.getLayer("countLayer").add(graphic2);
                }
            }
        }
        app.map.getLayer("countLayer").on("click", function (evt) {
            $("#tongjituDiv thead").html("");
            $("#tongjituDiv tbody").html("");
            dong.xianCode = evt.graphic.attributes.code;
            dong.xianName = evt.graphic.attributes.name;
            // 设置市下拉框的值为县
            $("#county").val(dong.xianCode);
            // 定位到县
            queryPosition(dong.xianCode);
            var queryJson = getQueryCondition(); // 获取查询条件
            moduleQuery(queryJson);
        })
    }
}
/**
 * 获取查询条件所需图层
 */
function getQueryLayer() {
    if (dong.xianCode) { // 县
        dong.tucengType = "xian"
    } else { // 市
        dong.tucengType = "shi"
        addLayerXian(); // 市不为空添加县图层
    }
}
/**
 * 添加县图层，并给县图层绑定事件
 */
function addLayerXian() {
    removeTc("shi");
    removeTc("xian");
    removeGraphic("provinceHigh2"); // 移除省份高亮
    app.xian = new dong.FeatureLayer("http://" + ip + ":6080/arcgis/rest/services/seimp/countynew/MapServer/0", {
        mode: dong.FeatureLayer.MODE_SNAPSHOT,
        outFields: ["*"],
        id: "xian"
    });
    app.xian.setDefinitionExpression("CODE  like '" + (dong.shiCode + "").substr(0, 4) + "%'");
    app.map.addLayer(app.xian);
    //加载市名标签
    var statesLabel = new dong.TextSymbol().setColor(new dong.Color("#0a162c"));
    statesLabel.font.setSize("12pt");
    statesLabel.font.setWeight(700);
    statesLabel.setOffset(20, -20);
    var labelClass = new dong.LabelClass({
        "labelExpressionInfo": { "value": "{NAME}" },
        "useCodedValues": true,
        "labelPlacement": "below-right",
        "fieldInfos": [{ fieldName: "NAME" }]
    });
    labelClass.symbol = statesLabel;
    var outlineSymbol = new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_SOLID, new dong.Color([0, 0, 0, 0.5]), 1);
    var defaultSymbol = new dong.SimpleFillSymbol(dong.SimpleFillSymbol.STYLE_SOLID, outlineSymbol, new dong.Color([0, 0, 0, 0]));
    renderer = new dong.SimpleRenderer(defaultSymbol);
    app.xian.setRenderer(renderer);
    app.xian.on("mouse-over", function (evt) {
    	/*if (isAttributeQuery()) { // 判断是否是属性查询
         	return;
        }*/
        if (dong.ztorfb == "分布图") return;
        removeGraphic("provinceHigh");
        var lineJson = {
            "paths": evt.graphic.geometry.rings,
            "spatialReference": { "wkid": 102100 }
        }
        var highPolyline = new dong.Polyline(lineJson);
        var highSymbol = new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_SOLID, new dong.Color([255, 106, 106]), 1);
        var highGraphic = new dong.Graphic(highPolyline, highSymbol, { type: "provinceHigh" });
        app.map.graphics.add(highGraphic);
    })
    //添加鼠标移出事件
    app.xian.on("mouse-out", function () {
        if (dong.ztorfb == "分布图") return;
        removeGraphic("provinceHigh");
    })
    app.xian.on("click", function (evt) {
        dong.chaxun = false;
        if (dong.measure) { // 点击的是测量按钮的话直接退出
            return;
        }
        if (isAttributeSearch) { // 判断是否是属性查询
            return;
        }
        // 显示返回市按钮
        $("#fanhuiShi").show();
        dong.xianCode = evt.graphic.attributes.CNTY_CODE;
        dong.xianName = evt.graphic.attributes.NAME;
        // 设置市下拉框的值为县
        $("#county").val(dong.xianCode);
        // 定位到县
        queryPosition(dong.xianCode);
        var queryJson = getQueryCondition(); // 获取查询条件
        moduleQuery(queryJson);
    });
}
/**
 * 专题图查询定位
 * @param countyCode 县代码
 */
function queryPosition(countyCode) {
    var provinceCode = "510000";
    var cityCode = "510100";
    dong.chaxun = true;
    var queryUrl = "";
    var whereString = "";
    var shengUrl = "http://" + ip + ":6080/arcgis/rest/services/seimp/shengjienew/MapServer/0";
    var shiUrl = "http://" + ip + ":6080/arcgis/rest/services/seimp/city/MapServer/0";
    var xianUrl = "http://" + ip + ":6080/arcgis/rest/services/seimp/countynew/MapServer/0";
    var whereStringSheng = "PROV_CODE = '" + provinceCode + "'";
    var whereStringXian = "KIND_1 = '" + cityCode.substring(0, 4) + "'";

    if (countyCode) { // 县
        queryUrl = xianUrl;
        whereString = "CODE = '" + countyCode + "'";
        dong.tucengType = "xian";
        removeTc("xian"); // 定位到县时移除县图层
        if (user.suLevel == "3") {
            // 县级用户不显示返回市
        } else {
            $(".menuTip").show(); // 返回市显示
        }
    } else { // 市
        queryUrl = shiUrl;
        whereString = whereStringXian;
        dong.shiCode = cityCode;
        dong.tucengType = "shi";
        $(".menuTip").hide();
    }
    // 根据省市县选择查询不同的图层，显示并高亮
    var queryTask = new dong.QueryTask(queryUrl);
    //定义查询参数对象
    var query = new dong.Query();
    //查询条件，类似于sql语句的where子句
    query.where = whereString;
    //返回的字段信息：*代表返回全部字段
    query.outFields = ["*"];
    //是否返回几何形状
    query.returnGeometry = true;
    //执行属性查询
    queryTask.execute(query, showQueryResult);
}
/**
 * 查询完成之后，用showQueryResult来处理返回的结果
 * @param queryResult
 */
function showQueryResult(queryResult) {
    //创建线符号
    var lineSymbol = new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_SOLID, new dong.Color([252, 78, 42]), 4);
    //创建面符号
    var fill = new dong.SimpleFillSymbol(dong.SimpleFillSymbol.STYLE_SOLID, lineSymbol);
    if (queryResult.features.length == 0) {
        return;
    }
    removeGraphic("provinceHigh1");
    removeGraphic("provinceHigh2"); // 移除省高亮
    if (queryResult.features.length >= 1) {
        for (var i = 0; i < queryResult.features.length; i++) {
            //获得图形graphic
            var graphic = queryResult.features[i];
            //赋予相应的符号
            var highGraphic = new esri.Graphic(graphic.geometry, lineSymbol, { type: "provinceHigh1" });
            var attributes = graphic.attributes;
            //将graphic添加到地图中，从而实现高亮效果
            var extent = graphic.geometry.getExtent();
            app.map.graphics.add(highGraphic);
            app.map.setExtent(extent);
            $(".modal-content .close").click(); // 关闭查询窗口
            var centerX = (extent.xmin + extent.xmax) / 2;
            var centerY = (extent.ymin + extent.ymax) / 2;
        }
    }
}
///////////////////////////////////// 分布图方法 ////////////////////////////////////////////////////////////////////////////
/**
 * 分布图查询
 */
function distributeMapQuery() {
    var queryJson = getQueryCondition();
    removeTc(fenbuDy[dong.num]);
    // 定位
    queryPosition(queryJson.xian);
    // dengdai();
    if (dong.num == "1") { // 污染地块
        ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapContaminsted", queryJson).done(function (result) {
            // removeDengdai()
            //  污染地块 用的图层 app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
            pollutedLandDistributeMap(result.data);
        })
    } else if (dong.num == "8") {
        ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapKeyEnterprise", queryJson).done(function (result) {
            // removeDengdai()
            //  污染地块 用的图层 app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
            keyEnterpriseDistributeMap(result.data);
        })
    } else if (dong.num == "14") { // 建设用地 
        ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapLandForConstruction", queryJson).done(function (result) {
            // removeDengdai()
            //  污染地块 用的图层 app.diangraphicsLayer = new dong.GraphicsLayer({ id: "diangraphicsLayer" });
            landForConstructionDistributeMap(result.data);
        })
    } else if (dong.num == "12") { // 农用地
        ajaxPost("/cdsems/OneMapContaminstedController/selectOneMapAgriculturalLand", queryJson).done(function (result) {
            agriculturalLandDistributeMap(result.data);
        });
    }
}
////////////////////////////////////////////////////////////目录及左侧点击事件////////////////////////////////////////////////
var fenbuDy = { "1": "fenbu_1", "2": "fenbu_2", "3": "fenbu_3", "4": "fenbu_4", "11": "fenbu_11", "5": "fenbu_5", "6": "fenbu_6", "7": "fenbu_7", "8": "fenbu_8", "12": "fenbu_12", "14": "fenbu_14" };
dong.ztorfb = "专题图"
function switchInThematicMapAndDistributeMap() {
    $("#poi_info_window .window_table .close").click(); // 关闭弹出信息框
    $(".typeShow1").toggle();
    $(".typeShowp1").toggle();
    $(".typeShow2").toggle();
    $(".typeShowp2").toggle();
    var modelname = ""; // 模块名称
    if (dong.ztorfb == "专题图") {
        $(".tool-bg").parent().show();
        qingFenbu();
        $(".infor-map").removeClass("toggle2");
        $(".information .toggleInfo").width("260px");
        $("#toggle-sidebar2").removeClass("toggleBar-right")

        var xuan;
        var num = 0;
        $.each($(".soilDl .sub_menu input"), function (i, item) {
            if (item.checked) {
                var str = $(item).context.getAttribute("data");
                str = str.split("_");
                removeDiv(fenbuDy[str[1]]);
                xuan = item;
                num++;
            }
        })
        $.each($(".wurandikuai .sub_menu input"), function (i, item) {
            if (item.checked) {
                var str = $(item).context.getAttribute("data");
                str = str.split("_");
                removeDiv(fenbuDy[str[1]]);
                xuan = item;
                num++;
            }
        })
        $.each($(".nongyongdi .sub_menu input"), function (i, item) {
            if (item.checked) {
                var str = $(item).context.getAttribute("data");
                str = str.split("_");
                removeDiv(fenbuDy[str[1]]);
                xuan = item;
                num++;
            }
        })
        $(".soilDl .sub_menu").html(radioHtml_1);
        $(".wurandikuai .sub_menu").html(radioHtml_2);
        $(".nongyongdi .sub_menu").html(radioHtml_3);
        radioCheckedClick(true);
        if (num == 1) {
            if (xuan) {
                $.each($(".soilDl .sub_menu input"), function (i, item) {
                    if ($(item).context.getAttribute("data") == $(xuan).context.getAttribute("data")) {
                        var str = $(item).context.getAttribute("data");
                        str = str.split("_")
                        modelname = str[0]
                        item.checked = true;
                        //tuliDiv(true, str[0]);
                        zhuantiRadioClick(item, true)
                    }
                })
                $.each($(".wurandikuai .sub_menu input"), function (i, item) {
                    if ($(item).context.getAttribute("data") == $(xuan).context.getAttribute("data")) {
                        var str = $(item).context.getAttribute("data");
                        str = str.split("_")
                        modelname = str[0]
                        item.checked = true;
                        zhuantiRadioClick(item, true)
                    }
                })
                $.each($(".nongyongdi .sub_menu input"), function (i, item) {
                    if ($(item).context.getAttribute("data") == $(xuan).context.getAttribute("data")) {
                        var str = $(item).context.getAttribute("data");
                        str = str.split("_")
                        modelname = str[0]
                        item.checked = true;
                        zhuantiRadioClick(item, true)
                    }
                })
            }
        }
    } else if (dong.ztorfb == "分布图") {
        qingZhuanti()
        $(".tool-bg").parent().hide();//右侧表格图标
        $("#tongjituDiv thead").html("");
        $("#tongjituDiv tbody").html("");
        $("#tongjituDiv #title").html("暂无数据");
        $(".menuTip").hide();  // 返回市隐藏
        var xuan;
        $.each($(".soilDl .sub_menu input"), function (i, item) {
            if (item.checked) xuan = item
        })
        $.each($(".wurandikuai .sub_menu input"), function (i, item) {
            if (item.checked) xuan = item
        })
        $.each($(".nongyongdi .sub_menu input"), function (i, item) {
            if (item.checked) xuan = item
        })
        $(".soilDl .sub_menu").html(checkedHtml_1)
        $(".wurandikuai .sub_menu").html(checkedHtml_2)
        $(".nongyongdi .sub_menu").html(checkedHtml_3)
        radioCheckedClick(true);
        if (xuan != undefined && xuan != null && xuan != "") {
            $.each($(".soilDl .sub_menu input"), function (i, item) {
                if ($(item).context.getAttribute("data") == $(xuan).context.getAttribute("data")) {
                    var str = $(item).context.getAttribute("data");
                    str = str.split("_")
                    modelname = str[0]
                    item.checked = true;
                    fenbuCheckClick(item);
                }
            })
            $.each($(".wurandikuai .sub_menu input"), function (i, item) {
                if ($(item).context.getAttribute("data") == $(xuan).context.getAttribute("data")) {
                    var str = $(item).context.getAttribute("data");
                    str = str.split("_")
                    modelname = str[0]
                    item.checked = true;
                    fenbuCheckClick(item);
                }
            })
            $.each($(".nongyongdi .sub_menu input"), function (i, item) {
                if ($(item).context.getAttribute("data") == $(xuan).context.getAttribute("data")) {
                    var str = $(item).context.getAttribute("data");
                    str = str.split("_")
                    modelname = str[0]
                    item.checked = true;
                    fenbuCheckClick(item);
                }
            })
        }
        // 移除专题图图层
        removeTc("shi");
        removeTc("xian");
        removeTc("countLayer");
        // 移除高亮图层和点图层
        removeGraphic("provinceHigh");
        // removeGraphic("provinceHigh1");
        removeGraphic("provinceHigh2");
    }
    $.each($(".soilDl .sub_menu input"), function (i, item) {
        var str = $(item).context.getAttribute("data");
        str = str.split("_")
        tuliDiv(false, str[0])
    })
    $.each($(".wurandikuai .sub_menu input"), function (i, item) {
        var str = $(item).context.getAttribute("data");
        str = str.split("_")
        tuliDiv(false, str[0])
    })
    $.each($(".nonghyongdi .sub_menu input"), function (i, item) {
        var str = $(item).context.getAttribute("data");
        str = str.split("_")
        tuliDiv(false, str[0])
    })
    if (modelname) {
        tuliDiv(true, modelname)
    }
}
/**
 * 单选框复选框点选事件
 * @param isBack {boolean} 判断是否是点击完分布图后再点击专题图
 */
function radioCheckedClick(isBack) {
    //土壤污染来源-radio
    $('.soilDl input:radio').click(function () {
        zhuantiRadioClick(this, isBack);
    })
    //土壤污染来源-checked
    $('.soilDl input:checkbox').click(function () {
        fenbuCheckClick(this, isBack);
    })
    //污染地块-radio
    $('.wurandikuai input:radio').click(function () {
        zhuantiRadioClick(this, isBack);
    })
    //污染地块-checked
    $('.wurandikuai input:checkbox').click(function () {
        fenbuCheckClick(this, isBack);
    })
    //农用地-radio
    $('.nongyongdi input:radio').click(function () {
        zhuantiRadioClick(this, isBack);
    })
    //农用地-checked
    $('.nongyongdi input:checkbox').click(function () {
        fenbuCheckClick(this, isBack);
    })
}

/**
 * 专题图单选框点击事件
 * @param that 当前点击项
 * @param isBack 是否点击过分布图
 */
function zhuantiRadioClick(that, isBack) {
    if (!isBack) { // 点击完分布图再返回专题图时不清空查询框内容
        qingkongZt();
        // 清空查询框
        removeGraphic("provinceHigh1");
        clearQueryCondition(); // 清空查询条件
    }
    removeTc("diangraphicsLayer"); // 清除点图层
    removeTc("shi");
    removeTc("xian");
    var str = $(that).context.getAttribute("data");
    str = str.split("_");
    dong.num = str[1]; // 记录点击选项
    conditionQuery(); // 条件查询
    if (isBack) {
        tuliDiv(true, str[0]);
    } else {
        tuliDiv(that.checked, str[0]);
    }
    $("#toggle-sidebar").click(); // 点击污染地块时全图显示
    isBack = false;
}
/**
 * 分布图复选框点击事件
 * @param that 当前点击项
 * @param isBack 是否点击过分布图
 */
function fenbuCheckClick(that) {
    var str = $(that).context.getAttribute("data");
    str = str.split("_");
    dong.num = str[1]; // 记录点击选项
    tuliDiv(that.checked, str[0])
    if (that.checked) {
        // 调用分布图方法
        distributeMapQuery();
        fenbu_tckz(str[0], fenbuDy[str[1]], 0);
    } else {
        fenbu_tckz("", fenbuDy[str[1]], 1)
        removeTc(fenbuDy[str[1]]);
        //removeGraphic("provinceHigh1"); // 清除地图高亮图层
    }
}


/**
 * 污染地块点的分布
 * @param num
 * @param str
 */
function pollutedLandDistributeMap(data) {
    removeTc(fenbuDy[dong.num]);
    //dengdai();
    app.map.addLayer(new dong.GraphicsLayer({ id: fenbuDy[dong.num] }));
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    //点击事件
    app.map.getLayer(fenbuDy[dong.num]).on("click", function (evt) {
        var src = "img/dian/wurandikuai64_2.png";
        fujin(evt);
    })
    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/wurandikuai.png", 24, 24);
    pointSymbol.setOffset(0, 16);
    $.each(data, function (i, item) {
        if (item) {
            var point = new dong.Point(handle_x(item.massifLongitude), handle_y(item.massifLatitude), new dong.SpatialReference({ wkid: 102100 }));
            var graphic = new dong.Graphic(point, pointSymbol, "", "");
            graphic.setAttributes({ id: item.massifCode, WRDKBM: item.massifCode, WRDKMC: item.massifName, SCJDBM: item.massifStage, FXJB: item.riskLevel });
            app.map.getLayer(fenbuDy[dong.num]).add(graphic);
        }
    })
}
/**
 * 重点行业企业分布
 */
function keyEnterpriseDistributeMap(data) {
    removeTc(fenbuDy[dong.num]);
    //dengdai();
    app.map.addLayer(new dong.GraphicsLayer({ id: fenbuDy[dong.num] }));
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    //点击事件
    app.map.getLayer(fenbuDy[dong.num]).on("click", function (evt) {
        var src = "img/dian/zhongdianhangye64_2.png";
        zhongdianMessage(evt, dong.num);
    })
    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/zhongdianhangye.png", 24, 24);
    pointSymbol.setOffset(0, 16);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.LONGITUDE), handle_y(item.LATITUDE), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({
            id: "zhongdian" + item.ID, organizingCode: item.ORGANIZING_CODE,
            enterpriseName: item.COMPANY_NAME, industry: item.INDUSTRY_TYPE

        });
        app.map.getLayer(fenbuDy[dong.num]).add(graphic);
    })
}


/**
 * 建设用地
 */
function landForConstructionDistributeMap(data) {
    removeTc(fenbuDy[dong.num]);
    //dengdai();
    app.map.addLayer(new dong.GraphicsLayer({ id: fenbuDy[dong.num] }));
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    //点击事件
    app.map.getLayer(fenbuDy[dong.num]).on("click", function (evt) {
        var src = "img/dian/jianshe64_2.png";
        jiansheMessage(evt);
    })
    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/jianshe.png", 24, 24);
    pointSymbol.setOffset(0, 16);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.massifLongitude), handle_y(item.massifLatitude), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({
            id: item.lid, enterpriseName: item.enterpriseName,
            organizingCode: item.organizationCode, massifCovered: item.massifCovered,
            massifAroundArea: item.massifAroundArea, constructionPeople: item.constructionPeople,
            constructionPhone: item.constructionPhone, riskLevel: item.riskLevel,
            massifCode:item.massifCode,massifName:item.massifName
        });
        app.map.getLayer(fenbuDy[dong.num]).add(graphic);
    })
}

/**
 * 农用地
 */
function agriculturalLandDistributeMap(data) {
    removeTc(fenbuDy[dong.num]);
    //dengdai();
    app.map.addLayer(new dong.GraphicsLayer({ id: fenbuDy[dong.num] }));
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-over", function (evt) {
        tableHight(evt.graphic.attributes.id, 0);
    })
    //添加鼠标移出事件
    app.map.getLayer(fenbuDy[dong.num]).on("mouse-out", function (evt) {
        tableHight(evt.graphic.attributes.id, 1);
    })
    //点击事件
    app.map.getLayer(fenbuDy[dong.num]).on("click", function (evt) {
        var src = "../../img/dian/nongyongdi64_2.png"; 
        nongyongdiMessage(evt);
    })
    var pointSymbol = new dong.PictureMarkerSymbol("../../img/dian/nongyongdi.png", 24, 24);
    pointSymbol.setOffset(0, 16);
    $.each(data, function (i, item) {
        var point = new dong.Point(handle_x(item.longitude), handle_y(item.latitude), new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        graphic.setAttributes({
            id: "nongyong" + item.aid, agricuturalName: item.agricuturalName, agricuturalCode: item.agricuturalCode,
            agricuturalType: item.agricuturalType
        });
        app.map.getLayer(fenbuDy[dong.num]).add(graphic);
    })
}

/**
 * 分布图的图层控制
 * @param name
 * @param id
 * @param num
 */
function fenbu_tckz(name, id, num) {
    var html = '<div class="row warning-element warnings" id="' + id + '" data="' + id + '">' +
        '<div class="col-sm-12" style="padding:0;">' +
        '   <i id="ss1" class="fa fa-eye fa-lg eye" checked="true" data="' + id + '"></i>' +
        '   <span style="cursor: move;">' + name + '</span>' +
        '   </div>' +
        '   <div class="col-sm-12 eyeSel" style="margin-left:19px;    height: auto;line-height: 50px;">' +
        '       <div class="' + id + '" style="width:88%;height: 2px;margin-right: 20px;"></div>' +
        '   </div>' +
        '</div>';
    if (num == 0) {
        $(".tool_hover").html(html + $(".tool_hover").html());
        huaDiv();
    } else if (num == 1) {
        removeDiv(id);
    }
}

/**
 * 点击点进行标识
 * @param lon
 * @param lat
 * @param str
 */
function clickDian(lon, lat, str) {
    removeTc("wrdkcentral")
    app.map.addLayer(new dong.GraphicsLayer({ id: "wrdkcentral" }));
    var attrs = {
        graType: "wrdkcentral"
    }
    var pointSymbol = new dong.PictureMarkerSymbol(str, 45, 45);
    pointSymbol.setOffset(0, 20);
    var point = new dong.Point(lon, lat, new dong.SpatialReference({ wkid: 102100 }));
    var graphic = new dong.Graphic(point, pointSymbol, attrs);
    graphic.setAttributes({ id: "" });
    app.map.getLayer("wrdkcentral").add(graphic);
}

/**
 * 删除图层控制中的div
 * @param id
 */
function removeDiv(id) {
    $(".tool_hover").each(function (i, item) {
        for (var a = 0; a < $(item).context.children.length; a++) {
            if ($(item).context.children[a].getAttribute("data") == id) {
                $(item).context.children[a].remove()
            }
        }
    });
}

/**
 * 清空分布图
 */
function qingFenbu() {
    removeTc("xian");
    $.each(fenbuDy, function (i, item) {
        removeTc(item);
    })
    removeFujin();
}

/**
 * 清空查询条件
 */
function clearQueryCondition() {
    if (user.suLevel == "3") {
        // 县级用户不清空下拉框
    } else {
        dong.xianName = "";
        dong.xianCode = "";
        $("#county").val("");
    }
}
/**
 * 清空专题图图例
 */
function qingkongZt() {
    $.each($(".soilDl .sub_menu input"), function (i, item) {
        var str = $(item).context.getAttribute("data");
        str = str.split("_")
        tuliDiv(false, str[0])
    })
    $.each($(".wurandikuai .sub_menu input"), function (i, item) {
        var str = $(item).context.getAttribute("data");
        str = str.split("_")
        tuliDiv(false, str[0])
    })
}


/**
 * 基础地理下的图例添加与删除  
 * @param flg
 * @param name
 */
function tuliDiv(flg, name) {
    if (flg) {
        var src = "";
        var size = '';
        if (user.suLevel == "3") { // 县级用户
        	addfenbututuli(name);
        } else {
        	if (dong.ztorfb == "专题图") {
                if (name == "污染地块" || name == "重点行业监管企业" || name == "建设用地准入" || name == "农用地") {
                    if (name == "污染地块") src = "../../img/information/chang.png";
                    else src = "../../img/information/number.png";
                    size = 'style="width:24px;height:24px;"'
                    var html = '<div class="row no-margin" style="color:#fff"  data = "' + name + '"><div class="row no-margin"><div class="col-lg-12 col-md-12 col-sm-12">' + name + '</div></div><div class="row no-margin" style="margin-left: 35px !important;"><div class="col-lg-7 col-md-7 col-sm-7" style="line-height:45px;">0-9</div>' +
                        '<div class="col-lg-5 col-md-5 col-sm-5 text-center"  style="height:24px;"> <img src="' + src + '" style="width:40px;height:40px;margin-top: -28px;" /></div></div><div class="row no-margin" style="margin-left: 35px !important;"><div class="col-lg-7 col-md-7 col-sm-7" style="line-height:50px;">10-99</div>' +
                        '<div class="col-lg-5 col-md-5 col-sm-5 text-center" style="height:30px;"> <img src="' + src + '" style="width:45px;height:45px;margin-top: -24px;" /></div></div><div class="row no-margin" style="margin-left: 35px !important;"><div class="col-lg-7 col-md-7 col-sm-7" style="line-height:55px;">100-999</div>' +
                        '<div class="col-lg-5 col-md-5 col-sm-5 text-center"  style="height:40px;"> <img src="' + src + '" style="width:50px;height:50px;margin-top: -12px;" /></div></div><div class="row no-margin" style="margin-left: 35px !important;"><div class="col-lg-7 col-md-7 col-sm-7" style="line-height:60px;">1000-999</div>' +
                        '<div class="col-lg-5 col-md-5 col-sm-5 text-center"> <img src="' + src + '" style="width:50px;height:50px;" /></div></div><div class="row no-border no-margin" style="margin-left: 35px !important;"><div class="col-lg-7 col-md-7 col-sm-7" style="line-height:65px;">10000-9999</div>' +
                        '<div class="col-lg-5 col-md-5 col-sm-5 text-center"> <img src="' + src + '" style="width:60px;height:60px;" /></div></div>' +
                        '</div>';
                    $(".tuli").html(html);
                }
            } else if (dong.ztorfb = "分布图") {
            	addfenbututuli(name);
            } 
        }
        if (name == "省级行政界线") {
            src = "../../img/tuli/sheng.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "市级行政界线") {
            src = "../../img/tuli/shi.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "县级行政界线") {
            src = "../../img/tuli/xian.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "土地利用") {
            src = "../../img/tuli/tudiliyong.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "河流") {
            src = "../../img/tuli/heliu.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "道路") {
            src = "../../img/tuli/daolu.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "土壤类型") {
            src = "../../img/tuli/turangleixing.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "大型灌区分布") {
            src = "../../img/tuli/guanqu.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "人口分布") {
            src = "../../img/tuli/renkoufenbu.png";
            size = "";
            addTuli(name, src, size)
        } else if (name == "公里网格") {
            src = "../../img/tuli/gongliwangge.png"
            size = "";
            addTuli(name, src, size)
        }
    } else {
        $(".tuli").html("")
    }
}
function addfenbututuli(name) {
	size = 'style="width:24px;height:24px;"'
        if (name == "污染地块" || name == "重点行业监管企业" || name == "建设用地准入" || name == "农用地") {
            if (name == "重点监管企业遥感核查") src = "../../img/dian/yaoganhecha.png";
            else if (name == "污染地块") src = "../../img/dian/wurandikuai.png";
            else if (name == "农用地") src = "../../img/dian/nongyongdi.png";
            else if (name == "建设用地准入") src = "../../img/dian/jianshe.png";
            else if (name == "重点行业监管企业") src = "../../img/dian/zhongdianhangye.png";
            addTuli(name, src, size)
        }
}
/**
 * 添加图例
 * @param name
 * @param src
 * @param size
 */
function addTuli(name, src, size) {
    var html = '<div class="row no-margin"  style="color:#fff"data = "' + name + '"><div class="col-lg-12 col-md-12 col-sm-12">' + name + '</div><div class="col-lg-12 col-md-12 col-sm-12 p5_30"> <img src="' + src + '" ' + size + '></img></div></div>';
    $(".tuli").html(html + $(".tuli").html());
}


/**
 * 清除 上次记录-专题图
 */
function qingZhuanti() {
    removeTc("countLayer");
    removeTc("diangraphicsLayer");
    removeTc("diangraphicsLayer");
    removeGraphic("provinceHigh");
    removeFujin();
}


/**
 * 设置县代码
 */
function setCountyCode() {
    dong.xianCode = $("#county").val();
}

/**
 * 工具条表格事件
 */
function toolTableFuntion() {
    $('#tongjituDiv  .large').click(function () {
        if ($(this).attr('data') == 1) {
            $('#tongjituDiv ').css({
                top: 0,
                right: 0,
                left: 0,
                width: '100%',
                height: '97%',
            })
            $("#tongjituDiv  .table-title").css({
                top: '0px',
                right: 0,
                left: 0,
                width: '100%'
            })
            $(this).css('background-image', 'url(../../img/information/min_big.png)')
            $('#tongjituDiv  .table-body').css('width', '98%')
            $('#tongjituDiv  .table-body').css('height', '88%')
            $('#tongjituDiv  .table-body table').css('width', '100%')
            $('#tongjituDiv  .table-body table').css('height', 'auto')
            $(this).attr('data', '2')
        } else {
            $(this).attr('data', '1')
            $('#tongjituDiv').css({
                top: '116px',
                right: '79px',
                left: 'auto',
                width: '550px',
                height: 'auto',
            })
            $("#tongjituDiv  #main_tabletitle").css({
                top: '116px',
                right: '79px',
                left: 'auto',
                width: '550px',
            })
            $(this).css('background-image', 'url(../../img/information/max_big.png)')
            $('#tongjituDiv  #main_tabletitle').addClass('main_tabletitle1')
            $('#tongjituDiv  .table-body').css('width', '98%')
            $('#tongjituDiv  .table-body').css('height', '88%')
            $('#tongjituDiv  .table-body table').css('width', '100%')
            $('#tongjituDiv  .table-body table').css('height', 'auto')
        }

    })
    //关闭统计表
    $("#tongjituDiv  .switch").click(function () {
        $("#tongjituDiv").hide();
        if ($($('.map_representation>li')[4]).hasClass("repres_active")) {
            $($('.map_representation>li')[4]).removeClass("repres_active");
        }
    })
    $("#tongjituDiv_2  .switch").click(function () {
        $("#tongjituDiv_2").hide();
    })
}
/**
 * 纬度度转墨卡托
 * @param x
 */
function handle_x(x) {
    return (x / 180.0) * 20037508.34;
}

/**
 * 纬度度转墨卡托
 * @param y
 */
function handle_y(y) {
    if (y > 85.05112) {
        y = 85.05112;
    }
    if (y < -85.05112) {
        y = -85.05112;
    }
    y = (Math.PI / 180.0) * y;
    var tmp = Math.PI / 4.0 + y / 2.0;
    return 20037508.34 * Math.log(Math.tan(tmp)) / Math.PI;
}

/**
 * 表格高亮
 */
function tableHight(id, num) {//0高亮 1 删除高亮
    if (num == "0") {//高亮
        $('#' + id).css("background", "#c0d5e8");
    } else if (num == "1") {//移除高亮
        $('tbody tr').css("background", "none")
    }
}



/**
 * 鼠标划过表格
 * @param url
 */
function changBkColor(url) {
    $('#tongjituDiv tbody tr').hover(function () {
        var dians = $(this).children('td:eq(0)').text();
        var dian = dians.split(",")
        var lon = dian[0];
        var lat = dian[1];
        $(this).css("background", "#c0d5e8")
        removeTc("messageHeightayer");
        app.messageHeightayer = new dong.GraphicsLayer({ id: "messageHeightayer" });
        app.map.addLayer(app.messageHeightayer);
        var pointSymbol = new dong.PictureMarkerSymbol(url, 45, 45);
        pointSymbol.setOffset(0, 16);
        var point = new dong.Point(lon, lat, new dong.SpatialReference({ wkid: 102100 }));
        var graphic = new dong.Graphic(point, pointSymbol, "", "");
        app.messageHeightayer.add(graphic);
    }, function () {
        removeTc("messageHeightayer");
        $('#tongjituDiv tbody tr').css("background", "none")
    });
}



/**
 * 清除type属性值为value的graphic
 */
function removeGraphic(value) {
    var graphics = app.map.graphics.graphics;
    for (var i = 0; i < graphics.length; i++) {
        if (graphics[i].attributes && graphics[i].attributes.type && graphics[i].attributes.type == value) {
            app.map.graphics.remove(graphics[i]);
        }
    }
}


/**
 * 删除图层
 */
function removeTc(id) {
    try {
        app.map.removeLayer(app.map.getLayer(id))
    } catch (e) {

    }
}
//划线 清除上一次记录
function doMeasure(geometry) {
    //更加类型设置显示样式
    measuregeometry = geometry;
    toolbar.deactivate();
    switch (geometry.type) {
        case "polyline":
            var symbol = new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_SOLID, new dong.Color([0, 0, 0]), 2);
            break;
        case "polygon":
            var symbol = new dong.SimpleFillSymbol(dong.SimpleFillSymbol.STYLE_NONE, new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_DASHDOT, new dong.Color([255, 0, 0]), 2), new dong.Color([255, 255, 0, 0.25]));
            break;
    }
    //设置样式
    var graphic = new dong.Graphic(geometry, symbol);

    //清除上一次的画图内容
    //map.graphics.clear();
    app.map.infoWindow.hide();

    //app.map.graphics.clear();
    app.map.graphics.add(graphic);
    // geometryService.project([graphic],new esri.SpatialReference({"wkid":32618}));
    //map.graphics.add(graphic);
    //进行投影转换，完成后调用projectComplete
    MeasureGeometry(geometry);
}
//判断是线还是面
function MeasureGeometry(geometry) {
    dong.measure = false; // 测量完成后设置测量状态为false
    //如果为线类型就进行lengths距离测算
    if (geometry.type == "polyline") {
        var lengthParams = new dong.LengthsParameters();
        lengthParams.polylines = [geometry];
        lengthParams.lengthUnit = dong.GeometryService.UNIT_METER;
        lengthParams.geodesic = true;
        lengthParams.polylines[0].spatialReference = new dong.SpatialReference(102100);

        app.geometryService.lengths(lengthParams);
        dojo.connect(app.geometryService, "onLengthsComplete", outputDistance);
    }
    //如果为面类型需要先进行simplify操作在进行面积测算
    else if (geometry.type == "polygon") {
        var areasAndLengthParams = new dong.AreasAndLengthsParameters();
        areasAndLengthParams.lengthUnit = dong.GeometryService.UNIT_METER;
        areasAndLengthParams.areaUnit = dong.GeometryService.UNIT_SQUARE_METERS;
        this.outSR = new dong.SpatialReference({ wkid: 102113 });
        app.geometryService.project([geometry], this.outSR, function (geometry) {
            app.geometryService.simplify(geometry, function (simplifiedGeometries) {
                areasAndLengthParams.polygons = simplifiedGeometries;
                areasAndLengthParams.polygons[0].spatialReference = new dong.SpatialReference(102100);
                app.geometryService.areasAndLengths(areasAndLengthParams);
            });
        });
        dojo.connect(app.geometryService, "onAreasAndLengthsComplete", outputAreaAndLength);
    }
}
//距离测量
function outputDistance(result) {
    var CurX = measuregeometry.paths[0][measuregeometry.paths[0].length - 1][0];
    var CurY = measuregeometry.paths[0][measuregeometry.paths[0].length - 1][1];
    var CurPos = new dong.Point(CurX, CurY, new dong.SpatialReference({ wkid: 102100 }));
    app.map.infoWindow.setTitle("距离测量");
    
    if (result.lengths[0] > 1000) {
    	app.map.infoWindow.setContent(" 测量长度 ： <strong>" + parseInt(String(result.lengths[0]/1000)) + "千米</strong>");	
    } else {
    	app.map.infoWindow.setContent(" 测量长度 ： <strong>" + parseInt(String(result.lengths[0])) + "米</strong>");
    }
    app.map.infoWindow.show(CurPos);
    app.map.infoWindow.resize("200", "100");
    // $(".window_table .window_rt").css ("margin-top","-30px");
    $(".dextra-bubble-pop-content").css("overflow-x", "hidden")
    $(".close").click(function () {
        app.map.infoWindow.remove();
    })

}
//显示测量面积
function outputAreaAndLength(result) {
    var extent = measuregeometry.getExtent(); //获取查找区域的范围
    var center = measuregeometry.getCentroid();  //获取查询区域的中心点
    var cPoint = new dong.Point([center.x, center.y], new dong.SpatialReference({ wkid: 102100 }));
    app.map.infoWindow.setTitle("面积测量");
    if (result.areas[0] > 1000) {
    	app.map.infoWindow.setContent("<p style='margin-bottom: 10px;'>面积：<strong>" + parseInt(String(result.areas[0]/1000000)) + "平方千米</strong></p><p>周长：" + parseInt(String(result.lengths[0])) + "米</p>");	
    } else {
    	app.map.infoWindow.setContent("<p style='margin-bottom: 10px;'>面积：<strong>" + parseInt(String(result.areas[0])) + "平方米</strong></p><p>周长：" + parseInt(String(result.lengths[0])) + "米</p>");
    }
    app.map.infoWindow.show(cPoint);
    app.map.infoWindow.resize("200", "100");
    $(".windowTitle").css("width", "70%");
    $(".esriPopup .titleButton.close").css("margin-left", "25px")
    $(".close").click(function () {
        app.map.infoWindow.remove();
    })
}

/**
 * 双击表格定位
 * @param lon
 * @param lat
 */
function ondbclickDingwei(lon, lat) {
    var centerPoint = new dong.Point(handle_x(lon), handle_y(lat), new dong.SpatialReference({ wkid: 102100 }));
    app.map.centerAndZoom(centerPoint, 15);
}
/*********************************************************图层目录、条件查询查询窗口及初始化下拉框数据查询***************************************************/
/**
 * 查询框
 * @param num
 * @param evet
 */
function opernModal(num, evet) {
    dong.measure = false;
    var flg = false;
    $.each($($(evet).parent())[0].childNodes, function (i, item) {
        if ($(item).context.nodeName == "INPUT") {
            if (!$($(evet).parent())[0].childNodes[i].checked) {
                flg = true;
                toastr.warning("请先选中该项")
            }
        }
    })
    if (flg) return;
    $("#myModal").show();
    if (num == "1") {
        $("#myModal #myModalLabel").html("污染地块条件查询")
        $('.info_wrdks').show();
        $('.nongyongdi').hide();
        $('.info_jsyd').hide();
        $('.zhongdianyangye').hide();
    } else if (num == "8") {
        $("#myModal #myModalLabel").html("重点行业企业条件查询")
        $('.info_wrdks').hide();
        $('.nongyongdi').hide();
        $('.info_jsyd').hide();
        $('.zhongdianyangye').show();
    } else if (num == "12") {
        $('.info_wrdks').hide();
        $('.nongyongdi').show();
        $('.info_jsyd').hide();
        $('.zhongdianyangye').hide();
    } else if (num == "14") {
        $("#myModal #myModalLabel").html("建设用地准入条件查询")
        $('.info_wrdks').hide();
        $('.nongyongdi').hide();
        $('.info_jsyd').show();
        $('.zhongdianyangye').hide();
    }
}
/**
 * 获取重点行业行业类别下拉列表
 */
function getIndustryTypeOfkeyEnterprise() {
    ajaxPost("/cdsems/OneMapInitializationFun/selectIndustryType", {}).done(function (result) {
        var optHtml = '<option value="">全部</option>';
        if (result.status == 0) {
            var arrayInduType = result.data;
            for (var i = 0; i < arrayInduType.length; i++) {
                optHtml += '<option value="' + arrayInduType[i].INDUSTRYTYPE + '">' + arrayInduType[i].INDUSTRYTYPE + '</option>';
            }
        }
        $("#industry").html(optHtml);
    });
}
/**
 * 获取市下拉列表
 */
function getTbCiyt() {
    ajaxPost("/cdsems/city/getCountyByCityID", { tcId: "263" }).done(function (result) {
        var optHtml = '<option value="">全部</option>';
        if (result.status == 0) {
            var arrayCity = result.data;
            for (var i = 0; i < arrayCity.length; i++) {
                optHtml += '<option value="' + arrayCity[i].tcCode + '">' + arrayCity[i].tcName + '</option>';
            }
        }
        $("#county").html(optHtml);
    });
}
/**
 * 获取左侧目录
 */
function getLiftMenu() {
    ajaxPost("/cdsems/sys/yzt/listByPermission", {}).done(function (result) {
        if (result.status == 0) {
            var html = "";
            if (result.data) {
                var array = [];
                for (var i = 0; i < result.data.length; i++) {
                    array.push(result.data[i].syId);
                }
                if (array.includes(1)) {
                    html += '<li class="soilDl"><a href="javascript:void(0);"><i class="iconfont icon-bottom"></i><span>土壤污染来源</span></a>';
                    html += '<div class="sub_menu">';
                    if (array.includes(16)) {
                        html += '<div><div class="radio radio-info">'
                            + '<input type="radio" id="radio7" name="radio2" data="重点行业监管企业_8">'
                            + '<label for="radio7">重点行业企业</label>'
                            + '<i class="fa  fa-filter"  onclick="opernModal(8,this)"></i>'
                            + '</div></div>';
                    }

                    if (array.includes(29)) {
                    }
                    if (array.includes(31)) {
                        html += '<div><div class="radio radio-info">'
                            + '<input type="radio" id="radio9" name="radio2" data="建设用地准入_14">'
                            + '<label for="radio9">建设用地准入</label>'
                            + '<i class="fa  fa-filter" onclick="opernModal(14,this)"></i>'
                            + '</div></div>';
                    }

                    html += "</div></li>";


                }
                if (array.includes(2)) {
                    html += ' <li class="wurandikuai"><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>污染地块</span></a>';
                    html += '<div class="sub_menu freeH" >';
                    if (array.includes(17)) {
                    }
                    if (array.includes(18)) {
                        html += '<div><div class="radio radio-info">'
                            + '<input type="radio" id="checkbox9" name="radio2" data="污染地块_1">'
                            + '<label for="checkbox9">污染地块</label>'
                            + '<i class="fa  fa-filter"  onclick="opernModal(1,this)"></i>'
                            + '</div></div>';
                    }
                    html += '</div></li>';
                }
                if (array.includes(3)) {

                    html += ' <li class="nongyongdi"><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>农用地土壤环境质量</span></a>';
                    html += '<div class="sub_menu freeH" >';
                    if (array.includes(30)) {
                        html += '<div><div class="radio radio-info">'
                            + '<input type="radio" id="checkbox15" name="radio2" data="农用地_12">'
                            + '<label for="checkbox15">农用地</label>'
                            + '<i class="fa  fa-filter"  onclick="opernModal(12,this)"></i>'
                            + '</div></div>';
                    }
                    html += '</div></li>';
                }
                if (array.includes(4)) {
                    html += '<li><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>土壤环境例行监测</span></a></li>';
                }
                if (array.includes(5)) {
                    html += '<li><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>土壤环境调查</span></a></li>';
                }
                if (array.includes(6)) {
                    html += '<li class="kjwg"><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>空间网格</span></a>';
                    html += '<div class="sub_menu freeH" >';
                    if (array.includes(19)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="wg" name="wg" data="公里网格">'
                            + '<label for="wg">公里网格</label>'
                            + '</div></div>';
                    }
                    html += '</div></li>';
                }
                if (array.includes(7)) {
                    html += '<li><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>舆情数据</span></a></li>';
                }
                if (array.includes(8)) {
                    html += '<li class="basicDl"><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>基础地理</span></a>';
                    html += '<div class="sub_menu freeH" >';
                    if (array.includes(20)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox1" name="checkbox1" data="省级行政界线">'
                            + '<label for="checkbox1">省级行政界线</label>'
                            + '</div></div>';
                    }
                    if (array.includes(21)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox2" name="checkbox2" data="市级行政界线">'
                            + '<label for="checkbox2">市级行政界线</label>'
                            + '</div></div>';
                    }
                    if (array.includes(22)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox3" name="checkbox3" data="县级行政界线">'
                            + '<label for="checkbox3">县级行政界线</label>'
                            + '</div></div>';
                    }
                    if (array.includes(23)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox4" name="checkbox4" data="河流">'
                            + '<label for="checkbox4">河流</label>'
                            + '</div></div>';
                    }
                    if (array.includes(24)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox5" name="checkbox5" data="道路">'
                            + '<label for="checkbox5">道路</label>'
                            + '</div></div>';
                    }
                    if (array.includes(25)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox6" name="checkbox6" data="土地利用">'
                            + '<label for="checkbox6">土地利用</label>'
                            + '</div></div>';
                    }
                    if (array.includes(26)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox7" name="checkbox7" data="土壤类型">'
                            + '<label for="checkbox7">土壤类型</label>'
                            + '</div></div>';
                    }
                    html += '</div></li>';
                }
                if (array.includes(9)) {
                    html += '<li class="qita"><a href="javascript:void(0);" ><i class="iconfont icon-bottom"></i><span>其他</span></a>';
                    html += '<div class="sub_menu" >';
                    if (array.includes(27)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox12" name="checkbox12"  data="大型灌区分布">'
                            + '<label for="checkbox12">大型灌区分布</label>'
                            + '</div></div>';
                    }
                    if (array.includes(28)) {
                        html += '<div><div class="checkbox checkbox-info">'
                            + '<input type="checkbox" id="checkbox13" name="checkbox13" data="人口分布">'
                            + '<label for="checkbox13">人口分布</label>'
                            + '</div></div>';
                    }
                    html += '</div></li>';
                }
                //写入html
                $("#leftMenu").html(html);
                //菜单点击事件
                radioCheckedClick();
                //侧边栏菜单
                $(".list1>ul>li>a").click(function () {
                    if ($(this).hasClass("active")) {
                        $(this).removeClass("active").next(".sub_menu").slideUp(100);
                        $(this).children(".icon-bottom").css("transform", "rotateZ(-90deg)");
                    } else {
                        if ($(this).siblings().size() != 0) {
                            $(this).addClass("active").next(".sub_menu").slideDown(100);
                            $(this).children(".icon-bottom").css("transform", "rotateZ(0deg)");
                        }
                    }
                })
                //侧边栏其他菜单
                $(".others>ul>li>a").click(function () {
                    if ($(this).hasClass("active")) {
                        $(this).removeClass("active").next(".sub_menu").slideUp(100);
                        $(this).children(".icon-bottom").css("transform", "rotateZ(-90deg)");
                    } else {
                        if ($(this).siblings().size() != 0) {
                            $(this).addClass("active").next(".sub_menu").slideDown(100);
                            $(this).children(".icon-bottom").css("transform", "rotateZ(0deg)");
                        }
                    }
                })
                //主菜单切换
                $(".info_menuTip li").click(function () {
                    $(this).addClass("list_active").siblings(".info_menuTip li").removeClass("list_active");
                    $(".info_menuList").eq($(this).index()).show().siblings(".info_menuList").hide();
                })
            }
        }
    });
}
/**
 * 基础地理 - 添加图层或者移除图层
 * @param
 * @param 
 */
function tjTc(name, num) {//num ： 0 添加 1移除
    var data;
    $.each(tuceng, function (i, item) {
        if (item.name == name) {
            data = item;
        }
    })
    if (data.url == "") return;
    var id = "";
    if (name == "道路") {
        id = "daolu"
    } else {
        id = data.id;
    }
    var html = '<div class="row warning-element warnings" id="' + id + '" data="' + id + '">' +
        '<div class="col-sm-12" style="padding:0;line-height: 30px;">' +
        '   <i id="ss1" class="fa fa-eye fa-lg eye" checked="true" data="' + id + '"></i>' +
        '   <span style="cursor: move;">' + name + '</span>' +
        '   </div>' +
        '   <div class="col-sm-12 eyeSel" style="margin-left:19px;height: auto;line-height:50px">' +
        '       <div class="' + id + '" style="width:88%;height: 2px;margin-right: 20px;"></div>' +
        '   </div>' +
        '</div>';
    if (num == 0) {
        if (name == "道路") {
            var gaosuLayer = new dong.ArcGISDynamicMapServiceLayer(data.url[0], { id: "gaosuLayer" });
            var shengdaoLayer = new dong.ArcGISDynamicMapServiceLayer(data.url[1], { id: "shengdaoLayer" });
            app.map.addLayer(gaosuLayer);
            app.map.addLayer(shengdaoLayer);
        } else {
            app.map.addLayer(new dong.ArcGISDynamicMapServiceLayer(data.url, { id: data.id }));
        }
        $(".tool_hover").html(html + tckzHtml);
        huaDiv();
    } else if (num == 1) {
        if (name == "道路") {
            app.map.removeLayer(app.map.getLayer("gaosuLayer"));
            app.map.removeLayer(app.map.getLayer("shengdaoLayer"));
        } else {
            app.map.removeLayer(app.map.getLayer(data.id));
        }
        removeDiv(id);
    }
}
/*************************************************属性查询*************************************************************************/
// TODO 
var isAttributeSearch = false;
var mapClickEvent = null;
/**
 * 属性查询
 */
function startAttributeSearch() {
    dong.measure = false;
    if (isAttributeSearch) {
        mapClickEvent = app.map.on("click", dianPublic);//点选查询
        $("#attributesSearchLi").addClass("repres_active");
    } else {
        if (mapClickEvent) {
            mapClickEvent.remove();
            mapClickEvent = null;
            isAttributeSearch = false;
            $("#attributesSearchLi").removeClass("repres_active");
        }
    }
}
var startSearchLayerIndex = -1;//循环查询地图图形，开始索引
/**
 * 图层属性点选查询（通用）
 * @param event
 * @returns
 */
function dianPublic(event) {
    if (dong.measure) {
        return;
    }
    //第一次查询，初始化索引
    if (startSearchLayerIndex == -1) {
        startSearchLayerIndex = app.map.getLayersVisibleAtScale().length - 1;
    }
    var layer = app.map.getLayersVisibleAtScale()[startSearchLayerIndex];
    if (layer.layerInfos && layer.layerInfos.length > 0) {
        var point = event.mapPoint;
        var idpara = new dong.IdentifyParameters();
        idpara.returnGeometry = true;
        idpara.tolerance = 3;
        idpara.outFields = ["*"];
        idpara.geometry = point;
        idpara.width = app.map.width;
        idpara.height = app.map.height;
        idpara.mapExtent = app.map.extent;
        var identifyTask = dong.IdentifyTask(app.map.getLayersVisibleAtScale()[startSearchLayerIndex].url);
        identifyTask.execute(idpara, function (evt) {
            if (evt.length == 0) {
                if (startSearchLayerIndex == 0) {
                    //未查询到结果，索引恢复到默认值
                    startSearchLayerIndex = -1;
                    return;
                } else {
                    //无结果，进行下一次查询
                    startSearchLayerIndex--;
                    dianPublic(event);
                }
            } else {
                showDianClickResult(evt, event);
                //查询到结果，索引恢复到默认值
                startSearchLayerIndex = -1;
            }
        });
    } else {
        //图层类型不支持查询，不是Dynamic类型图层，进行下一次查询 
        if (startSearchLayerIndex == 0) {
            //未查询到结果，索引恢复到默认值
            startSearchLayerIndex = -1;
            return;
        } else {
            //无结果，进行下一次查询
            startSearchLayerIndex--;
            dianPublic(event);
        }
    }
}
/**
 * 属性查询结果
 * @param evt
 * @param event
 */
function showDianClickResult(evt, event) {
    //清除高亮
    yztRemoveGraByAttr("searchResultHigh", app.map.graphics);
    //添加高亮
    var feature = evt[0].feature;
    var symbol = null;
    if (evt[0].geometryType && evt[0].geometryType == "esriGeometryPolygon") {
        symbol = new dong.SimpleFillSymbol(dong.SimpleFillSymbol.STYLE_SOLID,
            new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_SOLID,
                new dong.Color([255, 0, 0]), 1),
            new dong.Color([0, 0, 0, 0.25])
        );
    }
    if (evt[0].geometryType && evt[0].geometryType == "esriGeometryPolyline") {
        symbol = new dong.SimpleLineSymbol(dong.SimpleLineSymbol.STYLE_SOLID,
            new dong.Color([255, 0, 0]), 1
        );
    }

    var attributes = {
        graType: 'searchResultHigh'
    }
    var geometry = feature.geometry;
    var gra = new dong.Graphic(geometry, symbol, attributes);
    app.map.graphics.add(gra);
    var html = "";
    var attributes = evt[0].feature.attributes;
    html += "<div class='row' style='max-height:350px;over-flow:auto;'>";
    for (var attrName in attributes) {
        //判断属性信息是否显示
        if (searchPar.deletePar.indexOf(attrName) == -1) {
            var columnName = attrName;
            if (searchPar.translatePar[columnName]) {
                columnName = searchPar.translatePar[columnName];
            }
            html += '<div class="row"><div class="col-sm-4 text-right">' + columnName + '：</div>'
                + '<div class="col-sm-8 text-left" >' + attributes[attrName] + '</div></div>';
        }
    }
    html += "</div>";
    mapinfoWindow2("信息", html, event);
    isAttributeSearch = false; // 查询出结果后设置属性查询为false
}
/**
 * 根据属性，删除图层中的graphics
 */
function yztRemoveGraByAttr(val, mapLayer) {
    var gras = mapLayer.graphics;
    for (var i = gras.length - 1; i >= 0; i--) {
        var gra = gras[i];
        var attrs = gra.attributes;
        if (attrs && attrs.graType && attrs.graType == val) {
            mapLayer.remove(gra);
        }
    }
}
/**
 * 属性查询字段翻译
 */
var searchPar = {
    deletePar: ["FID", "Shape", "E_NAME"],
    translatePar: {
        "AREA": "面积"
    },
    addPar: {

    }
}
/***************************************************************图层控制*********************************************************************/
/**
 * 图层控制按钮
 */
$("#tuceng").click(function () {
    var aaa = document.getElementById("tucengDiv").style.display;
    if (aaa == "none") {
        $("#tucengDiv").show();
        $("#meaDiv").hide();
        $("#toumingduDiv").hide();
    }
    else $("#tucengDiv").hide();

})
/**
 * 图层控制中的眼睛  显隐
 */
$('#tucengDiv').on('click', '.fa-lg', function () {
    var lid = $(this).attr("id");
    var ischeck = $(this).attr("checked");
    var fz = true;
    if (ischeck == "checked") {
        $(this).attr("checked", false);
        $(this).removeClass('fa-eye');
        $(this).addClass('fa-eye-slash');
        fz = true;
    } else {
        $(this).attr("checked", true);
        $(this).removeClass('fa-eye-slash');
        $(this).addClass('fa-eye');
        fz = false
    }
    if (lid == "ss2") {//基础地图
        eye("vectorLayer", fz);
    } else if (lid == "ss1") {//统计图层
        eye("countryFeatureLayer", fz);
    } else if (lid == "ss3") {//公里网格
        eye("gewangLayer", fz);
    } else if (lid == "ss4") {//影像图层
        eye("imageLayer", fz);
    } else if (lid == "ss5") {//道路图层
        eye("gaosuLayer", fz);
        eye("shengdaoLayer", fz);
    } else if (lid == "ss6") {//河流图层
        eye("riverLayer", fz);
    } else if (lid == "ss7") {//加油站图层
        eye("gasLayer", fz);
    } else if (lid == "ss8") {//中文注记
        eye("vectorNoteLayer", fz);
        eye("annoLayer", fz);
    } else if (lid == "ss9") app.map.getLayersVisibleAtScale()[2].setVisibility(!fz);
});
/**
 * 图层控制中的眼睛  显隐
 */
$('.tool_hover').on('click', '.fa-lg', function () {
    var data = "";
    // var lid = $(this).attr("id");
    var ischeck = $(this).attr("checked");
    var fz = true;

    if (ischeck == "checked") {
        data = $(this).context.getAttribute("data");
        $(this).attr("checked", false);
        $(this).removeClass('fa-eye');
        $(this).addClass('fa-eye-slash');
        fz = true;

    } else {
        data = $(this).context.getAttribute("data");
        $(this).attr("checked", true);
        $(this).removeClass('fa-eye-slash');
        $(this).addClass('fa-eye');
        fz = false
    }
    if (data == "daolu") {
        eye("gaosuLayer", fz);
        eye("shengdaoLayer", fz);
    } else if (data == "gongliwangge") {
        if (fz) {
            app.grideGraphicLayer.setOpacity(0.0);
            app.wanggeLayer.setOpacity(0.0);
        } else {
            app.grideGraphicLayer.setOpacity(1);
            app.wanggeLayer.setOpacity(1);
        }
        eye("gaosuLayer", fz);
        eye("shengdaoLayer", fz);
    } else if (data == "xzjj") {
        eye("ssheng", fz);
        eye("sshi", fz);
        eye("sxian", fz);
    } else {
        eye(data, fz);
    }
});
/**
 * 图层显示与隐藏的通用方法
 * @param id 图层id
 * @param fz 是否设置透明度为0
 */
function eye(id, fz) {
    try {
        var layer = app.map.getLayer(id);
        if (fz) layer.setOpacity(0.0);
        else layer.setOpacity(1);
    } catch (e) {

    }
}
/*************************************************地图等待及地图窗口操作****************************************************************/
/**
 * 等待框显示
 */
function dengdai() {
    var _PageHeight = document.documentElement.clientHeight,
        _PageWidth = document.documentElement.clientWidth;
    //计算loading框距离顶部和左部的距离（loading框的宽度为215px，高度为61px）
    var _LoadingTop = _PageHeight > 61 ? (_PageHeight - 61) / 2 : 0,
        _LoadingLeft = _PageWidth > 215 ? (_PageWidth - 215) / 2 : 0;
    //在页面未加载完毕之前显示的loading Html自定义内容
    var _LoadingHtml = '<div id="loadingDiv" style="position:absolute;left:0;width:100%;height:' + _PageHeight + 'px;top:0;background:rgba(0,0,0,.2);z-index:10000;"><div style="position: absolute; cursor1: wait; left: 50%; top:' + _LoadingTop + 'px; width: auto; height: 45px; line-height: 45px; padding-left: 45px; padding-right: 15px; background: #fff url(img/loading.gif) no-repeat scroll 15px 15px; color: #333; font-family:\'Microsoft YaHei\';font-size: 18px;border-radius:6px;transform:translateX(-50%)">请等待...</div></div>';
    //呈现loading效果
    $("#yc").html(_LoadingHtml)
}
/**
 * 删除等待框
 */
function removeDengdai() {
    $("#loadingDiv").remove();
}

/**
 * 地图弹出框
 * @param name
 * @param html
 * @param evt
 */
function mapinfoWindow(name, html, evt) {
    app.map.infoWindow.setTitle(name);
    app.map.infoWindow.setContent(html);
    var lon, lat;
    if (evt.graphic == undefined) {
        lon = evt.mapPoint.x;
        lat = evt.mapPoint.y;
    } else {
        lon = evt.graphic.geometry.x;
        lat = evt.graphic.geometry.y;
    }
    var centerPoint = new dong.Point(lon, lat, new dong.SpatialReference({ wkid: 102100 }));
    $(".dextra-bubble-pop").addClass("infoBubble-pop");
    $(".anniu").css("margin-left", "100px");
    app.map.infoWindow.show(centerPoint);
    $(".window_table .close").click(function () {
        app.map.infoWindow.remove();
        removeTc("wrdkcentral");
    })
    var extentPar = {
        "xmin": lon, "ymin": lat, "xmax": lon, "ymax": lat,
        "spatialReference": { "wkid": 102100 }
    }
    app.map.setExtent(new dong.Extent(extentPar));
}
/**
 * 地图弹出框 属性查询弹出框
 * @param name
 * @param html
 * @param evt
 */
function mapinfoWindow2(name, html, evt) {
    app.map.infoWindow.setTitle(name);
    app.map.infoWindow.setContent(html);
    var centerPoint = evt.mapPoint;
    $(".dextra-bubble-pop").addClass("infoBubble-pop");
    $(".anniu").css("margin-left", "100px");
    app.map.infoWindow.show(centerPoint);
    $(".window_table .close").click(function () {
        app.map.infoWindow.remove();
        yztRemoveGraByAttr("searchResultHigh", app.map.graphics);
    })
}
/**
 * 地图向左展开
 */
function toggleBar() {
    if ($("#toggle-sidebar").attr("title") == "展开菜单") {
        $(".information .info-left").width("260px");
        $("#toggle-sidebar").attr("title", "收起菜单");
        $(".infor-maps").removeClass("toggles");
        $("#toggle-sidebar").removeClass("toggleBar-left");
        $("#toggle-sidebar2").hide();
    } else {
        $(".information .info-left").width("0");
        $("#toggle-sidebar").attr("title", "展开菜单");
        $(".infor-maps").addClass("toggles");
        $("#toggle-sidebar").addClass("toggleBar-left")
        
        if (dong.ztorfb == "分布图") {
        	$("#toggle-sidebar2").attr("title", "展开菜单");
            $(".information .toggleInfo").width("0");
            $("#toggle-sidebar2").addClass("toggleBar-right")
            $(".infor-map").addClass("toggles2");
            $("#toggle-sidebar2").hide();
        } else {
        	$("#toggle-sidebar2").attr("title", "收起菜单");
            $(".information .toggleInfo").width("260px");
            $("#toggle-sidebar2").removeClass("toggleBar-right")
            $(".infor-map").removeClass("toggles2");
            $("#toggle-sidebar2").show();
        }
        
    }
}
function toggleBar2() {
    if ($("#toggle-sidebar2").attr("title") == "展开菜单") {
        $("#toggle-sidebar2").attr("title", "收起菜单");
        $(".information .toggleInfo").width("260px");
        $("#toggle-sidebar2").removeClass("toggleBar-right")
        $(".infor-map").removeClass("toggles2");
    } else {
        $("#toggle-sidebar2").attr("title", "展开菜单");
        $(".information .toggleInfo").width("0");
        $("#toggle-sidebar2").addClass("toggleBar-right")
        $(".infor-map").addClass("toggles2");
    }

}
/*****************************************************拖拽--start******************************************************/
//#tongjituDiv	
var $div = $("#tongjituDiv .table-title");
/* 绑定鼠标左键按住事件 */
$div.bind("mousedown", function (event) {
    if ($('#tongjituDiv .large').attr('data') == 1) {
        /* 获取需要拖动节点的坐标 */
        var offset_x = $(this)[0].offsetLeft;//x坐标
        var offset_y = $(this)[0].offsetTop;//y坐标
        /* 获取当前鼠标的坐标 */
        var mouse_x = event.pageX;
        var mouse_y = event.pageY;
        /* 绑定拖动事件 */
        /* 由于拖动时，可能鼠标会移出元素，所以应该使用全局（document）元素 */
        $(document).bind("mousemove", function (ev) {
            /* 计算鼠标移动了的位置 */
            var _x = ev.pageX - mouse_x;
            var _y = ev.pageY - mouse_y;
            /* 设置移动后的元素坐标 */
            var now_x = (offset_x + _x) + "px";
            var now_y = (offset_y + _y) + "px";
            /* 改变目标元素的位置 */
            if (now_y < 0) {
                now_y = 0
            }
            $div.css({
                top: now_y,
                left: now_x
            });
            $('#tongjituDiv').css({
                top: now_y,
                left: now_x
            });
        });
    } else {
        return;
    }
});
/* 当鼠标左键松开，接触事件绑定 */
$(document).bind("mouseup", function () {
    var top = $div.css('top').split('px')
    var left = $div.css('left').split('px')
    if (top[0] < 0) {
        $div.css('top', '5%')
        $('#tongjituDiv').css('top', '5%')
    }
    if (left[0] < 0) {
        $div.css('left', '10px')
        $('#tongjituDiv').css('left', '10px')
    }
    $(this).unbind("mousemove");
});
$(document).bind("mouseup", function () {
    $(this).unbind("mousemove");
});

/*敏感点分布表格拖动*/
var $div2 = $("#info_table1");
/* 绑定鼠标左键按住事件 */
$div2.bind("mousedown", function (event) {
    if ($('#info_table1 .large').attr('data') == 1) {
        /* 获取需要拖动节点的坐标 */
        var offset_x = $(this)[0].offsetLeft;//x坐标
        var offset_y = $(this)[0].offsetTop;//y坐标
        /* 获取当前鼠标的坐标 */
        var mouse_x = event.pageX;
        var mouse_y = event.pageY;
        /* 绑定拖动事件 */
        /* 由于拖动时，可能鼠标会移出元素，所以应该使用全局（document）元素 */
        $(document).bind("mousemove", function (ev) {
            /* 计算鼠标移动了的位置 */
            var _x = ev.pageX - mouse_x;
            var _y = ev.pageY - mouse_y;
            /* 设置移动后的元素坐标 */
            var now_x = (offset_x + _x) + "px";
            var now_y = (offset_y + _y) + "px";
            /* 改变目标元素的位置 */
            if (now_y < 0) {
                now_y = 0
            }
            $div2.css({
                top: now_y,
                left: now_x
            });
            $('#info_table1').css({
                top: now_y,
                left: now_x
            });
        });
    } else {
        return;
    }
});

var $div_2 = $("#tongjituDiv_2 .table-title");
/* 绑定鼠标左键按住事件 */
$div_2.bind("mousedown", function (event) {
    if ($('#tongjituDiv_2 .large').attr('data') == 1) {
        /* 获取需要拖动节点的坐标 */
        var offset_x = $(this)[0].offsetLeft;//x坐标
        var offset_y = $(this)[0].offsetTop;//y坐标
        /* 获取当前鼠标的坐标 */
        var mouse_x = event.pageX;
        var mouse_y = event.pageY;
        /* 绑定拖动事件 */
        /* 由于拖动时，可能鼠标会移出元素，所以应该使用全局（document）元素 */
        $(document).bind("mousemove", function (ev) {
            /* 计算鼠标移动了的位置 */
            var _x = ev.pageX - mouse_x;
            var _y = ev.pageY - mouse_y;
            /* 设置移动后的元素坐标 */
            var now_x = (offset_x + _x) + "px";
            var now_y = (offset_y + _y) + "px";
            /* 改变目标元素的位置 */
            if (now_y < 0) {
                now_y = 0
            }
            $div_2.css({
                top: now_y,
                left: now_x
            });
            $('#tongjituDiv_2').css({
                top: now_y,
                left: now_x
            });
        });
    } else {
        return;
    }
});
/* 当鼠标左键松开，接触事件绑定 */
$(document).bind("mouseup", function () {
    var top = $div.css('top').split('px')
    var left = $div.css('left').split('px')
    if (top[0] < 0) {
    	$div_2.css('top', '5%')
        $('#tongjituDiv_2').css('top', '5%')
    }
    if (left[0] < 0) {
    	$div_2.css('left', '10px')
        $('#tongjituDiv_2').css('left', '10px')
    }
    $(this).unbind("mousemove");
});
$(document).bind("mouseup", function () {
    $(this).unbind("mousemove");
});



/* 当鼠标左键松开，接触事件绑定 */
$(document).bind("mouseup", function () {
    var top = $div2.css('top').split('px')
    var left = $div2.css('left').split('px')
    if (top[0] < 0) {
        $div2.css('top', '5%')
        $('#info_table1').css('top', '5%')
    }
    if (left[0] < 0) {
        $div2.css('left', '10px')
        $('#info_table1').css('left', '10px')
    }
    $(this).unbind("mousemove");
});



/**
 * 天地图矢量
 */
function tianShi() {
    $(".tool_hover").each(function (i, item) {
        for (var a = 0; a < $(item).context.children.length; a++) {
            if ($(item).context.children[a].getAttribute("data") == "annoLayerImg" || $(item).context.children[a].getAttribute("data") == "baseLayer") {//影像
                $($(item).context.children[a]).hide();
            } else if ($(item).context.children[a].getAttribute("data") == "vectorNoteLayer" || $(item).context.children[a].getAttribute("data") == "vectorLayer") {//矢量
                $($(item).context.children[a]).show();
            } else if ($(item).context.children[a].getAttribute("data") == "layer0") {//谷歌
                $($(item).context.children[a]).hide();
            }
        }
    });
    if (app.map.getLayer("layer0") != null && app.map.getLayer("layer0") != undefined && app.map.getLayer("layer0") != "") {
        app.map.getLayer("layer0").setOpacity(0.0);
    }
    if (app.baseLayerImg != "" && app.baseLayerImg != undefined && app.baseLayerImg != undefined) {
        app.map.getLayer("baseLayer").setOpacity(0.0);
    }
    if (app.annoLayerImg != "" && app.annoLayerImg != undefined && app.annoLayerImg != null) {
        app.map.getLayer("annoLayerImg").setOpacity(0.0);
    }
    app.map.getLayer("vectorLayer").setOpacity(1);
    app.map.getLayer("vectorNoteLayer").setOpacity(1);
    paixu();
}
/**
 * 天地图影像
 */
function tianYing() {
    $(".tool_hover").each(function (i, item) {
        for (var a = 0; a < $(item).context.children.length; a++) {
            if ($(item).context.children[a].getAttribute("data") == "annoLayerImg" || $(item).context.children[a].getAttribute("data") == "baseLayer") {//影像
                $($(item).context.children[a]).show();
            } else if ($(item).context.children[a].getAttribute("data") == "vectorNoteLayer" || $(item).context.children[a].getAttribute("data") == "vectorLayer") {//矢量
                $($(item).context.children[a]).hide();
            } else if ($(item).context.children[a].getAttribute("data") == "layer0") {//谷歌
                $($(item).context.children[a]).hide();
            }
        }
    });
    //谷歌
    if (app.map.getLayer("layer0") != null && app.map.getLayer("layer0") != undefined && app.map.getLayer("layer0") != "") {
        app.map.getLayer("layer0").setOpacity(0.0);
    }
    //矢量
    if (app.baseLayer != null && app.baseLayer != undefined && app.baseLayer != "") {
        app.map.getLayer("vectorLayer").setOpacity(0.0);
    }
    if (app.annoLayer != null && app.annoLayer != undefined && app.annoLayer != "") {
        app.map.getLayer("vectorNoteLayer").setOpacity(0.0);
    }
    //影像
    if (app.baseLayerImg != "" && app.baseLayerImg != undefined && app.baseLayerImg != undefined) {
        app.map.getLayer("baseLayer").setOpacity(1);
    } else {
        app.baseLayerImg = new dong.TianDiTuLayer(dong.TianDiTuLayer.IMG_BASE_WEBMERCATOR, { id: "baseLayer" });//影像
        app.map.addLayer(app.baseLayerImg);
        app.map.getLayer("baseLayer").setOpacity(1);
    }
    if (app.annoLayerImg != "" && app.annoLayerImg != undefined && app.annoLayerImg != null) {
        app.map.getLayer("annoLayerImg").setOpacity(1);
    } else {
        app.annoLayerImg = new dong.TianDiTuLayer(dong.TianDiTuLayer.IMG_ANNO_WEBMERCATOR, { id: "annoLayerImg" });//中文注记
        app.map.addLayer(app.annoLayerImg);
        app.map.getLayer("annoLayerImg").setOpacity(1);
    }
    paixu();
}
/**
 * 谷歌影像
 */
function googleYing() {
    $(".tool_hover").each(function (i, item) {
        for (var a = 0; a < $(item).context.children.length; a++) {
            if ($(item).context.children[a].getAttribute("data") == "annoLayerImg" || $(item).context.children[a].getAttribute("data") == "baseLayer") {//影像
                $($(item).context.children[a]).hide();
            } else if ($(item).context.children[a].getAttribute("data") == "vectorNoteLayer" || $(item).context.children[a].getAttribute("data") == "vectorLayer") {//矢量
                $($(item).context.children[a]).hide();
            } else if ($(item).context.children[a].getAttribute("data") == "layer0") {//谷歌
                $($(item).context.children[a]).show();
            }
        }
    });
    //矢量
    if (app.baseLayer != null && app.baseLayer != undefined && app.baseLayer != "") {
        app.map.getLayer("vectorLayer").setOpacity(0.0);
    }
    if (app.annoLayer != null && app.annoLayer != undefined && app.annoLayer != "") {
        app.map.getLayer("vectorNoteLayer").setOpacity(0.0);

    }
    //影像
    if (app.baseLayerImg != "" && app.baseLayerImg != undefined && app.baseLayerImg != undefined) {
        app.map.getLayer("baseLayer").setOpacity(0.0);
    }
    if (app.annoLayerImg != "" && app.annoLayerImg != undefined && app.annoLayerImg != null) {
        eye("annoLayerImg", true);
        app.map.getLayer("annoLayerImg").setOpacity(0.0);
    }

    if (app.map.getLayer("layer0") != null && app.map.getLayer("layer0") != undefined && app.map.getLayer("layer0") != "") {
        app.map.getLayer("layer0").setOpacity(1);
    } else {
        createGoogleLayer();
        app.map.addLayer(new GoogleMapLayer());
        app.map.getLayer("layer0").setOpacity(1);
    }
    paixu();
}

/**
 * 排序
 */
function paixu() {
    var layerSortArr = [];
    var itemCount = $(".warning-element").length;
    $(".warning-element").each(function (i, item) {
        if (item.getAttribute("data") == "gaosuLayer-shengdaoLayer") {
            var tempObj = { layer: app.map.getLayer("gaosuLayer"), index: itemCount - 1 - i };
            var tempObj1 = { layer: app.map.getLayer("shengdaoLayer"), index: itemCount - 1 - i };
            layerSortArr.push(tempObj);
            layerSortArr.push(tempObj1);
        } else if (item.getAttribute("data") == "googleLayer") {
            var tempObj = { layer: app.map.getLayersVisibleAtScale()[2], index: itemCount - 1 - i };
            layerSortArr.push(tempObj);
        } else {
            var tempObj = { layer: app.map.getLayer(item.getAttribute("data")), index: itemCount - 1 - i };
            layerSortArr.push(tempObj);
        }
    });
    resortMapLayers(layerSortArr);//重排序图层
}

//谷歌影像
function createGoogleLayer(){
    //影像图层
    dojo.declare("GoogleMapLayer", esri.layers.TiledMapServiceLayer, { // create WMTSLayer by extending esri.layers.TiledMapServiceLayer
        constructor: function(){
            this.spatialReference = new esri.SpatialReference({
                wkid: 102113
            });
            this.initialExtent = new esri.geometry.Extent(-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787, this.spatialReference);
            this.fullExtent = new esri.geometry.Extent(-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787, this.spatialReference);
            //
            this.tileInfo = new esri.layers.TileInfo({
                "dpi": "90.71428571427429",
                "format": "image/png",
                "compressionQuality": 0,
                "spatialReference": {
                    "wkid": "3857"
                },
                "rows": 256,
                "cols": 256,
                "origin": {
                    "x": -20037508.342787,
                    "y": 20037508.342787
                },

                // Scales in DPI 96
                "lods": [{"level": 0,"scale": 591657527.591555,"resolution": 156543.033928
                }, {"level": 1,"scale": 295828763.795777,"resolution": 78271.5169639999
                }, {"level": 2,"scale": 147914381.897889,"resolution": 39135.7584820001
                }, {"level": 3,"scale": 73957190.948944,"resolution": 19567.8792409999
                }, {"level": 4,"scale": 36978595.474472,"resolution": 9783.93962049996
                }, {"level": 5,"scale": 18489297.737236,"resolution": 4891.96981024998
                }, {"level": 6,"scale": 9244648.868618,"resolution": 2445.98490512499
                }, {"level": 7,"scale": 4622324.434309,"resolution": 1222.99245256249
                }, {"level": 8,"scale": 2311162.217155,"resolution": 611.49622628138
                }, {"level": 9,"scale": 1155581.108577,"resolution": 305.748113140558
                }, {"level": 10,"scale": 577790.554289,"resolution": 152.874056570411
                }, {"level": 11,"scale": 288895.277144,"resolution": 76.4370282850732
                }, {"level": 12,"scale": 144447.638572,"resolution": 38.2185141425366
                }, {"level": 13,"scale": 72223.819286,"resolution": 19.1092570712683
                }, {"level": 14,"scale": 36111.909643,"resolution": 9.55462853563415
                }, {"level": 15,"scale": 18055.954822,"resolution": 4.77731426794937
                }, {"level": 16,"scale": 9027.977411,"resolution": 2.38865713397468
                }, {"level": 17,"scale": 4513.988705,"resolution": 1.19432856685505
                }, {"level": 18,"scale": 2256.994353,"resolution": 0.597164283559817
                }, {"level": 19,"scale": 1128.497176,"resolution": 0.298582141647617
                }]
            });
            this.loaded = true;
            this.onLoad(this);
        },
        getTileUrl: function(level, row, col){
            return "http://mt" + (col % 4) + ".google.cn/vt/lyrs=s@112&hl=zh-CN&gl=cn&" + "x=" + col + "&" +
                "y=" +
                row +
                "&" +
                "z=" +
                level +
                "&s=";
        }
    });


    //注记图层
    dojo.declare("GoogleMapAnooLayer", esri.layers.TiledMapServiceLayer, { // create WMTSLayer by extending esri.layers.TiledMapServiceLayer
        constructor: function(){
            this.spatialReference = new esri.SpatialReference({
                wkid: 102113
            });
            this.initialExtent = new esri.geometry.Extent(-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787, this.spatialReference);
            this.fullExtent = new esri.geometry.Extent(-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787, this.spatialReference);
            //
            this.tileInfo = new esri.layers.TileInfo({
                "dpi": "90.71428571427429",
                "format": "image/png",
                "compressionQuality": 0,
                "spatialReference": {
                    "wkid": "3857"
                },
                "rows": 256,
                "cols": 256,
                "origin": {
                    "x": -20037508.342787,
                    "y": 20037508.342787
                },

                // Scales in DPI 96
                "lods": [{"level": 0,"scale": 591657527.591555,"resolution": 156543.033928
                }, {"level": 1,"scale": 295828763.795777,"resolution": 78271.5169639999
                }, {"level": 2,"scale": 147914381.897889,"resolution": 39135.7584820001
                }, {"level": 3,"scale": 73957190.948944,"resolution": 19567.8792409999
                }, {"level": 4,"scale": 36978595.474472,"resolution": 9783.93962049996
                }, {"level": 5,"scale": 18489297.737236,"resolution": 4891.96981024998
                }, {"level": 6,"scale": 9244648.868618,"resolution": 2445.98490512499
                }, {"level": 7,"scale": 4622324.434309,"resolution": 1222.99245256249
                }, {"level": 8,"scale": 2311162.217155,"resolution": 611.49622628138
                }, {"level": 9,"scale": 1155581.108577,"resolution": 305.748113140558
                }, {"level": 10,"scale": 577790.554289,"resolution": 152.874056570411
                }, {"level": 11,"scale": 288895.277144,"resolution": 76.4370282850732
                }, {"level": 12,"scale": 144447.638572,"resolution": 38.2185141425366
                }, {"level": 13,"scale": 72223.819286,"resolution": 19.1092570712683
                }, {"level": 14,"scale": 36111.909643,"resolution": 9.55462853563415
                }, {"level": 15,"scale": 18055.954822,"resolution": 4.77731426794937
                }, {"level": 16,"scale": 9027.977411,"resolution": 2.38865713397468
                }, {"level": 17,"scale": 4513.988705,"resolution": 1.19432856685505
                }, {"level": 18,"scale": 2256.994353,"resolution": 0.597164283559817
                }, {"level": 19,"scale": 1128.497176,"resolution": 0.298582141647617
                }]
            });
            this.loaded = true;
            this.onLoad(this);
        },
        getTileUrl: function(level, row, col){
            return "http://mt" + (col % 4) + ".google.cn/vt/lyrs=h@177000000&hl=zh-CN&gl=cn&" + "x=" + col + "&" +
                "y=" +
                row +
                "&" +
                "z=" +
                level +
                "&s=";
        }
    });
}
//图层顺序
function resortMapLayers(obj){
    var tempStr="[";
    for(var i=0;i<=obj.length-1;i++){
        if(obj[i].layer!=null){
            tempStr+="{id:"+obj[i].layer.id+",index:"+obj[i].index+"},";
            app.map.reorderLayer(obj[i].layer,obj[i].index);//index越大,则优先级越高
        }
    }
    tempStr+="]";
    // console.log(tempStr);
}
