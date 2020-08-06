package com.liuzibin.util;

/**
 * @auth JiteShen
 系统常量类
 **/

public final class WebConstants {
    public static final String PROJECT_NAME="CMHG2";
    /** 系统*/
    public static final String STR_ERROR="ERROR";
    public static final String ERROR_CODE = "500";	//错误编码
    public static final String SUCCESS_CODE = "200";	//成功
    public static final String SUCCESS_STR = "SUCCESS";	//成功
    public static final String SUCCESS_CODE_WITH_WARNING = "201";	//成功但是有警告信息
    public static final String TOKEN_ERROR = "401";//登录超时或未登录
    public static final String NOT_EXIST_ERROR = "404";//不存在
    public static final String NOT_ACCEPT_ERROR = "406";//未授权，不接受访问 
    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String CHARSET = "UTF-8";
    public static final String VSERION = "1.0";	
    public static final String UNDERSCORE="_";
    public static final String DASH="-";
	public static final Integer DATA_INSERT_STATUS = new Integer(0);
	public static final String  DATA_INSERT_STATUS_STR="INSERT";
    public static final Integer DATA_DELETE_STATUS = new Integer(9);    //删除
	public static final String  DATA_DELETE_STATUS_STR="DELETE";
    public static final Integer DATA_FROZEN_STATUS = new Integer(6);   //冻结
	public static final String  DATA_FROZEN_STATUS_STR="FROZEN";
    public static final Integer MAGIC_NUMBER_ONE = new Integer(1);	
    public static final Integer MAGIC_NUMBER_TEN_THOUSAND = new Integer(10000);

    //用户分类 普通用户
    public static final String USER_GROUP_ORDINARY="ordinary";

    public static final String USER_GROUP_ADMINISTRATOR="administrator";



}


