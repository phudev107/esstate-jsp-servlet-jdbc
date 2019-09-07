package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs, Class zClass){
		List<T> results = new ArrayList<>();		
			try {
				if(zClass.isAnnotationPresent(Entity.class)){			
					ResultSetMetaData resultSetMetaData= rs.getMetaData();			
					Field[] fields = zClass.getDeclaredFields();						
					while(rs.next()) {
						T object = (T) zClass.newInstance();
						// get gias tri 1 row trong resultset vaf set vao entity
						for (int i=0;i<resultSetMetaData.getColumnCount();i++)
						{
							String columnName = resultSetMetaData.getColumnName(i+1);
							Object columnVlue = rs.getObject(i+1);
							//current class
							convertResultSetToEntity(fields, columnName,columnVlue,object);
							//parent class
							Class<?> parentClass= zClass.getSuperclass();
							while (parentClass!= null) {
								Field[] fieldParents = parentClass.getDeclaredFields();
								// convert data logic								
								convertResultSetToEntity(fieldParents, columnName,columnVlue,object);
								parentClass = parentClass.getSuperclass();
								}						
					}
						results.add(object);
				}
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return results;
	}

	private void convertResultSetToEntity(Field[] fields, String columnName, Object columnVlue, T object) throws IllegalAccessException, InvocationTargetException {
		for(Field field:fields)
		{
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getDeclaredAnnotation(Column.class);
				if(column.name().equals(columnName) && columnVlue!= null){
					BeanUtils.setProperty(object, field.getName(), columnVlue);
					break;
				}
			}		
		}
		
	}
}
