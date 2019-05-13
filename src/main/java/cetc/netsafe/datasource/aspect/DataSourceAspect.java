package cetc.netsafe.datasource.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cetc.netsafe.datasource.annotation.DataSource;
import cetc.netsafe.datasource.annotation.DataSourceType;
import cetc.netsafe.datasource.config.JdbcContextHolder;

import java.lang.reflect.Method;
 
/**
 * AOP根据注解给上下文赋值
 */
@Aspect
@Order(3)
@Component
public class DataSourceAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
 
	//切点
	@Pointcut("execution(* cetc.netsafe.modules.*.service..*(..)))")
	public void aspect(){
		logger.info("aspect");
	}
 
	@Before("aspect()")
	private void before(JoinPoint joinPoint){
		Object target = joinPoint.getTarget();
		String method = joinPoint.getSignature().getName();
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = classz.getMethod(method,parameterTypes);
			if (m != null && m.isAnnotationPresent(DataSource.class)){
				DataSource data = m.getAnnotation(DataSource.class);
				JdbcContextHolder.putDataSource(data.value().getName());
				logger.info("===============上下文赋值完成:"+data.value().getName());
			}else{
				JdbcContextHolder.putDataSource(DataSourceType.Neo4j.getName());
				logger.info("===============使用默认数据源:"+DataSourceType.Neo4j.getName());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
