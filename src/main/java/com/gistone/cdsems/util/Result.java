package com.gistone.cdsems.util;

import java.util.List;

import net.sf.json.JSONArray;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 环境云平台返回结果响应结构
 * @author WangShanxi
 * @version v.0.1
 * @date 2017年2月22日
 */
@JsonIgnoreProperties
public class Result {

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务状态   返回码值为0代表返回结果正常，值大于0代表结果异常
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;

//	private Object rows;

	// 页数
	private Integer page;
	// 条数
	private Integer total;
	// 结果数组
	private List rows;



	public List getRows() {
		return rows;
	}


	public void setRows(List rows) {
		this.rows = rows;
	}

	/**
	 * 执行正常调用该方法
	 * @param data 返回的数据
	 * @return 环境云平台结果响应结构
	 */
	public static Result ok(Object data) {
		return new Result(data);
	}


	public static Result ok(List rows,Object data) {
		return new Result(rows, data);
	}



	/**
	 * 执行正常调用该方法
	 * @return 环境云平台结果响应结构
	 */
	public static Result ok() {
		return new Result(null);
	}

	/**
	 * 自定义状态码调用该方法
	 * @param status 自定义状态码
	 * @param msg 自定义信息
	 * @param data 自定义的数据
	 * @return 环境云平台结果响应结构
	 */
	public static Result build(Integer status, String msg, Object data) {
		return new Result(status, msg, data);
	}

	/**
	 * 自定义状态码调用该方法
	 * @param status 自定义状态码
	 * @param msg 自定义信息
	 * @return 环境云平台结果响应结构
	 */
	public static Result build(Integer status, String msg) {
		return new Result(status, msg, null);
	}



	/**
	 * 将json结果集转化为AmpcResult对象
	 *
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            AmpcResult中的object类型
	 * @return
	 */
	public static Result formatToPojo(String jsonData, Class<?> clazz) {
		//异常处理
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, Result.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg")
					.asText(), obj);
		} catch (Exception e) {
			//错误返回null
			return null;
		}
	}

	/**
	 * 将json结果集转化为AmpcResult对象
	 * 没有object对象的转化
	 * @param json
	 * @return
	 */
	public static Result format(String json) {
		try {
			return MAPPER.readValue(json, Result.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 *
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            集合中的类型
	 * @return
	 */
	public static Result formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory()
						.constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg")
					.asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}


    /**
     * 有参构造
     * @param status 状态码
     * @param msg 信息
     * @param data 响应数据
     */
	public Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public Result(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	/**
     * 有参构造
     * @param data 响应数据
     */
	public Result(Object data) {
		this.status = 0; //默认返回正常
		this.msg = "success";
		this.data = data;
	}

	public Result(List rows,Object data) {
		this.status = 0; //默认返回正常
		this.msg = "success";
		this.data = data;
		this.rows = rows;
	}
	/**
	 * 无参构造
	 */
	public Result() {}


	/**
	 * 以下是Getter And Setter 方法
	 */
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public static Result build(List rows,Integer total, Integer page) {
		return new Result(rows, total, page);
	}
	public Result(List rows,Integer total, Integer page) {
		this.rows = rows; //默认返回正常
		this.total = total;
		this.page = page;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}



}
