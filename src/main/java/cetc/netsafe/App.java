package cetc.netsafe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * 启动部件
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
@MapperScan(basePackages="cetc.netsafe.modules.*.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App {
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
}
