package com.gistone.cdsems.util;

import java.util.List;

@SuppressWarnings("all")
public class EdatResult {
	//常规返回参数
	// 响应业务状态   返回码值为0代表返回结果正常，值大于0代表结果异常
	private Integer status;
	
	// 响应消息
	private String msg;
	
	// 响应中的数据
	private Object data;
	
	//日志内容
	private String logContent;
	
	//bootstrap-table，分页返回参数
	// 结果数组
	private List rows;
	
	// 页数
	private Integer page;
	
	// 条数
	private Integer total;

	//空参构造
	public EdatResult() {
		super();
	}

	//常规构造
	public EdatResult(Integer status, String msg, Object data, String logContent) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.logContent = logContent;
	}

	//分页构造
	public EdatResult(List rows, Integer page, Integer total) {
		super();
		this.rows = rows;
		this.page = page;
		this.total = total;
	}
	
	public static EdatResult ok() {
		return new EdatResult(0,"成功",null,null);
	}
	
	public static EdatResult ok(Object data) {
		return new EdatResult(0,"成功",data,null);
	}
	
	public static EdatResult ok(String logContent) {
		return new EdatResult(0, "成功", null, logContent);
	}
	
	public static EdatResult ok(Object data, String logContent) {
		return new EdatResult(0, "成功", data, logContent);
	}
	
	public static EdatResult error(Integer status) {
		return new EdatResult(status,"失败",null, null);
	}
	
	public static EdatResult error( String msg) {
		return new EdatResult(1, msg ,null, null);
	}
	
	public static EdatResult error(Integer status, String msg) {
		return new EdatResult(status, msg ,null, null);
	}
	
	public static EdatResult error(Integer status, String msg, String logContent) {
		return new EdatResult(status, msg, null, logContent);
	}
	
	public static EdatResult build(Integer status, String msg) {
		return new EdatResult(status, msg ,null, null);
	}
	
	public static EdatResult build(Integer status, String msg, Object data, String logContent){
		return new EdatResult(status, msg, data, logContent);
	}
	
	public static EdatResult build(List rows, Integer page, Integer total){
		return new EdatResult(rows, page, total);
	}
	
	
	//GET、SET
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

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
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

	@Override
	public String toString() {
		return "EdatResult1 [status=" + status + ", msg=" + msg + ", data="
				+ data + ", logContent=" + logContent + ", rows=" + rows
				+ ", page=" + page + ", total=" + total + "]";
	}
	

	
	
	
	
	
}
