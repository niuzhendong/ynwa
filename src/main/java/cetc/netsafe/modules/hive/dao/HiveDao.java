package cetc.netsafe.modules.hive.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * HiveDao
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
@Repository
public interface HiveDao {
	List<Map<String, String>> findOneMovie(long id);
}
