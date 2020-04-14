package com.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 12:52
 */
public class StringHandler {
	public static String timeTostr(Date date) {
		String strDate = "";
		if(date != null){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strDate = format.format(date);
		}
		return strDate;
	}

	public static String getSerial(Date date, int index) {
		long msel = date.getTime();		//获取毫秒数
		SimpleDateFormat fm = new SimpleDateFormat("MMddyyyyHHmmssSS");		//创建转换对象
		msel += index;					//通过一个值改变毫秒数
		date.setTime(msel);				//通过改变后的毫秒数重新设置日期
		String serials = fm.format(date);	//转换日期时间型数据为“MMddyyyyHHmmssSS”格式
		return serials;
	}

	public static String changehtml(String str) {
		String change = "";
		if(str !=null && !str.equals("")) {
			change=str.replace("&","&amp;");
			change=change.replace(" ","&nbsp;");
			change=change.replace("<","&lt;");
			change=change.replace(">","&gt;");
			change=change.replace("\"","&quot;");
			change=change.replace("\r\n","<br>");
		}
		return change;
	}
}