package com.liuzibin.pojo.dto;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.liuzibin.util.WebConstants;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"curOperator"})
public class BaseVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 状态码: 成功、失败、或其他待定异常*/
	private String resultCode;
	/** 提示信息*/
	private String resultMessage;
	/** 关键字 */
	private String keyword;	 
	
	private Integer ostype;//来源哪个系统端调用？1-pc 2-android 3-iOS 4-wechat 5-h5 6-3dprint
	private String storeName;
	private String accessToken;
	private Integer userFrom;//1用户2后台运营人员3第三方调用
	private String visitIp;
	private List<?> functionsList;
	private JSONObject curOperator;//当前操作者
	private int pageSize=10;//默认为10
	private int pageNo=1;//默认查看第1页
	private String orderByClause;

    protected Page page;
    
    private String errcode;
    
    private String errmsg;
	
	/** 标记错误*/
	public void markErrorResultCode(){
		resultCode = WebConstants.ERROR_CODE;
	}
	/** 标记Token错误*/
	public void markTokenErrorResultCode(){
		resultCode = WebConstants.TOKEN_ERROR;
	}
	/** 标记Token错误*/
	public void markNotExistErrorResultCode(){
		resultCode = WebConstants.NOT_EXIST_ERROR;
	}
	/** 标记未授权错误*/
	public void markNotAcceptErrorResultCode(){
		resultCode = WebConstants.NOT_ACCEPT_ERROR;
	}		
	/** 标记成功*/
	public void markSuccessResultCode(){
		resultCode = WebConstants.SUCCESS_CODE;
	}
	/** 标记成功但是有警告*/
	public void markSuccessResultCodeWithWarning(){
		resultCode = WebConstants.SUCCESS_CODE_WITH_WARNING;
	}
	
	public BaseVo(){
		
	}
	public String getResultCode() {
		return resultCode;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Integer getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(Integer userFrom) {
		this.userFrom = userFrom;
	}
	public JSONObject getCurOperator() {
		return curOperator;
	}
	public void setCurOperator(JSONObject curOperator) {
		this.curOperator = curOperator;
	}
	public Integer getOstype() {
		return ostype;
	}
	public void setOstype(Integer ostype) {
		this.ostype = ostype;
	}
	public String getVisitIp() {
		return visitIp;
	}
	public void setVisitIp(String visitIp) {
		this.visitIp = visitIp;
	}
	public String getStoreName(){ return storeName ;}
	public void setStoreName(String storeName){ this.storeName=storeName;}

	public List<?> getFunctionsList() {
		return functionsList;
	}

	public void setFunctionsList(List<?> functionsList) {
		this.functionsList = functionsList;
	}
}
