package cetc.netsafe.datasource.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import cetc.netsafe.datasource.annotation.DataSourceBean;
import cetc.netsafe.datasource.aspect.DynamicDataSource;
import cetc.netsafe.datasource.utils.DataSourceUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
 
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
/**
 * 数据库配置
 */
@Configuration
public class DataSourceConfig {
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
 
	@Autowired
	private DataSourceBean dataSourceBean;
 
	@Bean(name = "dynamicDataSource")
	@Primary  //优先使用，多数据源
	public DataSource dataSource(){
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		//配置多个数据源
		Map<Object,Object> map = new HashMap<>();
 
		List<String> fields = DataSourceUtil.getClassFields(DataSourceBean.class);
		int i = 0;
		for (String field:fields){
			Map<String,String> config = null;
			try {
				config = (Map<String, String>) DataSourceUtil.getFieldValueByName(field,dataSourceBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (config == null){
				logger.error("数据源配置失败:"+field);
				continue;
			}
			try {
				DataSource dataSource = DataSourceUtil.getDataSource(config);
				if (i == 0){
					logger.info("设置默认数据源："+field);
					dynamicDataSource.setDefaultTargetDataSource(dataSource);
				}
				map.put(field,DataSourceUtil.getDataSource(config));
				logger.info("链接数据库："+field);
				i++;
			} catch (SQLException e) {
				logger.error("druid configuration initialization filter", e);
			}
		}
		logger.info("共配置了"+i+"个数据源");
		dynamicDataSource.setTargetDataSources(map);
		return dynamicDataSource;
	}
 
	@Bean(name="druidServlet")
	public ServletRegistrationBean<StatViewServlet> druidServlet() {
		ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<StatViewServlet>();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("allow", ""); //白名单
		return reg;
	}
 
	@Bean(name = "filterRegistrationBean")
	public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
