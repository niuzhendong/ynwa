package cetc.netsafe.datasource.annotation;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据源实体类
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceBean {
	
    //neo4j配置
	private Map<String,String> neo4j;
    //mysql 配置
	private Map<String,String> mysql;
	//postgres配置
	private Map<String,String> postgres;
	//hive配置
	private Map<String,String> hive;

	
    public Map<String, String> getMysql() {
		return mysql;
	}
	public void setMysql(Map<String, String> mysql) {
		this.mysql = mysql;
	}
	public Map<String, String> getPostgres() {
		return postgres;
	}
	public void setPostgres(Map<String, String> postgres) {
		this.postgres = postgres;
	}
	public Map<String, String> getNeo4j() {
		return neo4j;
	}
	public void setNeo4j(Map<String, String> neo4j) {
		this.neo4j = neo4j;
	}
	public Map<String,String> getHive() {
		return hive;
	}
	public void setHive(Map<String,String> hive) {
		this.hive = hive;
	}
}
