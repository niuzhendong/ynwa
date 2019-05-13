package cetc.netsafe.datasource.annotation;

public enum DataSourceType {
	
	Neo4j("neo4j"),
	Mysql("mysql"),
	postgres("postgres"),
	Hive("hive");

 
	private String name;
 
	DataSourceType(String name) {
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
}
