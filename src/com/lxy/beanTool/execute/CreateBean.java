package com.lxy.beanTool.execute;

import com.lxy.beanTool.bean.BeanData;
import com.lxy.beanTool.util.Format;

import java.util.List;
import java.util.Map;

/**
 * @Title: CreateBean.java <br />
 * @Description: 创建bean相关方法 <br />
 * <br />
 * @author: lxy <br />
 */
public class CreateBean extends Format {
	
	/**
	 *@Description：创建属性行，格式：private 类型 属性名; //注释.<br />
	 * @param bean
	 * @return
	 */
	private static StringBuffer createProperty(BeanData bean) {
		StringBuffer str = new StringBuffer();
		str.append("\tprivate " + bean.getPType() + " " + bean.getPName() + ";"
				+ " ");
		str.append("//" + bean.getRemark() + "." + "\n");
		return str;
	}

	/**
	 *@Description：创建set方法<br />
	 * @param bean
	 * @return
	 */
	private static StringBuffer createSetMethod(BeanData bean) {
		StringBuffer str = new StringBuffer();
		str.append("\t/**\n");
		str.append("\t * 设定" + bean.getRemark() + "." + " " + "<br />" + "\n");
		str.append("\t *\n");
		str.append("\t * @param " + bean.getPName() + " " + bean.getRemark()
				+ "\n");
		str.append("\t */\n");
		str.append("\tpublic void set" + toUpperCase(bean.getPName()) + "("
				+ bean.getPType() + " " + bean.getPName() + ")" + " " + "{"
				+ "\n");
		str.append("\n");
		str.append("\t\tthis." + bean.getPName() + " " + "=" + " "
				+ bean.getPName() + ";" + "\n");
		str.append("\t}\n\n");
		return str;
	}

	/**
	 *@Description：创建get方法<br />
	 * @param bean
	 * @return
	 */
	private static StringBuffer createGetMethod(BeanData bean) {
		StringBuffer str = new StringBuffer();
		str.append("\t/**\n");
		str.append("\t * 取得" + bean.getRemark() + "." + " " + "<br />" + "\n");
		str.append("\t *\n");
		str.append("\t * @return " + bean.getRemark() + "\n");
		str.append("\t */\n");
		str.append("\tpublic " + bean.getPType() + " " + "get"
				+ toUpperCase(bean.getPName()) + "(" + ")" + " " + "{" + "\n");
		str.append("\n");
		str.append("\t\treturn " + bean.getPName() + ";" + "\n");
		str.append("\t}\n\n");
		return str;
	}

	/**
	 *@Description：创建包名<br />
	 * @param packName
	 * @return
	 */
	private static StringBuffer createPackage(String packName) {
		StringBuffer str = new StringBuffer();
		str.append("package " + packName + ";" + "\n" + "\n");
		return str;
	}

	/**
	 *@Description：生成bean类<br />
	 * @param beanList 属性列表
	 * @param createType 创建类型,1:不带包名类名;2:带包名类名
	 * @param fileMap 包名类名参数
	 * @return
	 */
	public static String createBean(List<BeanData> beanList, int createType,
			Map<String, String> fileMap) {
		StringBuffer str = new StringBuffer();
		if (createType == 2) {
			str.append(createPackage((String) fileMap.get("packName")));
			str.append("public class " + (String) fileMap.get("fileName") + "{"
					+ "\n");
		}
		for (BeanData beanData : beanList) {
			str.append(createProperty(beanData));
		}
		for (BeanData beanData2 : beanList) {
			str.append(createSetMethod(beanData2));
			str.append(createGetMethod(beanData2));
		}

		if (createType == 2) {
			str.append("}");
		}
		return str.toString();
	}
}
