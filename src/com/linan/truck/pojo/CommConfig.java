package com.linan.truck.pojo;


import java.io.Serializable;

/**
 * 
 * 此实体类是通过逆向工程产生，禁止修改和继承
 * 基础数据配置表
 */
public class CommConfig implements Serializable{
	/**
	* serialVersionUID : TODO
	*/
	
	private static final long serialVersionUID = 1510969741235593520L;

	/**
	 * 配置ID
	 */
	private int id=0;

	/**
	 * 配置名（中文名）
	 */
	private String configNameZh="";

	/**
	 * 配置名（英文名） 
	 */
	private String configNameEn="";

	/**
	 * 配置类型 1：时间配置，2：金额配置 3：附近车货源公里数配置
	 */
	private int configType=0;
	private String configValueStr;

	/**
	 * 配置值 
	 */
	private int configValue=0;

	/**
	 * 是否启用 0:未启用 1:启用(默认)
	 */
	private int isEnable=0;

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}

	public void setConfigNameZh(String configNameZh){
		this.configNameZh=(null==configNameZh?"":configNameZh.trim());
	}
	public String getConfigNameZh(){
		return configNameZh;
	}

	public void setConfigNameEn(String configNameEn){
		this.configNameEn=(null==configNameEn?"":configNameEn.trim());
	}
	public String getConfigNameEn(){
		return configNameEn;
	}

	public void setConfigType(int configType){
		this.configType=configType;
	}
	public int getConfigType(){
		return configType;
	}

	public void setConfigValue(int configValue){
		this.configValue=configValue;
	}
	public int getConfigValue(){
		return configValue;
	}

	public void setIsEnable(int isEnable){
		this.isEnable=isEnable;
	}
	public int getIsEnable(){
		return isEnable;
	}
	/**
	 * 获取{@link String} configValueStr字段值 
	 *
	 */
	public String getConfigValueStr() {
		return configValueStr;
	}
	/**
	 * 设置{@link String} configValueStr字段值 
	 *
	 */
	public void setConfigValueStr(String configValueStr) {
		this.configValueStr = configValueStr;
	}
	/**
	 * 获取{@link long} serialversionuid字段值 
	 *
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
