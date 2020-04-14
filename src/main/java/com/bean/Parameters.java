package com.bean;

import java.util.HashMap;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 12:52
 */
public class Parameters {
    private HashMap fields;					//存储表单中其他字段的值

    public Parameters() {
        fields = new HashMap();
    }

    public String getFieldValue(String name) {
        String fieldvalue = "";
        HashMap values = (HashMap)fields.get(name);
        if(values!=null) {
            fieldvalue = (String) values.get("0");
        }
        return fieldvalue;
    }

    public String[] getFieldAllValue(String name) {
        String[] fieldallvalues = null;
        HashMap values=(HashMap)fields.get(name);
        if(values!=null) {
            fieldallvalues = new String[values.size()];
        }
        for(int i=0;i<values.size();i++) {
            fieldallvalues[i] = (String) values.get(i);
        }
        return fieldallvalues;
    }

    protected void setFields(String name, String value) {
        if(fields.containsKey(name)) {
            HashMap field = (HashMap)fields.get(name);
            field.put(String.valueOf(field.size()),value);
        }
        else {
            HashMap values = new HashMap();
            values.put("0",value);
            fields.put(name,values);
        }
    }
}