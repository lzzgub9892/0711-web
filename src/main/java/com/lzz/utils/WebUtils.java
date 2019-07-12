package com.lzz.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	public static <T>T request2Bean(HttpServletRequest request,Class clazz){
		try {
			Object obj=clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				String fieldName=f.getName();
				String value=request.getParameter(fieldName);
				if(value!=null) {
					if(f.getType()==Integer.class||f.getType()==int.class) {
						f.set(obj, Integer.parseInt(value));
					}else if(f.getType()==Double.class||f.getType()==double.class) {
						f.set(obj, Double.parseDouble(value));
					}else if(f.getType()==Boolean.class||f.getType()==boolean.class) {
						f.set(obj, Boolean.parseBoolean(value));
					}else if(f.getType()==Byte.class||f.getType()==byte.class) {
						f.set(obj, Byte.parseByte(value));
					}else if(f.getType()==Character.class||f.getType()==char.class) {
						f.set(obj, value.toCharArray()[0]);
					}else if(f.getType()==Long.class||f.getType()==long.class) {
						f.set(obj, Long.parseLong(value));
					}else if(f.getType()==Short.class||f.getType()==short.class) {
						f.set(obj, Short.parseShort(value));
					}else if(f.getType()==Float.class||f.getType()==float.class) {
						f.set(obj, Float.parseFloat(value));
					}else if(f.getType()==String.class) {
						f.set(obj, value);
					}else if(f.getType()==Date.class) {
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						f.set(obj, sdf.parse(value));
					}
				}
			}
			return (T)obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
		
	}

}
