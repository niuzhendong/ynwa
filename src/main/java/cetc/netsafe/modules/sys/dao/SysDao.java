package cetc.netsafe.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface SysDao {

	boolean save(int id);

	List<Map<Object,Object>> findById(long id);
	
}
