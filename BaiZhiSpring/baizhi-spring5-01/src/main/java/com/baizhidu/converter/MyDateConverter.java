package com.baizhidu.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Converter<原始类型, 目标类型>
public class MyDateConverter implements Converter<String, Date> {
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /*
    * param:配置文件中对应的原始数据
    * return:转换好的目标值
    * */
    public Date convert(String s) {
        Date date=null;
        try {
            SimpleDateFormat sf=new SimpleDateFormat(pattern);
            date=sf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
