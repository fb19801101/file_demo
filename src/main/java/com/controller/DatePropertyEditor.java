package com.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Date日期转换规则
 * @author
 */
public class DatePropertyEditor extends PropertyEditorSupport {
	private String datePattern;

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@Override
	public String getAsText() {
		Object obj = getValue();
		if (obj == null || !(obj instanceof Date)) {
			return null;
		}

		return super.getAsText();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Date date = new Date(System.currentTimeMillis());
			if (text != null && text.length() > 0) {
				SimpleDateFormat format = new SimpleDateFormat(datePattern);
				date = format.parse(text);
			}
			setValue(date);
		} catch( Exception e) {
			System.out.println("日期格式不对");
		}
	}
}