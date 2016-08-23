package com.lxy.beanTool.bean;

/**
 * @Title: BeanData.java <br />
 * @Description: 工具属性类 <br />
 * <br />
 * @author: lxy <br />
 */
public class BeanData{
	private String remark; //注释.
	private String pType; //数据类型.
	private String defaultValue; //默认值.
	private String packName; //包名.
	private String pName; //属性名.
	private String className; //类名.
	/**
	 * 设定注释. <br />
	 *
	 * @param remark 注释
	 */
	public void setRemark(String remark) {

		this.remark = remark;
	}

	/**
	 * 取得注释. <br />
	 *
	 * @return 注释
	 */
	public String getRemark() {

		return remark;
	}

	/**
	 * 设定数据类型. <br />
	 *
	 * @param pType 数据类型
	 */
	public void setPType(String pType) {

		this.pType = pType;
	}

	/**
	 * 取得数据类型. <br />
	 *
	 * @return 数据类型
	 */
	public String getPType() {

		return pType;
	}

	/**
	 * 设定默认值. <br />
	 *
	 * @param defaultValue 默认值
	 */
	public void setDefaultValue(String defaultValue) {

		this.defaultValue = defaultValue;
	}

	/**
	 * 取得默认值. <br />
	 *
	 * @return 默认值
	 */
	public String getDefaultValue() {

		return defaultValue;
	}

	/**
	 * 设定包名. <br />
	 *
	 * @param packName 包名
	 */
	public void setPackName(String packName) {

		this.packName = packName;
	}

	/**
	 * 取得包名. <br />
	 *
	 * @return 包名
	 */
	public String getPackName() {

		return packName;
	}

	/**
	 * 设定属性名. <br />
	 *
	 * @param pName 属性名
	 */
	public void setPName(String pName) {

		this.pName = pName;
	}

	/**
	 * 取得属性名. <br />
	 *
	 * @return 属性名
	 */
	public String getPName() {

		return pName;
	}

	/**
	 * 设定类名. <br />
	 *
	 * @param className 类名
	 */
	public void setClassName(String className) {

		this.className = className;
	}

	/**
	 * 取得类名. <br />
	 *
	 * @return 类名
	 */
	public String getClassName() {

		return className;
	}
}
