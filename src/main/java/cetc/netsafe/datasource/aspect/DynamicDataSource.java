package cetc.netsafe.datasource.aspect;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import cetc.netsafe.datasource.annotation.DataSourceType;
import cetc.netsafe.datasource.config.JdbcContextHolder;

public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		String dbName = JdbcContextHolder.getDataSource();
		if (dbName == null ){
			dbName =  DataSourceType.Neo4j.getName();
		}
		logger.info("=============当前数据源为："+dbName);
		return dbName;
	}
}
