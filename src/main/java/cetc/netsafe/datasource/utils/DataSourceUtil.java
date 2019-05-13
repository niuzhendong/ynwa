package cetc.netsafe.datasource.utils;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataSourceUtil {
	/**
	 * 获取指定类的成员变量
	 * @param clazz
	 * @return 成员变量名的List
	 */
	public static List<String> getClassFields(Class clazz){
		List<String> list = new ArrayList<>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields){
			list.add(field.getName());
		}
		return list;
	}
 
	/**
	 * 依据成员变量获取值
	 * @param fieldName 变量名
	 * @param o 已注入的实体
	 * @return Object
	 * @throws Exception 抛出异常
	 */
	public static Object getFieldValueByName(String fieldName, Object o) throws Exception{
		String firstLetter = fieldName.substring(0, 1).toUpperCase();
		String getter = "get" + firstLetter + fieldName.substring(1);
		Method method = o.getClass().getMethod(getter, new Class[] {});
		Object value = method.invoke(o, new Object[] {});
		return value;
	}
 
	/**
	 * 依据数据配置 获取datasource 对象
	 * @param params Map 数据配置
	 * @return 返回datasource
	 * @throws SQLException 抛出Sql 异常
	 */
	public static DataSource getDataSource(Map<String,String> params) throws SQLException {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(params.get("url"));
		datasource.setUsername(params.get("username"));
		datasource.setPassword(params.get("password"));
		datasource.setDriverClassName(params.get("driverClassName"));
		if (params.containsKey("initialSize")) {
			datasource.setInitialSize(Integer.parseInt(params.get("initialSize")));
		}
		if (params.containsKey("minIdle")) {
			datasource.setMinIdle(Integer.parseInt(params.get("minIdle")));
		}
		if (params.containsKey("maxActive")) {
			datasource.setMaxActive(Integer.parseInt(params.get("maxActive")));
		}
		if (params.containsKey("maxWait")){
			datasource.setMaxWait(Long.parseLong(params.get("maxWait")));
		}
		if (params.containsKey("timeBetweenEvictionRunsMillis")){
			datasource.setTimeBetweenEvictionRunsMillis(Long.parseLong(params.get("timeBetweenEvictionRunsMillis")));
		}
		if (params.containsKey("minEvictableIdleTimeMillis")){
			datasource.setMinEvictableIdleTimeMillis(Long.parseLong(params.get("minEvictableIdleTimeMillis")));
		}
		if (params.containsKey("validationQuery")){
			datasource.setValidationQuery(params.get("validationQuery"));
		}
		if (params.containsKey("testWhileIdle")){
			datasource.setTestWhileIdle(Boolean.parseBoolean(params.get("testWhileIdle")));
		}
		if (params.containsKey("testOnBorrow")){
			datasource.setTestOnBorrow(Boolean.parseBoolean(params.get("testOnBorrow")));
		}
		if (params.containsKey("testOnReturn")){
			datasource.setTestOnBorrow(Boolean.parseBoolean(params.get("testOnReturn")));
		}
		if (params.containsKey("poolPreparedStatements")){
			datasource.setPoolPreparedStatements(Boolean.parseBoolean(params.get("poolPreparedStatements")));
		}
		if (params.containsKey("maxPoolPreparedStatementPerConnectionSize")){
			datasource.setMaxPoolPreparedStatementPerConnectionSize(
					Integer.parseInt(params.get("maxPoolPreparedStatementPerConnectionSize")));
		}
		if (params.containsKey("filters")){
			datasource.setFilters(params.get("filters"));
		}
		if (params.containsKey("connectionProperties")){
			datasource.setConnectionProperties(params.get("connectionProperties"));
		}
		return datasource;
	}
}
